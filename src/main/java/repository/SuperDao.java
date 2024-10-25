package repository;

import java.sql.SQLException;
import java.util.List;

public interface SuperDao<T> {
    boolean add(T entity) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(String id) throws SQLException;
    T find(String id) throws SQLException;
    List<T> findAll() throws SQLException;
}
