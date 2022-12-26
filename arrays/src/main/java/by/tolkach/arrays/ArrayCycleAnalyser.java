package by.tolkach.arrays;

import by.tolkach.arrays.api.IArrayAnalyzer;

public class ArrayCycleAnalyser implements IArrayAnalyzer {

    @Override
    public Integer[] analyze(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return new Integer[0];
        }
        Integer[] result = new Integer[] {0, 0};
        for (Integer i : arr) {
            if (i > 0) {
                ++result[0];
            } else if (i < 0) {
                result[1] += i;
            }
        }
        return result;
    }
}
