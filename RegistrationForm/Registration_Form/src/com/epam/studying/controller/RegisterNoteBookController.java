package com.epam.studying.controller;

import com.epam.studying.entity.NoteBook;
import com.epam.studying.model.Model;
import com.epam.studying.service.NoteBookService;
import com.epam.studying.view.View;

import java.util.ResourceBundle;
import java.util.Scanner;

import static com.epam.studying.view.TextConstants.*;

public class RegisterNoteBookController {
    private Model model;
    private View view;
    private ResourceBundle bundle;

    private NoteBookService noteBookService;

    public RegisterNoteBookController(Model model, View view, NoteBookService noteBookService) {
        this.model = model;
        this.view = view;
        this.noteBookService = noteBookService;
        bundle = View.bundle;
    }

    public void registerNoteBook(Scanner in){
        NoteBook noteBook = new NoteBook();
        readName(noteBook, in);
        readNickname(noteBook, in);
        view.printMessage(bundle.getString(INPUT_REGISTRATION_SUCCESSFUL));
    }

    private void readName(NoteBook note, Scanner in){
       readAttribute(note, in, INPUT_FIRST_NAME_DATA, NoteBookService::setName, View::wrongNameWarning);
    }

    private void readNickname(NoteBook note, Scanner in){
        readAttribute(note, in, INPUT_NICKNAME_DATA, NoteBookService::setNickname, View::wrongNickNameWarning);
    }

    /**
     * @param InputData must be a value in TextConstants*/
    private void readAttribute(
            NoteBook note,
            Scanner in,
            String InputData,
            SetStringNoteBookAttribute attribute,
            GetWarningFormatType warning
    ){
        String name = "";
        view.printStringInput(InputData);
        while(! (in.hasNext() && attribute.set(noteBookService, note, name = String.valueOf(in.next())))){
            view.printWarningMessage(warning.get(view, name));
            view.printStringInput(InputData);
        }
    }

    @FunctionalInterface
    private interface SetStringNoteBookAttribute{
        boolean set(NoteBookService service, NoteBook note, String attribute);
    }

    @FunctionalInterface
    private interface GetWarningFormatType {
        String get(View view, String message);
    }





}
