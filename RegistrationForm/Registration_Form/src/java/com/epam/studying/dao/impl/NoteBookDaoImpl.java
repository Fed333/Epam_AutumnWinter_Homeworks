package com.epam.studying.dao.impl;

import com.epam.studying.dao.NoteBookDao;
import com.epam.studying.entity.NoteBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class NoteBookDaoImpl implements NoteBookDao {

    private Connection connection;

    public NoteBookDaoImpl(Connection connection) {
        Objects.requireNonNull(connection);
        this.connection = connection;
    }

    @Override
    public boolean save(NoteBook noteBook){
        if (Objects.isNull(noteBook)){
            return false;
        }
        Optional<NoteBook> noteBookOptional;
        try {
            noteBookOptional = findById(noteBook.getId());
        }
        catch (NullPointerException e){
            noteBookOptional = Optional.empty();
        }

        if (noteBookOptional.isEmpty()){
            return create(noteBook);
        }
        else{
            return update(noteBook);
        }
    }

    private boolean create(NoteBook noteBook){
        if (Objects.isNull(noteBook)){
            return false;
        }

        String SQLQuery = SQLQueriesConstants.INSERT_NOTE_BOOK_QUERY;
        try{
            PreparedStatement statement = connection.prepareStatement(SQLQuery);
            statement.setString(1, noteBook.getSurnameOfSubscriber());
            statement.setString(2, noteBook.getNameOfSubscriber());
            statement.setString(3, noteBook.getPatronymicOfSubscriber());
            statement.setString(4, noteBook.getNickName());
            statement.execute();
        }
        catch (SQLException e){
            System.out.println("Message: " + e.getMessage());
            System.err.println("SQLException was caught");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean update(NoteBook noteBook){
        if (Objects.isNull(noteBook)){
            return false;
        }
        String SQLQuery = SQLQueriesConstants.UPDATE_NOTE_BOOK_BY_ID_QUERY;
        try{
            PreparedStatement statement = connection.prepareStatement(SQLQuery);
            statement.setString(1, noteBook.getSurnameOfSubscriber());
            statement.setString(2, noteBook.getNameOfSubscriber());
            statement.setString(3, noteBook.getPatronymicOfSubscriber());
            statement.setString(4, noteBook.getNickName());

            statement.setLong(5, noteBook.getId());

            statement.execute();
        }
        catch (SQLException sql){

            return false;
        }
        return true;
    }

    @Override
    public Optional<NoteBook> findById(Long id) {
        String SQLQuery = SQLQueriesConstants.FIND_NOTE_BOOK_BY_ID_QUERY;
        Optional<NoteBook> noteBookOptional = Optional.empty();
        try{
            PreparedStatement statement = connection.prepareStatement(SQLQuery);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            noteBookOptional = Optional.ofNullable(parseResultSet(result).orElseThrow().get(0));
        }
        catch (SQLException e){
            System.err.println("Bad connection");
            e.printStackTrace();
        }
        catch (NoSuchElementException | IndexOutOfBoundsException e){
            noteBookOptional = Optional.empty();
        }
        return noteBookOptional;
    }

    @Override
    public Optional<NoteBook> findByNickname(String nickname) {
        String SQLQuery = SQLQueriesConstants.FIND_NOTE_BOOK_BY_SUBSCRIBER_NICKNAME_QUERY;
        Optional<NoteBook> noteBookOptional = Optional.empty();
        try{
            PreparedStatement statement = connection.prepareStatement(SQLQuery);
            statement.setString(1, nickname);
            ResultSet result = statement.executeQuery();
            noteBookOptional = Optional.ofNullable(parseResultSet(result).orElseThrow().get(0));
        }
        catch (SQLException e){
            System.err.println("Bad connection");
            e.printStackTrace();
        }
        catch (NoSuchElementException | IndexOutOfBoundsException e){
            noteBookOptional = Optional.empty();
        }
        return noteBookOptional;
    }

    @Override
    public Optional<List<NoteBook>> findAll() {
        String SQLQuery = SQLQueriesConstants.FIND_ALL_NOTE_BOOKS_QUERY;
        Optional<List<NoteBook>> allNoteBooksOptional = Optional.empty();
        try{
            PreparedStatement statement = connection.prepareStatement(SQLQuery);

            ResultSet result = statement.executeQuery();
            allNoteBooksOptional = Optional.of(parseResultSet(result).orElse(new ArrayList<>()));
        }
        catch (SQLException e){
            System.err.println("Bad connection");
            e.printStackTrace();
        }
        return allNoteBooksOptional;
    }

    @Override
    public boolean delete(NoteBook noteBook) {
        throw new UnsupportedOperationException();
    }

    private Optional<List<NoteBook>> parseResultSet(ResultSet resultSet) throws SQLException{
        List<NoteBook> list = new ArrayList<>();
        while(resultSet.next()){
            NoteBook noteBook = new NoteBook();
            noteBook.setId(resultSet.getLong("id"));
            noteBook.setNameOfSubscriber(resultSet.getString("subscriber_name"));
            noteBook.setSurnameOfSubscriber(resultSet.getString("subscriber_surname"));
            noteBook.setPatronymicOfSubscriber(resultSet.getString("subscriber_patronymic"));
            noteBook.setNickName(resultSet.getString("subscriber_nickname"));

            list.add(noteBook);
        }
        return Optional.of(list);
    }

}
