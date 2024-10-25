package repository.Customer.impl;

import repository.Customer.ItemDao;
import repository.SuperDao;

import java.sql.SQLException;
import java.util.List;

public class ItemDaoImpl implements ItemDao, SuperDao {
    @Override
    public boolean add(Object entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Object entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public Object find(String id) throws SQLException {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return List.of();
    }
}
