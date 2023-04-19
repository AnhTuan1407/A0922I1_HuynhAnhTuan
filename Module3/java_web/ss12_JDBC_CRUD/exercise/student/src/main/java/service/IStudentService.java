package service;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student) throws SQLException;

    boolean update(Student student) throws SQLException;

    boolean delete(int id) throws SQLException;

    Student findById(int id);
}
