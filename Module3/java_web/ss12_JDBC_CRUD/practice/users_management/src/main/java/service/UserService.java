package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{

    IUserRepository iUserRepository = new UserRepository();
    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) throws SQLException {
        iUserRepository.save(user);
    }

    @Override
    public boolean update(int id) throws SQLException {
        return iUserRepository.update(id);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return iUserRepository.delete(id);
    }

    @Override
    public User findById(int id) {
        return iUserRepository.findById(id);
    }
}
