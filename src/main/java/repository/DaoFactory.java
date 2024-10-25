package repository;

import repository.Customer.impl.CustomerDaoImpl;
import repository.Customer.impl.ItemDaoImpl;
import repository.Customer.impl.UserDaoImpl;

public class DaoFactory {
    // Enum to define the DAO types supported by the factory
    public enum DaoType {
        CUSTOMER, ITEM, USER
    }

    // Factory method to return the appropriate DAO implementation
    public static SuperDao getDao(DaoType daoType) {
        switch (daoType) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case USER:
                return new UserDaoImpl();
            default:
                return null; // Return null if no matching type is found
        }
    }
}
