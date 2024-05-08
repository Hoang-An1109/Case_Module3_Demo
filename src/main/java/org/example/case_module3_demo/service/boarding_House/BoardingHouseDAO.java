package org.example.case_module3_demo.service.boarding_House;

import org.example.case_module3_demo.model.Boarding_House;
import org.example.case_module3_demo.service.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardingHouseDAO implements IBoardingHouseDAO {
private Connection connection= ConnectionDB.getConnection();
    private static final String INSERT_BOARDING_HOUSE_SQL = "insert into boarding_house(id_nha, dia_chi, dien_tich, don_gia, trang_thai) values (?, ?, ?, ?, ?);";
    private static final String SELECT_BOARDING_HOUSE_BY_ID = "select * from boarding_house where id_nha = ?;";
    private static final String SELECT_ALL_BOARDING_HOUSE = "select * from boarding_house;";
    private static final String DELETE_BOARDING_HOUSE_BY_ID = "delete from boarding_house where id_nha = ?;";
    private static final String UPDATE_BOARDING_HOUSE_SQL = "update boarding_house set dia_chi=?, dien_tich=?, don_gia=?, trang_thai=?  where id_nha = ?;";

    @Override
    public void insertInto(Boarding_House boardingHouse) throws SQLException {
        System.out.println(INSERT_BOARDING_HOUSE_SQL);
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOARDING_HOUSE_SQL);
        preparedStatement.setString(1, boardingHouse.getId_nha());
        preparedStatement.setString(2, boardingHouse.getDia_chi());
        preparedStatement.setDouble(3, boardingHouse.getDien_tich());
        preparedStatement.setDouble(4, boardingHouse.getDon_gia());
        preparedStatement.setString(5, boardingHouse.getTrang_thai());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    @Override
    public Boarding_House selectById(String id) {
        Boarding_House boardingHouse = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOARDING_HOUSE_BY_ID);
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String dia_chi = rs.getString("dia_chi");
                double dien_tich = rs.getDouble("dien_tich");
                double don_gia = rs.getDouble("don_gia");
                String trang_thai = rs.getString("trang_thai");
                boardingHouse = new Boarding_House(id, dia_chi, dien_tich, don_gia, trang_thai);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return boardingHouse;
    }

    @Override
    public List<Boarding_House> selectAll() {
        List<Boarding_House> boardingHouses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOARDING_HOUSE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id_nha = rs.getString("id_nha");
                String dia_chi = rs.getString("dia_chi");
                double dien_tich = rs.getDouble("dien_tich");
                double don_gia = rs.getDouble("don_gia");
                String trang_thai = rs.getString("trang_thai");
                boardingHouses.add(new Boarding_House(id_nha, dia_chi, dien_tich, don_gia, trang_thai));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return boardingHouses;
    }

    @Override
    public boolean deleteById(String id) throws SQLException {
        boolean rowDelete;
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOARDING_HOUSE_BY_ID);
        preparedStatement.setString(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public boolean update(Boarding_House boardingHouse) throws SQLException {
        boolean rowUpdate;
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOARDING_HOUSE_SQL);
        preparedStatement.setString(1, boardingHouse.getDia_chi());
        preparedStatement.setDouble(2, boardingHouse.getDien_tich());
        preparedStatement.setDouble(3, boardingHouse.getDon_gia());
        preparedStatement.setString(4, boardingHouse.getTrang_thai());
        preparedStatement.setString(5, boardingHouse.getId_nha());

        rowUpdate = preparedStatement.executeUpdate() > 0;
        return rowUpdate;
    }
}
