package by.tolkach.arrays.api;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector implements Collector<Integer, Integer[], Integer[]> {

    public static CustomCollector toCustomCollector() {
        return new CustomCollector();
    }

    @Override
    public Supplier<Integer[]> supplier() {
        return () -> {
            return new Integer[] {0, 0};
        };
    }

    @Override
    public BiConsumer<Integer[], Integer> accumulator() {
        return (array, num) -> {
            if (num > 0) {
                ++array[0];
            } else if (num < 0) {
                array[1] += num;
            }
        };
    }

    @Override
    public BinaryOperator<Integer[]> combiner() {
        return null;
    }

    @Override
    public Function<Integer[], Integer[]> finisher() {
        return array -> array;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
    }
}
