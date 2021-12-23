package com.epam.studying;

import com.epam.studying.connection.ConnectionManager;
import com.epam.studying.dao.NoteBookDao;
import com.epam.studying.dao.impl.NoteBookDaoImpl;
import com.epam.studying.entity.NoteBook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void test() throws IOException {

//      updateExistingNoteBook(createDao());
        createNewNoteBook(createDao());
    }


    private static void updateExistingNoteBook(NoteBookDao dao){
        NoteBook note = new NoteBook();
        note.setNickName("misha_Gol");
        note.setNameOfSubscriber("Михайло");
        note.setSurnameOfSubscriber("Головачьов");
        note.setId(10L);

        if (dao.save(note)){
            System.out.println(note + " was updated in db");
        }
        else{
            System.out.println("Something went wrong");
        }
    }

    private static void createNewNoteBook(NoteBookDao dao){
        NoteBook note = new NoteBook();
        note.setNickName("misha_Gol");
        note.setNameOfSubscriber("Михайло");
        note.setSurnameOfSubscriber("Головачьов");

        if (dao.save(note)){
            System.out.println(note + " was added to db");
        }
        else{
            System.out.println("Something went wrong");
        }
    }

    private static void findNoteBookByIdTest(NoteBookDao dao){
        NoteBook note = dao.findById(5L).orElse(null);
        if (note != null){
            System.out.println("Was found: " + note);
        }
        else{
            System.out.println("Nothing was found");
        }
    }

    private static void findAllNoteBooksTest(NoteBookDao dao) {
        List<NoteBook> list = dao.findAll().orElse(new ArrayList<>());
        if (!list.isEmpty()){
            System.out.println("Was found " + list.size() + " noteBooks.");
            list.forEach(System.out::println);
        }
        else{
            System.out.println("Nothing was found");
        }
    }

    private static NoteBookDao createDao() throws IOException{
        ConnectionManager cm = new ConnectionManager(new FileInputStream("src/resources/database.properties"));
        Connection connection = cm.getConnection();
        System.out.println("Connection was got successfully");
        return new NoteBookDaoImpl(connection);

    }

    private static void findNoteBookByNicknameTest(NoteBookDao dao) throws IOException{

        NoteBook note = dao.findByNickname("Pipas").orElse(null);
        if (note != null){
            System.out.println("Was found: " + note);
        }
        else{
            System.out.println("Nothing was found");
        }
    }


}
