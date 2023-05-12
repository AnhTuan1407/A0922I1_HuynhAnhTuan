package repository;

import model.BenhAn;

import java.sql.SQLException;
import java.util.List;

public interface IBenhAnRepository {
    List<BenhAn> findAll();

    void save(BenhAn benhAn) throws SQLException;

    boolean update(BenhAn benhAn) throws SQLException;

    boolean delete(String id) throws SQLException;

    BenhAn findById(String id);
}
