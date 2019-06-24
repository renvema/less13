package task.thirteenth;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        class MinMax implements Consumer<T> {

            private T min;
            private T max;

            public MinMax() {
                min = null;
                max = null;
            }

            public T getMax() {
                return max;
            }


            public T getMin() {
                return min;
            }

            @Override
            public void accept(T t) {
                if (min == null) {
                    min = t;
                }
                max = t;
            }


        }
        MinMax minMax = new MinMax();
        stream.sorted(order).forEach(minMax);
        minMaxConsumer.accept(minMax.getMin(), minMax.getMax());
    }
}
