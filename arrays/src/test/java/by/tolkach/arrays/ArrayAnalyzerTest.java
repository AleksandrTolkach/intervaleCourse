package by.tolkach.arrays;

import by.tolkach.arrays.api.IArrayAnalyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArrayAnalyzerTest {
    private IArrayAnalyzer arrayAnalyzer;

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void analyze(Integer[] expectedArray, Integer[] providedArray) {
        arrayAnalyzer = new ArrayCycleAnalyser();
        Assertions.assertArrayEquals(expectedArray, arrayAnalyzer.analyze(providedArray));
        arrayAnalyzer = new ArrayStreamAnalyzer();
        Assertions.assertArrayEquals(expectedArray, arrayAnalyzer.analyze(providedArray));
    }

    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                arguments(new Integer[] {10, -65}, new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}),
                arguments(new Integer[] {8, -50}, new Integer[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}),
                arguments(new Integer[0], new Integer[0]),
                arguments(new Integer[0], null)
        );
    }
}
