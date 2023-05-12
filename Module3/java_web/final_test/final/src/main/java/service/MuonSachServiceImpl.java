package service;

import model.MuonSach;
import repository.IMuonSachRepository;
import repository.MuonSachRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class MuonSachServiceImpl implements IMuonSachService{
    IMuonSachRepository iMuonSachRepository = new MuonSachRepositoryImpl();

    @Override
    public List<MuonSach> findAll() {
        return iMuonSachRepository.findAll();
    }

    @Override
    public List<MuonSach> findAllBook() {
        return iMuonSachRepository.findAllBook();
    }

    @Override
    public void save(MuonSach muonSach) throws SQLException {
        iMuonSachRepository.save(muonSach);
    }

    @Override
    public boolean update(MuonSach muonSach) throws SQLException {
        return iMuonSachRepository.update(muonSach);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return iMuonSachRepository.delete(id);
    }

    @Override
    public MuonSach findById(int id) {
        return iMuonSachRepository.findById(id);
    }

    @Override
    public List<MuonSach> searchByNameStudent(String name) {
        return iMuonSachRepository.searchByNameStudent(name);
    }

    @Override
    public List<MuonSach> searchByNameBook(String name) {
        return iMuonSachRepository.searchByNameBook(name);
    }
}
