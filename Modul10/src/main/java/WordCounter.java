import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {

    public void writeFile() {
        try {
            PrintWriter printWriter = new PrintWriter("words.txt");
            String firstString = "the day is sunny the the";
            String secondString = "the sunny is is";

            printWriter.println(firstString);
            printWriter.println(secondString);

            printWriter.close();
            System.out.println("The file was created successfully");

        } catch (IOException e) {
            System.out.println("Error by creating or writing the file");
            e.printStackTrace();
        }
    }

    public void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"))) {
            StringBuilder oneLine = new StringBuilder();
            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                oneLine.append(line).append(" ");
            }

            String text = oneLine.toString();

            //System.out.println(text);

            Map<String, Long> wordsCount = Arrays.stream(text.split("\\s+"))
                    .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

            List<String> result =
                    wordsCount.entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                                    .thenComparing(Map.Entry.comparingByKey()))
                            .map(Map.Entry::getKey)
                            .collect(Collectors.toList());

            result.forEach(word -> System.out.println(word + " " + wordsCount.get(word)));

            }
            catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        wordCounter.writeFile();
        wordCounter.readFile();
    }

}
