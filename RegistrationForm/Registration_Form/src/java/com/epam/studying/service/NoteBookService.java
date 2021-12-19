package com.epam.studying.service;

import com.epam.studying.dao.NoteBookDao;
import com.epam.studying.dao.impl.NotUniqueNicknameException;
import com.epam.studying.entity.NoteBook;

import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.epam.studying.service.RegexpConstants.REGEXP_NAME_VALID;
import static com.epam.studying.service.RegexpConstants.REGEXP_NICKNAME_VALID;

public class NoteBookService {

    private final ResourceBundle bundle;

    private final NoteBookDao noteBookDao;

    public NoteBookService(ResourceBundle bundle, NoteBookDao noteBookDao) {
        Objects.requireNonNull(bundle);
        Objects.requireNonNull(noteBookDao);
        this.bundle = bundle;
        this.noteBookDao = noteBookDao;
    }

    public boolean isNameValid(String name){
        Objects.requireNonNull(name);
        return name.matches(bundle.getString(REGEXP_NAME_VALID));
    }

    public boolean isNickNameValid(String name) {
        Objects.requireNonNull(name);
        return name.matches(bundle.getString(REGEXP_NICKNAME_VALID));
    }

    public boolean setName(NoteBook note, String name) {
        if (isNameValid(name)){
            note.setNameOfSubscriber(name);
            return true;
        }
        return false;
    }

    public boolean setNickname(NoteBook note, String nickname){
        if (isNickNameValid(nickname)){
            note.setNickName(nickname);
            return true;
        }
        return false;
    }

    private boolean isNickNameUnique(NoteBook noteBook) {
        NoteBook foundNote = noteBookDao.findByNickname(noteBook.getNickName()).orElse(noteBook);
        if (foundNote == noteBook){
            return true;
        }
        Long noteBookId;
        try{
           noteBookId = noteBook.getId();
        }
        catch (NullPointerException e){
            noteBookId = null;
        }

        return foundNote.getId().equals(noteBookId);
    }

    public void save(NoteBook noteBook) throws SQLException {
        noteBookDao.save(noteBook);
    }

    public void requireUniqueNickname(NoteBook noteBook) throws NotUniqueNicknameException{
        String nickName = noteBook.getNickName();
        if (!isNickNameUnique(noteBook)){
            throw new NotUniqueNicknameException(nickName);
        }
    }
}
