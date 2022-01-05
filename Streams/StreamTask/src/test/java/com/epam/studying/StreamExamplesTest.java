package com.epam.studying;

import com.epam.studying.subtests.*;
import org.junit.Test;

public class StreamExamplesTest {

    @Test
    public void averageValue() {
        new StreamAverageValueTest().testAverageValue();
    }

    @Test
    public void minValueAndIndex() {
        new StreamMinValueAndIndexTest().testMinValueAndIndex();
    }

    @Test
    public void countOnlyZero() {
        new StreamCountOnlyZeroTest().testCountOnlyZero();
    }

    @Test
    public void countOnlyMoreThanZero() {
        new StreamCountOnlyMoreThanZeroTest().testCountOnlyMoreThanZero();
    }

    @Test
    public void multiplyAllElementsBy() {
        new StreamMultiplyAllElementsByTest().testMultiplyAllElementsBy();
    }
}