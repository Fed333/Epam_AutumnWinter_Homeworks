package com.epam.studying.dao.impl;

public interface SQLQueriesConstants {

    String FIND_ALL_NOTE_BOOKS_QUERY = "SELECT id, subscriber_surname, subscriber_name, subscriber_patronymic, subscriber_nickname FROM note_books";
    String FIND_NOTE_BOOK_BY_SUBSCRIBER_NICKNAME_QUERY = FIND_ALL_NOTE_BOOKS_QUERY + " WHERE subscriber_nickname = ?";
    String FIND_NOTE_BOOK_BY_ID_QUERY = FIND_ALL_NOTE_BOOKS_QUERY + " WHERE id = ?;";
    String INSERT_NOTE_BOOK_QUERY = "INSERT INTO note_books (subscriber_surname, subscriber_name, subscriber_patronymic, subscriber_nickname) VALUES(?,?,?,?);";
    String UPDATE_NOTE_BOOK_BY_ID_QUERY = "UPDATE note_books SET subscriber_surname = ?, subscriber_name = ?, subscriber_patronymic = ?, subscriber_nickname = ? WHERE id = ?;";
}
