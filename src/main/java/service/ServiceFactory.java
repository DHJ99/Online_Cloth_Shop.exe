package service;

import service.customer.impl.CustomerServiceImpl;
import service.customer.impl.ItemServiceImpl;
import util.ServiceType;

public class ServiceFactory {
    private static ServiceFactory instance;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance == null ? instance = new ServiceFactory() : instance;
    }

    public <T extends SuperService> T getServiceType(ServiceType type) {
        return switch (type) {
            case CUSTOMER -> (T) new CustomerServiceImpl();
            case ITEM -> (T) new ItemServiceImpl();
            default -> null;
        };
    }
}
