package com.epam.studying.model.exceptions;

public class UnacceptableInputNumberException extends WrongDataException{

    private final String PROMPT_TEMPLATE = "Please enter a number from %d to %d";

    private String prompt;

    public UnacceptableInputNumberException(int num, int minNum, int maxNum) {
        super(num, minNum, maxNum);
        prompt = createPrompt(minNum, maxNum);
    }

    private String createPrompt(int min, int max){
       return String.format(PROMPT_TEMPLATE, min, max);
    }

    public String getPrompt() {
        return prompt;
    }
}
