package Task3;


import java.util.Arrays;
import java.util.stream.Collectors;

public class SortNumbers {

    public static void main(String[] args) {
        String[] array = {"1, 2, 0", "4, 5"};

        String sortedNumbers = Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(",\\s*")))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(sortedNumbers);
    }
    }

