package service;

import model.NhanVien;
import repository.INVRepository;
import repository.NVRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class NVServiceImpl implements INVService{

    INVRepository invRepository = new NVRepositoryImpl();

    @Override
    public List<NhanVien> findAll() {
        return invRepository.findAll();
    }

    @Override
    public void save(NhanVien nhanVien) throws SQLException {
        invRepository.save(nhanVien);
    }

    @Override
    public boolean update(NhanVien nhanVien) throws SQLException {
        return invRepository.update (nhanVien);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return invRepository.delete(id);
    }

    @Override
    public NhanVien findById(int id) {
        return invRepository.findById(id);
    }
}
