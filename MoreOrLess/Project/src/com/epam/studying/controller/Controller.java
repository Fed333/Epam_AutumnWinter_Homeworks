package com.epam.studying.controller;

import com.epam.studying.model.Model;
import com.epam.studying.model.exceptions.UnacceptableInputNumberException;
import com.epam.studying.view.View;

import java.util.Scanner;

public class Controller {

    private final static String INPUT_NUMBER_FORMAT = "Input value in range [%d,%d]: ";
    private final static String CONGRATULATION_FORMAT = "Congratulation you've won this game in %d steps";

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    public void startGame(Scanner in){

        while (!model.isEndGame()){
            try {
                model.checkNumber(inputResponseNumber(in));
                view.printlnMessage(model.getPrompt());
            }
            catch (NumberFormatException e){
                view.printlnMessage("Wrong input data, not a integer number was entered.\nTry again.");
            }
            catch (UnacceptableInputNumberException e){
                view.printlnMessage(e.getMessage());
                view.printlnMessage(e.getPrompt());
            }
        }
        view.printlnMessage(congratulation());
    }

    public int inputResponseNumber(Scanner in){
        view.printMessage(askNumber());
        int number = Integer.parseInt(in.nextLine());
        return number;

    }

    private String askNumber(){
        return String.format(INPUT_NUMBER_FORMAT, model.getMinBarrier(), model.getMaxBarrier());
    }

    private String congratulation(){
        return String.format(CONGRATULATION_FORMAT, model.getNumberOfAttempts()) + "\nYour statistic: " + model.getAttempts().toString();
    }

}
