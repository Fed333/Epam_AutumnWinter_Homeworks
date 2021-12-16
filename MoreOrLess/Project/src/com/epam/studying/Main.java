package com.epam.studying;

import com.epam.studying.controller.Controller;
import com.epam.studying.model.Model;
import com.epam.studying.model.exceptions.WrongDataException;
import com.epam.studying.view.View;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       loadGame();
    }

    private static boolean isValid(int rnd, int minBound, int maxBound) {
        return rnd >= minBound && rnd < maxBound;
    }

    private static boolean loadGame(){
        try {
            Scanner in = new Scanner(System.in);
            Controller controller = new Controller(new Model(), new View());
            controller.startGame(in);
        }
        catch(WrongDataException e){
            return false;
        }
        return true;
    }
}
