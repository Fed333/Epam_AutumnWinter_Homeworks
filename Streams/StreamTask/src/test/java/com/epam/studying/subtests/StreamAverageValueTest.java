package com.epam.studying.subtests;


import com.epam.studying.StreamExamples;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Random;

public class StreamAverageValueTest extends TestCase{

    private static final Random rnd = new Random();

    public void testAverageValue() {
        testNullPointer();
        testEmptyArray();
        testCase1();
        testCase2(10000);
        testCase3();
        testCase4(10000);
    }

    public void testNullPointer(){
        int[] array = null;
        Assert.assertThrows(IllegalArgumentException.class, ()-> StreamExamples.averageValue(array));
    }

    public void testEmptyArray(){
        int[] array = {};
        Assert.assertThrows(IllegalArgumentException.class, ()->StreamExamples.averageValue(array));
    }

    public void testCase1(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertEquals(3.5, StreamExamples.averageValue(arr));
    }
    
    public void testCase2(int arrayLength){
        int[] arr = new int[arrayLength];
        Random rnd = new Random();
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = rnd.nextInt(arrayLength);
        }
        assertEquals(trustedAverageValue(arr), StreamExamples.averageValue(arr));
    }

    public void testCase3(){
        int[] arr = {-3, -2, -1, 0, 1, 2, 3};
        assertEquals(0.0, StreamExamples.averageValue(arr));
    }

    public void testCase4(int arrayLength){
        int[] arr = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            arr[i] = randomInRange(-arrayLength, arrayLength);
        }
        assertEquals(trustedAverageValue(arr), StreamExamples.averageValue(arr));
    }

    private static int randomInRange(int from, int to) {
        if (from > to){
            throw new IllegalArgumentException();
        }
        return (rnd.nextInt(to - from)) + from;
    }

    private double trustedAverageValue(int[] arr){
        double sum = 0;
        for (int num:arr) {
            sum += num;
        }
        return sum/arr.length;
    }
}