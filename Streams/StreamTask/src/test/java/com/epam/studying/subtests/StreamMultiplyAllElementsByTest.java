package com.epam.studying.subtests;

import com.epam.studying.StreamExamples;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class StreamMultiplyAllElementsByTest {

    @Test
    public void testMultiplyAllElementsBy() {
        testNullPointer();
        testEmptyArray();
        testCase1();
        testCase2();
        testCase3();
    }

    @Test
    public void testNullPointer(){
        Assert.assertThrows(IllegalArgumentException.class, ()-> StreamExamples.multiplyAllElementsBy(null, 0));
    }

    @Test
    public void testEmptyArray(){
        Assert.assertThrows(IllegalArgumentException.class, ()->StreamExamples.multiplyAllElementsBy(new int[]{}, 0));
    }

    @Test
    public void testCase1(){
        int[] arr = {1, 2, 3, 4, 5};
        int numberForMultiplying = 2;
        Assert.assertArrayEquals(new int[]{2, 4, 6, 8, 10}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = 0;
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = 1;
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = -1;
        Assert.assertArrayEquals(new int[]{-1, -2, -3, -4, -5}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = -2;
        Assert.assertArrayEquals(new int[]{-2, -4, -6, -8, -10}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
    }

    @Test
    public void testCase2(){
        int[] arr = {-3, -2, -1, 0, 1, 2, 3};
        int numberForMultiplying = 2;
        Assert.assertArrayEquals(new int[]{-6, -4, -2, 0, 2, 4, 6}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = 0;
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = 1;
        Assert.assertArrayEquals(new int[]{-3, -2, -1, 0, 1, 2, 3}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = -1;
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0, -1, -2, -3}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = -2;
        Assert.assertArrayEquals(new int[]{6, 4, 2, 0, -2, -4, -6}, StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
    }

    @Test
    public void testCase3(){
        int arrayLength = 10000;
        int[] arr = new Random().ints(0, arrayLength).limit(arrayLength).toArray();
        int numberForMultiplying = 2;
        Assert.assertArrayEquals(trustedMultiplyAllElementsBy(arr, numberForMultiplying), StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = 0;
        Assert.assertArrayEquals(trustedMultiplyAllElementsBy(arr, numberForMultiplying), StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = 1;
        Assert.assertArrayEquals(trustedMultiplyAllElementsBy(arr, numberForMultiplying), StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = -1;
        Assert.assertArrayEquals(trustedMultiplyAllElementsBy(arr, numberForMultiplying), StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = -2;
        Assert.assertArrayEquals(trustedMultiplyAllElementsBy(arr, numberForMultiplying), StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));

        numberForMultiplying = 100;
        Assert.assertArrayEquals(trustedMultiplyAllElementsBy(arr, numberForMultiplying), StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));
        numberForMultiplying = -100;
        Assert.assertArrayEquals(trustedMultiplyAllElementsBy(arr, numberForMultiplying), StreamExamples.multiplyAllElementsBy(arr, numberForMultiplying));

    }

    public int[] trustedMultiplyAllElementsBy(int[] arr, int number){
        requireNonNullOrEmptyArray(arr);
        int[] copyArray = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] *= number;
        }
        return copyArray;
    }

    private void requireNonNullOrEmptyArray(int[] arr) {
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException();
        }
    }
}