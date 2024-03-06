package Task2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MainUser {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                users.add(new User(name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("user.json")) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
