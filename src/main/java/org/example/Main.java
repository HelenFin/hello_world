package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Bill");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(person);

        System.out.println(json);
    }


}