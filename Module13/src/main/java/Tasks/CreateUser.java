package Tasks;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateUser {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void createUser(User user) throws Exception {
        URL url = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        String jsonInputString = objectMapper.writeValueAsString(user);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            StringBuilder response = new StringBuilder();
            try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }
        } else {
            System.out.println("POST request not worked");
        }
    }

    public void updateUser(int userId, User user) throws Exception {
        URL url = new URL(BASE_URL + "/" + userId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        String jsonInputString = objectMapper.writeValueAsString(user);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("PUT Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Updated User: " + response.toString());
            }
        } else {
            System.out.println("PUT request not worked");
        }
    }

    public void deleteUser(int userId) throws Exception {
        URL url = new URL(BASE_URL + "/" + userId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        System.out.println("DELETE Response Code :: " + responseCode);


        if (responseCode >= 200 && responseCode < 300) {
            System.out.println("User with ID " + userId + " has been deleted successfully.");
        } else {
            System.out.println("DELETE request not worked");
        }
    }

    public void getAllUsers() throws Exception {
        URL url = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("All Users: \n" + response.toString());
            }
        } else {
            System.out.println("GET request not worked");
        }
    }

    public void getUserById(int userId) throws Exception {
        URL url = new URL(BASE_URL + "/" + userId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("User with ID " + userId + ": \n" + response.toString());
            }
        } else {
            System.out.println("GET request not worked");
        }
    }

    public void getUserByUsername(String username) throws Exception {
        URL url = new URL(BASE_URL + "?username=" + username);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("User with username " + username + ": \n" + response.toString());
            }
        } else {
            System.out.println("GET request not worked");
        }
    }

    public void getCommentsOfLastPostByUser(int userId) throws Exception {
        String POST_URL = "https://jsonplaceholder.typicode.com";
        URL postsUrl = new URL(POST_URL + "/users/" + userId + "/posts");
        String postsJson = makeHttpRequest(postsUrl);
        List<Post> posts = objectMapper.readValue(postsJson, new TypeReference<List<Post>>() {
        });

        Post lastPost = posts.stream().max((p1, p2) -> Integer.compare(p1.getId(), p2.getId())).orElse(null);

        if (lastPost != null) {

            URL commentsUrl = new URL(POST_URL + "/posts/" + lastPost.getId() + "/comments");
            String commentsJson = makeHttpRequest(commentsUrl);
            String fileName = "user-" + userId + "-post-" + lastPost.getId() + "-comments.json";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(commentsJson);
            }
            System.out.println("Comments for the last post of user " + userId + " have been saved to " + fileName);
        } else {
            System.out.println("No posts found for user " + userId);
        }
    }

    public void getOpenTodosForUser(int userId) throws Exception {
        URL url = new URL(BASE_URL + "/" + userId + "/todos");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            List<ToDo> todos = objectMapper.readValue(content.toString(), new TypeReference<List<ToDo>>() {
            });

            List<ToDo> openTodos = todos.stream().filter(todo -> !todo.isCompleted()).collect(Collectors.toList());
                        System.out.println("Open ToDos for User " + userId + ":");
            for (ToDo todo : openTodos) {
                System.out.println(todo.getTitle());
            }
        } else {
            System.out.println("GET request not worked");
        }
    }

    private String makeHttpRequest(URL url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }
        return response.toString();
    }

    public static void main(String[] args) throws Exception {
        CreateUser user = new CreateUser();
        User firstUser = new User("Max Mustermann", "maxmustermann", "maxmustermann@gmail.com");
        user.createUser(firstUser);


        User newUser = new User("Anna Mustermann", "annamustermann", "annamustermann@gmail.com");
        user.updateUser(10, newUser);

        user.deleteUser(10);

        user.getAllUsers();

        user.getUserById(3);

        user.getUserByUsername("Bret");

        user.getCommentsOfLastPostByUser(3);

        user.getOpenTodosForUser(4);
    }
}

