package com.orest.kapko.vakoms.project.finished;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.*;
import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.util.List;

class Client {
    public static void main(String args[]) {
        try {
            Socket skt = new Socket("localhost", 1234);
            BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            System.out.print("Received string from Server: '");
            String line = null;
            while (!in.ready()) {
            }
            System.out.print(line = in.readLine()); // Read one line and output it
            System.out.print("'\n");

            // Converts JSON string into a collection of Users object.
            Gson gson = new Gson();
            Type type = new TypeToken<List<User>>() {}.getType();
            List<User> usersList = gson.fromJson(line, type);

            for (User user : usersList) {
                System.out.println("User's ID: " + user.getId() + ". " + "User's NAME: " +
                        user.getName() + ". " + "User's Email: " + user.getEmail());
            }
            in.close();
        }
        catch(Exception e) {
            System.out.print("Whoops! It didn't work!\n");
        }
    }
}
