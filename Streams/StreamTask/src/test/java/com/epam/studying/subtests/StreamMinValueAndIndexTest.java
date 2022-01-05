package com.epam.studying.subtests;

import com.epam.studying.Pair;
import com.epam.studying.StreamExamples;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamMinValueAndIndexTest extends TestCase {

    @Test
    public void testMinValueAndIndex() {
        testNullPointer();
        testEmptyArray();
        testCase1();
        testCase2();
        testCase3();
    }

    public void testNullPointer(){
        assertThrows(IllegalArgumentException.class, ()-> StreamExamples.minValueAndIndex(null));
    }

    public void testEmptyArray(){
        assertThrows(IllegalArgumentException.class, ()->StreamExamples.minValueAndIndex(new int[]{}));
    }

    public void testCase1(){
        int[] array = {1, 2, 0, 2, 1};
        assertEquals(Pair.of(0, 2), StreamExamples.minValueAndIndex(array));

        array = new int[]{-1, -2, -3, 0, 1, 2, 3};
        assertEquals(Pair.of(-3, 2), StreamExamples.minValueAndIndex(array));

        array = new int[]{3, 2, 1, 0, -1, -2, -3};
        assertEquals(Pair.of(-3, 6), StreamExamples.minValueAndIndex(array));

    }

    public void testCase2(){
        int arrayLength = 10000;
        int[] array = new Random().ints(0, arrayLength).limit(arrayLength).toArray();
        assertEquals(trustedMinValueAndIndex(array), StreamExamples.minValueAndIndex(array));
    }

    public void testCase3(){
        int arrayLength = 10000;
        int[] array = new Random().ints(-arrayLength, arrayLength).limit(arrayLength).toArray();
        assertEquals(trustedMinValueAndIndex(array), StreamExamples.minValueAndIndex(array));
    }

    private static Pair<Integer, Integer> trustedMinValueAndIndex(int[] array){
        int min = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
                index = i;
            }
        }
        return Pair.of(min, index);
    }
}