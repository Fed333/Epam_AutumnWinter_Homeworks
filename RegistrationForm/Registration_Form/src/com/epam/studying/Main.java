package com.epam.studying;

import com.epam.studying.controller.NoteBookController;
import com.epam.studying.entity.NoteBook;
import com.epam.studying.model.Model;
import com.epam.studying.view.TextConstants;
import com.epam.studying.view.View;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NoteBook myNoteBook = new NoteBook("Roman", "roman_ko09");

        NoteBookController controller = new NoteBookController(new Model(), new View());
        controller.processNoteBook(new Scanner(System.in));


    }
}
