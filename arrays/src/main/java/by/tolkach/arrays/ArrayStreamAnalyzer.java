package by.tolkach.arrays;

import by.tolkach.arrays.api.IArrayAnalyzer;

import java.util.Arrays;

public class ArrayStreamAnalyzer implements IArrayAnalyzer {

    @Override
    public long[] analyze(long[] arr) {
        if (arr == null || arr.length == 0) {
            return new long[0];
        }
        long[] result = new long[2];
        Arrays.stream(arr).forEach(x -> {
            if (x > 0) {
                ++result[0];
            } else if (x < 0) {
                result[1] += x;
            }
        });
        return result;
    }
}
