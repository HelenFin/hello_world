package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Name {
    public static void main(String[] args) {
        String[] names = {"Alex", "Oleg", "Anna", "OLena", "Erik", "Nikolai"};

        // Print indices and names where the index is odd
        IntStream.range(0, names.length)
                .filter(i -> i % 2 != 0)
                .forEach(i -> System.out.print(i + ". " + names[i] + " "));
    }
};

