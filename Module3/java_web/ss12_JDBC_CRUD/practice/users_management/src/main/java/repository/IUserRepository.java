package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    List<User> findAll();

    void save(User user) throws SQLException;

    boolean update(int id) throws SQLException;

    boolean delete(int id) throws SQLException;

    User findById(int id);
}
