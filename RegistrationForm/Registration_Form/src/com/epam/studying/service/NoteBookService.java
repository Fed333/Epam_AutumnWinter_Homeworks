package com.epam.studying.service;

import com.epam.studying.entity.NoteBook;

import java.util.Objects;
import java.util.ResourceBundle;

import static com.epam.studying.service.RegexpConstants.REGEXP_NAME_VALID;
import static com.epam.studying.service.RegexpConstants.REGEXP_NICKNAME_VALID;

public class NoteBookService {

    private ResourceBundle bundle;

    public NoteBookService(ResourceBundle bundle) {
        Objects.requireNonNull(bundle);
        this.bundle = bundle;
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
}
