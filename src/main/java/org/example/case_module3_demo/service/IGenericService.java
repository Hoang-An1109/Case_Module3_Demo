package org.example.case_module3_demo.service;

import java.sql.SQLException;
import java.util.List;

public interface IGenericService<Generic> {
    public void insertInto(Generic generic) throws SQLException;

    public Generic selectById(String id);

    public List<Generic> selectAll();

    public boolean deleteById(String id) throws SQLException;

    public boolean update(Generic generic) throws SQLException;
}
