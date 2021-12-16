package com.epam.studying.model;

import com.epam.studying.model.exceptions.UnacceptableInputNumberException;
import com.epam.studying.model.exceptions.WrongDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    public final static int MAX_BARRIER = 100;
    public final static int MIN_BARRIER = 1;

    private int mysteryNumber;

    private boolean endGame;

    private int minBarrier;
    private int maxBarrier;

    private List<Integer> attempts = new ArrayList<>();

    public Model() throws WrongDataException{
       this(rand(MIN_BARRIER, MAX_BARRIER), MIN_BARRIER, MAX_BARRIER);
    }

    public Model(int mysteryNumber, int minBarrier, int maxBarrier) throws WrongDataException{
        if (!isInRange(mysteryNumber, minBarrier, maxBarrier)){
            throw new WrongDataException(mysteryNumber, minBarrier, maxBarrier);
        }
       init(mysteryNumber, minBarrier, maxBarrier);
    }

    private void init(int mysteryNumber, int minBarrier, int maxBarrier){
        this.mysteryNumber = mysteryNumber;
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public boolean checkNumber(int responseNumber) throws UnacceptableInputNumberException{
        attempts.add(responseNumber);
        if (responseNumber == mysteryNumber){
            endGame = true;
            return true;
        }

        if (!isInRange(responseNumber)){
            throw new UnacceptableInputNumberException(responseNumber, minBarrier, maxBarrier);
        }

        if (responseNumber < mysteryNumber){
            minBarrier = responseNumber+1;
        }
        else {
            maxBarrier = responseNumber;
        }
        return false;
    }

    public static int rand(int min, int max) throws IllegalArgumentException{
        if (max < min){
            throw new IllegalArgumentException("Max cannot be smaller than min");
        }
        return new Random(System.nanoTime()).nextInt(max-min)+min;
    }

    private boolean isInRange(int number, int minBarrier, int maxBarrier){
        return number >= minBarrier && number < maxBarrier;
    }

    private boolean isInRange(int number){
        return isInRange(number, minBarrier, maxBarrier);
    }

    public int getMysteryNumber() {
        return mysteryNumber;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public List<Integer> getAttempts() {
        return attempts;
    }

    public int getNumberOfAttempts(){
        return attempts.size();
    }

    public void setMysteryNumber(int mysteryNumber) {
        if (mysteryNumber != this.mysteryNumber){
            endGame = false;
            attempts.clear();
        }
        this.mysteryNumber = mysteryNumber;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public String getPrompt() {
        return lastAttempt()<mysteryNumber?"Bigger":"Smaller";
    }
    public int lastAttempt(){
        return attempts.get(attempts.size()-1);
    }
}
