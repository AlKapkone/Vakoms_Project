package com.orest.kapko.vakoms.project.finished;

import com.google.gson.Gson;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

class Server {
    public static void main(String args[]) {

        User firstUser = new User(1,"Kapko Orest", "kapko2311@gmail.com");
        User secondUser = new User(2,"Brad Pitt", "brad.pitt@gmail.com");
        User thirdUser = new User(3,"Tom Kruise", "tommy@gmail.com");
        User fourthUser = new User(4,"Dwane Jonson", "rock.officicial@gmail.com");
        User fifthUser = new User(5,"Hugh Lorie", "hugh2106@gmail.com");

        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(firstUser);
        listOfUsers.add(secondUser);
        listOfUsers.add(thirdUser);
        listOfUsers.add(fourthUser);
        listOfUsers.add(fifthUser);

        Gson gson = new Gson();
        String jsonUsers = gson.toJson(listOfUsers);

        try {
            ServerSocket srvr = new ServerSocket(1234);
            Socket skt = srvr.accept();
            System.out.print("Server has connected!\n");
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            System.out.print("Sending Json-string: '" + jsonUsers + "'\n");
            out.print(jsonUsers);
            out.close();
            skt.close();
            srvr.close();
        }
        catch(Exception e) {
            System.out.print("Whoops! It didn't work!\n");
        }
    }


}

