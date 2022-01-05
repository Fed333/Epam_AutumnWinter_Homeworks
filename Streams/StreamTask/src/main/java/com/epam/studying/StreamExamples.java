package com.epam.studying;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExamples {

    public static double averageValue(final int[] array){
        requireNonNulOrEmptyArray(array);
        return Arrays.stream(array).asDoubleStream().average().orElseThrow(IllegalArgumentException::new);
    }

    public static Pair<Integer, Integer> minValueAndIndex(final int[] array){
        requireNonNulOrEmptyArray(array);
        Integer value = Arrays.stream(array).min().orElseThrow(IllegalArgumentException::new);
        Integer index = Arrays.stream(array).collect(ArrayList::new, ArrayList::add, ArrayList::addAll).indexOf(value);
        return Pair.of(value, index);
    }

    public static Long countOnlyZero(final int[] array){
        requireNonNulOrEmptyArray(array);
        return Arrays.stream(array).filter(e -> e == 0).count();
    }

    public static Long countOnlyMoreThanZero(final int[] array){
        requireNonNulOrEmptyArray(array);
        return Arrays.stream(array).filter(e -> e > 0).count();
    }

    /**
     * multiplies each element in input array to the given number without changing the source array
     * @param array source array which elements will be multiplied
     * @param number number by which we multiply to
     * @return new created array with multiplied elements
     * */
    public static int[] multiplyAllElementsBy(int[] array, int number){
        requireNonNulOrEmptyArray(array);
        return Arrays.stream(array).map(e -> e*number).toArray();
    }

    private static void requireNonNulOrEmptyArray(int[] array) {
        if (Optional.ofNullable(array).orElseThrow(IllegalArgumentException::new).length == 0){
            throw new IllegalArgumentException();
        }
    }
}
