package org.example.case_module3_demo.service.staff;

import org.example.case_module3_demo.model.Staff;
import org.example.case_module3_demo.service.ConnectionDB;
import org.example.case_module3_demo.service.staff.IStaffDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements IStaffDAO {

private Connection connection= ConnectionDB.getConnection();
    private static final String INSERT_STAFF_SQL = "insert into staff(id_nv, ten_nv, vai_tro, cmt_nv, dien_thoai_nv) values (?, ?, ?, ?, ?);";
    private static final String SELECT_STAFF_BY_ID = "select * from staff where id_nv = ?;";
    private static final String SELECT_ALL_STAFF = "select * from staff;";
    private static final String DELETE_STAFF_BY_ID = "delete from staff where id_nv = ?;";
    private static final String UPDATE_STAFF_SQL = "update staff set ten_nv=?, vai_tro=?, cmt_nv=?, dien_thoai_nv=?  where id_nv = ?;";
    @Override
    public void insertInto(Staff staff) throws SQLException {
        System.out.println(INSERT_STAFF_SQL);
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STAFF_SQL);
        preparedStatement.setString(1, staff.getId_nv());
        preparedStatement.setString(2, staff.getTen_nv());
        preparedStatement.setString(3, staff.getVai_tro());
        preparedStatement.setInt(4, staff.getCmt_nv());
        preparedStatement.setInt(5, staff.getDien_thoai_nv());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    @Override
    public Staff selectById(String id) {
        Staff staff = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STAFF_BY_ID);
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String ten_nv = rs.getString("ten_nv");
                String vai_tro = rs.getString("vai_tro");
                int cmt_nv = rs.getInt("cmt_nv");
                int dien_thoai_nv = rs.getInt("dien_thoai_nv");

                staff = new Staff(id, ten_nv, vai_tro, cmt_nv, dien_thoai_nv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staff;
    }

    @Override
    public List<Staff> selectAll() {
        List<Staff> staff = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFF);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id_nv = rs.getString("id_nv");
                String ten_nv = rs.getString("ten_nv");
                String vai_tro = rs.getString("vai_tro");
                int cmt_nv = rs.getInt("cmt_nv");
                int dien_thoai_nv = rs.getInt("dien_thoai_nv");

                staff.add(new Staff(id_nv, ten_nv, vai_tro, cmt_nv, dien_thoai_nv));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staff;
    }

    @Override
    public boolean deleteById(String id) throws SQLException {
        boolean rowDelete;
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STAFF_BY_ID);
        preparedStatement.setString(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public boolean update(Staff staff) throws SQLException {
        boolean rowUpdate;
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STAFF_SQL);
        preparedStatement.setString(1, staff.getTen_nv());
        preparedStatement.setString(2, staff.getVai_tro());
        preparedStatement.setInt(3, staff.getCmt_nv());
        preparedStatement.setInt(4, staff.getDien_thoai_nv());
        preparedStatement.setString(5, staff.getId_nv());

        rowUpdate = preparedStatement.executeUpdate() > 0;
        return rowUpdate;    }
}
