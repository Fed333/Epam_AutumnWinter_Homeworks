package com.epam.studying.dao.impl;

import com.epam.studying.view.TextConstants;
import com.epam.studying.view.View;

import java.util.ResourceBundle;

public class NotUniqueNicknameException extends Exception {
    private String notUniqueNickname;
    private static final ResourceBundle bundle = View.bundle;

    public NotUniqueNicknameException(String notUniqueNickname) {
        super(createWarningMessage(notUniqueNickname));
        this.notUniqueNickname = notUniqueNickname;

    }

    private static String createWarningMessage(String notUniqueNickname) {
        return String.format(bundle.getString(TextConstants.INPUT_WARNING_NOT_UNIQUE_NICKNAME_FORMAT), notUniqueNickname);
    }


}
