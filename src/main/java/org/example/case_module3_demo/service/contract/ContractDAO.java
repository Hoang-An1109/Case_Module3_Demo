package org.example.case_module3_demo.service.contract;

import org.example.case_module3_demo.model.Boarding_House;
import org.example.case_module3_demo.model.Client;
import org.example.case_module3_demo.model.Contract;
import org.example.case_module3_demo.model.Staff;
import org.example.case_module3_demo.service.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractDAO implements IContractDAO {
    private Connection connection = ConnectionDB.getConnection();
    private static final String INSERT_CONTRACT_SQL = "insert into contract(id_hop_dong, id_nha, id_kh, id_nv, ngay_hd, gia_thue, tien_dat_coc, dieu_khoan) values (?, ?, ?, ?, ?,?,?,?);";
    private static final String UPDATE_BOARDING_HOUSE_SQL = "update contract set trang_thai='Đã Thuê' where id_nha=?";
    private static final String SELECT_CONTRACT_BY_ID = "select * from contract where id_hop_dong = ?;";
    private static final String SELECT_ALL_CONTRACT = "select * from contract;";
    private static final String DELETE_CONTRACT_BY_ID = "delete from contract where id_hop_dong = ?;";
    private static final String UPDATE_CONTRACT_SQL = "update contract set id_nha=?, id_kh=?, id_nv=?, ngay_hd=?, gia_thue=?, tien_dat_coc=?, dieu_khoan=?  where id_hop_dong = ?;";

    @Override
    public void insertInto(Contract contract) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_CONTRACT_SQL);
        statement.setString(1, contract.getId_hop_dong());
        statement.setString(2, contract.getBoardingHouse().getId_nha());
        statement.setString(3, contract.getClient().getId_kh());
        statement.setString(4, contract.getStaff().getId_nv());
        java.util.Date ngayHdUtil = contract.getNgay_hd();
        java.sql.Date ngayHdSql = new java.sql.Date(ngayHdUtil.getTime());
        statement.setDate(5, ngayHdSql);
        statement.setDouble(6, contract.getGia_thue());
        statement.setDouble(7, contract.getTien_dat_coc());
        statement.setString(8, contract.getDieu_khoan());
        statement.executeUpdate();

        PreparedStatement statement1 = connection.prepareStatement(UPDATE_BOARDING_HOUSE_SQL);
        statement.setString(1, contract.getBoardingHouse().getId_nha());
        statement1.executeUpdate();
    }

    @Override
    public Contract selectById(String id) {
        Contract contract = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Boarding_House id_nha = (Boarding_House) rs.getObject("id_nha");
                Client id_kh = (Client) rs.getObject("id_kh");
                Staff id_nv = (Staff) rs.getObject("id_nv");
                Date ngay_hd = rs.getDate("ngay_hd");
                double gia_thue = rs.getDouble("gia_thue");
                double tien_dat_coc = rs.getDouble("tien_dat_coc");
                String dieu_khoan = rs.getString("dieu_khoan");
                contract = new Contract(id, id_nha, id_kh, id_nv, ngay_hd, gia_thue, tien_dat_coc, dieu_khoan);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }

    @Override
    public List<Contract> selectAll() {
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id_hop_dong = rs.getString("id_hop_dong");
                String id_nha =  rs.getString("id_nha");
                String id_kh = rs.getString("id_kh");
                String id_nv = rs.getString("id_nv");
                Date ngay_hd = rs.getDate("ngay_hd");
                double gia_thue = rs.getDouble("gia_thue");
                double tien_dat_coc = rs.getDouble("tien_dat_coc");
                String dieu_khoan = rs.getString("dieu_khoan");

                Boarding_House boardingHouse=new Boarding_House(id_nha);
                Client client=new Client(id_kh);
                Staff staff=new Staff(id_nv);

                contracts.add(new Contract(id_hop_dong, boardingHouse, client, staff, ngay_hd, gia_thue, tien_dat_coc, dieu_khoan));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contracts;
    }

    public static void main(String[] args) {
        ContractDAO contractDAO=new ContractDAO();
        List<Contract> contractList= contractDAO.selectAll();
        for (Contract contract: contractList){
            System.out.println(contract);
        }
    }

    @Override
    public boolean deleteById(String id) throws SQLException {
        boolean rowDelete;
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_BY_ID);
        preparedStatement.setString(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public boolean update(Contract contract) throws SQLException {
        boolean rowUpdate;
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT_SQL);
        preparedStatement.setString(1, contract.getBoardingHouse().getId_nha());
        preparedStatement.setString(2, contract.getClient().getId_kh());
        preparedStatement.setString(3, contract.getStaff().getId_nv());
        java.util.Date ngayHdUtil = contract.getNgay_hd();
        java.sql.Date ngayHdSql = new java.sql.Date(ngayHdUtil.getTime());
        preparedStatement.setDate(4, ngayHdSql);
        preparedStatement.setDouble(5, contract.getGia_thue());
        preparedStatement.setDouble(6, contract.getTien_dat_coc());
        preparedStatement.setString(7, contract.getDieu_khoan());
        preparedStatement.setString(8, contract.getId_hop_dong());

        rowUpdate = preparedStatement.executeUpdate() > 0;
        return rowUpdate;    }
}
