package repository.Customer;

import entity.UserEntity;
import repository.SuperDao;

import java.sql.SQLException;

public interface UserDao extends SuperDao {
    UserEntity findUserByUsername(String username) throws SQLException;
}
