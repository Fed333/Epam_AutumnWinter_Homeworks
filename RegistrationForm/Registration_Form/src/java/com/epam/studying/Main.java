package com.epam.studying;

import com.epam.studying.connection.ConnectionManager;
import com.epam.studying.controller.NoteBookController;
import com.epam.studying.model.Model;
import com.epam.studying.view.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        ConnectionManager cm = new ConnectionManager(new FileInputStream("src/resources/database.properties"));

        NoteBookController controller = new NoteBookController(new Model(cm.getConnection()), new View());
        controller.processNoteBook(new Scanner(System.in));

    }
}
