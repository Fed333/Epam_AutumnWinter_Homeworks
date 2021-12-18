package com.epam.studying.controller;

import com.epam.studying.model.Model;
import com.epam.studying.service.NoteBookService;
import com.epam.studying.view.View;

import java.util.Scanner;

public class NoteBookController {

    private Model model;
    private View view;

    public NoteBookController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processNoteBook(Scanner in){
        new RegisterNoteBookController(model, view, new NoteBookService(View.bundle)).registerNoteBook(in);
    }
}
