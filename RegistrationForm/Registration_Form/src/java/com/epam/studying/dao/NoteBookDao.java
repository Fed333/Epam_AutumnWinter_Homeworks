package com.epam.studying.dao;

import com.epam.studying.entity.NoteBook;

import java.util.List;
import java.util.Optional;

public interface NoteBookDao {

    boolean save(NoteBook noteBook);
    Optional<NoteBook> findByNickname(String nickname);
    Optional<NoteBook> findById(Long id);
    Optional<List<NoteBook>>  findAll();
    boolean delete(NoteBook noteBook);
}
