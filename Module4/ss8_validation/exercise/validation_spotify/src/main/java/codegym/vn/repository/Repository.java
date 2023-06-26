package codegym.vn.repository;

import codegym.vn.entity.Music;

import java.util.List;

public interface Repository {
    List<Music> findAll();

    boolean create(Music music);

    boolean update(Music music);

    Music findById(int id);

    boolean delete(int id);
}
