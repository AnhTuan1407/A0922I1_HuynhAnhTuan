package repository;

import model.MuonSach;

import java.sql.SQLException;
import java.util.List;

public interface IMuonSachRepository {
    List<MuonSach> findAll();

    List<MuonSach> findAllBook();

    void save(MuonSach muonSach) throws SQLException;

    boolean update(MuonSach muonSach) throws SQLException;

    boolean delete(int id) throws SQLException;

    MuonSach findById(int id);

    List<MuonSach> searchByNameStudent(String name);

    List<MuonSach> searchByNameBook(String name);
}
