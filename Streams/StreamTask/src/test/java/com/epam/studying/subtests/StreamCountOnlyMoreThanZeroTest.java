package com.epam.studying.subtests;

import com.epam.studying.StreamExamples;
import org.junit.Assert;
import org.junit.Test;

public class StreamCountOnlyMoreThanZeroTest extends StreamCountSomeElementsTest{

    @Test
    public void testCountOnlyMoreThanZero() {
        super.countSomeElements();
    }

    @Test
    @Override
    public void testNullPointer() {
        super.testNullPointer();
    }

    @Test
    @Override
    public void testEmptyArray() {
        super.testEmptyArray();
    }

    @Test
    @Override
    public void testCase1() {
        int[] arr = {-3, -2, -1, 0, 1, 2, 3};
        Assert.assertEquals(Long.valueOf(3L), StreamExamples.countOnlyMoreThanZero(arr));
    }

    @Test
    @Override
    public void testCase2() {
        super.testCase2();
    }

    @Test
    @Override
    public void testCase3() {
        super.testCase3();
    }



    @Override
    protected Long trustedCountSomeElementsInArray(int[] arr) {
        requireNonNullOrEmptyArray(arr);
        long count = 0;
        for (long num : arr) {
            if (num > 0){
                count++;
            }
        }
        return count;
    }

    @Override
    protected Long countSomeElementsInArray(int[] arr) {
        return StreamExamples.countOnlyMoreThanZero(arr);
    }

    private static void requireNonNullOrEmptyArray(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException();
        }
    }
}