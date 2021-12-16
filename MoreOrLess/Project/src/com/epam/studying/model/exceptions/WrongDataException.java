package com.epam.studying.model.exceptions;

public class WrongDataException extends Exception{
    private static final String WARNING_MESSAGE = "Wrong data. Number: %d isn't in range [%d,%d]";
    public WrongDataException(int num, int minNum, int maxNum) {
        super(String.format(WARNING_MESSAGE, num, minNum, maxNum));
    }
}
