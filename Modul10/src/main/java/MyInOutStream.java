import java.io.*;

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
                    if(line.contains("-")){
                        System.out.println(line);
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
