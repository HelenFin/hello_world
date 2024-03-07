package Task1;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Name {
    public static void main(String[] args) {
        String[] names = {"Alex", "Oleg", "Anna", "OLena", "Erik", "Nikolai"};

        Stream<String> stream = IntStream.range(0, names.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + names[i] + " ");

        stream.forEach(System.out::println);
    }
};

