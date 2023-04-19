package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements IStudentService{

    IStudentRepository iStudentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) throws SQLException {
        iStudentRepository.save(student);
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return iStudentRepository.update(student);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return iStudentRepository.delete(id);
    }

    @Override
    public Student findById(int id) {
        return iStudentRepository.findById(id);
    }
}
