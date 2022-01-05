package com.epam.studying.subtests;


import com.epam.studying.StreamExamples;
import org.junit.Assert;
import org.junit.Test;

public class StreamCountOnlyZeroTest extends StreamCountSomeElementsTest{

    @Test
    public void testCountOnlyZero() {
       super.countSomeElements();
    }

    @Test
    public void testNullPointer(){
       super.testNullPointer();
    }

    @Test
    public void testEmptyArray(){
        super.testEmptyArray();
    }

    @Test
    @Override
    public void testCase1() {
        int[] arr = {-3, -2, -1, 0, 1, 2, 3};
        Assert.assertEquals(Long.valueOf(1L), countSomeElementsInArray(arr));
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
        long count = 0;
        for (int num:arr) {
            if (num == 0){
                count++;
            }
        }
        return count;
    }

    @Override
    protected Long countSomeElementsInArray(int[] arr) {
        return StreamExamples.countOnlyZero(arr);
    }

}