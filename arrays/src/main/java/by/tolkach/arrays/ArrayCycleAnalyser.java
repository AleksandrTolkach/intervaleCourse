package by.tolkach.arrays;

import by.tolkach.arrays.api.IArrayAnalyzer;

public class ArrayCycleAnalyser implements IArrayAnalyzer {

    @Override
    public long[] analyze(long[] arr) {
        if (arr == null || arr.length == 0) {
            return new long[0];
        }
        long[] result = new long[2];
        for (long i : arr) {
            if (i > 0) {
                ++result[0];
            } else if (i < 0) {
                result[1] += i;
            }
        }
        return result;
    }
}
