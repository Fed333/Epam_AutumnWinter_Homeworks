package com.epam.studying.subtests;

import org.junit.Assert;
import java.util.Random;

abstract public class StreamCountSomeElementsTest {

    public void countSomeElements() {
        testNullPointer();
        testEmptyArray();
        testCase1();
        testCase2();
        testCase3();
    }

    public void testNullPointer(){
        Assert.assertThrows(IllegalArgumentException.class, ()->countSomeElementsInArray(null));
    }

    public void testEmptyArray(){
        Assert.assertThrows(IllegalArgumentException.class, ()->countSomeElementsInArray(new int[]{}));
    }


    abstract public void testCase1();

    public void testCase2(){
        int arrayLength = 10000;
        int[] arr = new Random().ints(0, arrayLength).limit(arrayLength).toArray();
        Assert.assertEquals(trustedCountSomeElementsInArray(arr), countSomeElementsInArray(arr));
    }

    public void testCase3(){
        int arrayLength = 10000;
        int[] arr = new Random().ints(-arrayLength, arrayLength).limit(arrayLength).toArray();
        Assert.assertEquals(trustedCountSomeElementsInArray(arr), countSomeElementsInArray(arr));
    }

    protected abstract Long trustedCountSomeElementsInArray(int[] arr);
    protected abstract Long countSomeElementsInArray(int[] arr);
}
