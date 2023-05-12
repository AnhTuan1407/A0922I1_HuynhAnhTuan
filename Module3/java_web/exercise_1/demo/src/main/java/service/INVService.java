package service;

import model.NhanVien;

import java.sql.SQLException;
import java.util.List;

public interface INVService {
    List<NhanVien> findAll();

    void save(NhanVien nhanVien) throws SQLException;

    boolean update(NhanVien nhanVien) throws SQLException;

    boolean delete(int id) throws SQLException;

    NhanVien findById(int id);
}
