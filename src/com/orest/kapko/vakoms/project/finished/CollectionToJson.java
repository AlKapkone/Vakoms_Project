package com.orest.kapko.vakoms.project.finished;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CollectionToJson {
    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------
        // Converts a collection of Users objects into JSON string
        User firstUser = new User(1,"Kapko Orest", "kapko2311@gmail.com");
        User secondUser = new User(2,"Brad Pitt", "brad.pitt@gmail.com");
        User thirdUser = new User(3,"Tom Kruise", "tommy@gmail.com");
        User fourthUser = new User(4,"Dwane Jonson", "rock.official@gmail.com");
        User fifthUser = new User(5,"Hugh Lorie", "hugh2106@gmail.com");

        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(firstUser);
        listOfUsers.add(secondUser);
        listOfUsers.add(thirdUser);
        listOfUsers.add(fourthUser);
        listOfUsers.add(fifthUser);

        Gson gson = new Gson();
        String jsonUsers = gson.toJson(listOfUsers);
        System.out.println(jsonUsers);

//        ServerSocket s = null;
//        try {
//            s = new ServerSocket(7777);
//            try (OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8)) {
//                out.write(jsonUsers.toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//----------------------------------------------------------------------------------------------------------------------
        // Converts JSON string into a collection of Student object.
        Type type = new TypeToken<List<User>>() {}.getType();
        List<User> usersList = gson.fromJson(jsonUsers, type);

        for (User user : usersList) {
            System.out.println(user.getName() + " " + user.getId() + " " + user.getEmail());
        }
    }
}
