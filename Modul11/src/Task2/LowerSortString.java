package Task2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LowerSortString {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Helen", "Anna", "Max", "Lana", "Boris", "Zoe");

        List<String> sortedList = names.stream()
                .sorted()
                .map(String::toLowerCase).collect(Collectors.toList());

        sortedList.forEach(System.out::println);

    }
}
