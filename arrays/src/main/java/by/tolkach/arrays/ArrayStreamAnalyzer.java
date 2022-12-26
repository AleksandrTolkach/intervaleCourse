package by.tolkach.arrays;

import by.tolkach.arrays.api.CustomCollector;
import by.tolkach.arrays.api.IArrayAnalyzer;

import java.util.Arrays;

public class ArrayStreamAnalyzer implements IArrayAnalyzer {

    @Override
    public Integer[] analyze(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return new Integer[0];
        }

        return Arrays.stream(arr).collect(CustomCollector.toCustomCollector());
    }
}
