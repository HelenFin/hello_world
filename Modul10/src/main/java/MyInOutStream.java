import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyInOutStream {

    public void writeFile() {
        try {
            PrintWriter printWriter = new PrintWriter("file.txt");
            String firstNumber = "987-123-4567";
            String secondNumber = "123 456 7890";
            String thirtyNumber = "(123) 456-7890";
            printWriter.println(firstNumber);
            printWriter.println(secondNumber);
            printWriter.println(thirtyNumber);
            printWriter.close();
            System.out.println("The file was created successfully");

        } catch (IOException e) {
            System.out.println("Error by creating or writing the file");
            e.printStackTrace();
        }
    }
        public void readFile() {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"))) {
                String line;
                while ((line = bufferedReader.readLine()) != null ) {
                    Pattern pattern = Pattern.compile("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d", Pattern.CASE_INSENSITIVE);
                    Pattern patternTwo = Pattern.compile("\\(\\d\\d\\d\\)\\s\\d\\d\\d-\\d\\d\\d\\d", Pattern.CASE_INSENSITIVE);
                    // Match regex against input
                    Matcher matcher = pattern.matcher(line);
                    Matcher matcherTwo = patternTwo.matcher(line);

                    boolean result = matcher.find();
                    boolean resultTwo = matcherTwo.find();

                    if (matcher.matches()) {
                        System.out.println(matcher.group());


                    }
                    else if(matcherTwo.matches()){
                        System.out.println(matcherTwo.group());
                    }
                }
            } catch (IOException e) {
               e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        MyInOutStream myInOutStream = new MyInOutStream();
        myInOutStream.writeFile();
        myInOutStream.readFile();
    }


}
