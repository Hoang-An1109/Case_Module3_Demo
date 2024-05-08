package org.example.case_module3_demo.service.client;

import org.example.case_module3_demo.model.Client;
import org.example.case_module3_demo.service.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IClientDAO{
private Connection connection = ConnectionDB.getConnection();
    private static final String INSERT_CLIENT_SQL = "insert into client(id_kh, ten_kh, cmt_kh, dien_thoai_kh, dia_chi_lh) values (?, ?, ?, ?, ?);";
    private static final String SELECT_CLIENT_BY_ID = "select * from client where id_kh = ?;";
    private static final String SELECT_ALL_CLIENT = "select * from client;";
    private static final String DELETE_CLIENT_BY_ID = "delete from client where id_kh = ?;";
    private static final String UPDATE_CLIENT_SQL = "update client set ten_kh=?, cmt_kh=?, dien_thoai_kh=?, dia_chi_lh=?  where id_kh = ?;";

    @Override
    public void insertInto(Client client) throws SQLException {
        System.out.println(INSERT_CLIENT_SQL);
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL);
        preparedStatement.setString(1, client.getId_kh());
        preparedStatement.setString(2, client.getTen_kh());
        preparedStatement.setInt(3, client.getCmt_kh());
        preparedStatement.setInt(4, client.getDien_thoai_kh());
        preparedStatement.setString(5, client.getDia_chi_lh());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    @Override
    public Client selectById(String id) {
        Client client = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID);
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String ten_kh = rs.getString("ten_kh");
                int cmt_kh = rs.getInt("cmt_kh");
                int dien_thoai_lh = rs.getInt("dien_thoai_kh");
                String dia_chi_lh = rs.getString("dia_chi_lh");
                client = new Client(id, ten_kh, cmt_kh, dien_thoai_lh, dia_chi_lh);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    @Override
    public List<Client> selectAll() {
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id_kh = rs.getString("id_kh");
                String ten_kh = rs.getString("ten_kh");
                int cmt_kh = rs.getInt("cmt_kh");
                int dien_thoai_kh = rs.getInt("dien_thoai_kh");
                String dia_chi_lh = rs.getString("dia_chi_lh");
                clients.add(new Client(id_kh, ten_kh, cmt_kh, dien_thoai_kh, dia_chi_lh));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    @Override
    public boolean deleteById(String id) throws SQLException {
        boolean rowDelete;
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_BY_ID);
        preparedStatement.setString(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public boolean update(Client client) throws SQLException {
        boolean rowUpdate;
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_SQL);
        preparedStatement.setString(1, client.getTen_kh());
        preparedStatement.setInt(2, client.getCmt_kh());
        preparedStatement.setInt(3, client.getDien_thoai_kh());
        preparedStatement.setString(4, client.getDia_chi_lh());
        preparedStatement.setString(5, client.getId_kh());

        rowUpdate = preparedStatement.executeUpdate() > 0;
        return rowUpdate;
    }
}
