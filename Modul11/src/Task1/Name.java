package Task1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Name {
    int number;
    String name;

    Name(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        List<Name> names =
                Arrays.asList(
                        new Name(1, "Alex"),
                        new Name(2, "Max"),
                        new Name(3, "Oleg"),
                        new Name(4, "Anna"),
                        new Name(5, "Sonia")
                );


        List<Name> filteredNames = names.stream()
                .filter(name -> name.number % 2 != 0)
                .collect(Collectors.toList());



        filteredNames.forEach(name -> System.out.print(name.number + ". " + name.name + " "));

    }
};

