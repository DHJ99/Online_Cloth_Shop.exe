package service.customer.impl;

import entity.UserEntity;
import repository.Customer.UserDao;
import repository.DaoFactory;

import java.sql.SQLException;

public class UserServiceImpl {
    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = (UserDao) DaoFactory.getDao(DaoFactory.DaoType.USER);
    }

    public UserEntity getUserByUsername(String username) throws SQLException {
        return userDao.findUserByUsername(username);
    }

    public boolean authenicate(String username, String password) {
        try {
            UserEntity user = userDao.findUserByUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

