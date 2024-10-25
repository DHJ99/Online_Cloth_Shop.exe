package repository.Customer.impl;

import entity.UserEntity;
import repository.Customer.UserDao;
import util.CrudUtil;  

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public UserEntity findUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";

        ResultSet rs = CrudUtil.execute(sql, username);

        if (rs.next()) {
            return new UserEntity(rs.getString("username"), rs.getString("password"));
        }
        return null;
    }

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
