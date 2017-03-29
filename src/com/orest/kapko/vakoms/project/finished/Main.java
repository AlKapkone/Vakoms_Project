package com.orest.kapko.vakoms.project.finished;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.security.auth.SolarisNumericUserPrincipal;
import org.json.JSONArray;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};
//        int response = JOptionPane.showOptionDialog(null, "Message", "Title",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
//                null, options, options[0]);

//        int result = JOptionPane.showConfirmDialog(null,
//                "Are you sure you wish to exit application?",null, JOptionPane.YES_NO_OPTION);
//        if(result == JOptionPane.YES_OPTION) {
//            System.exit(0);
//        }

        User firstUser = new User(1,"Kapko Orest", "kapko2311@gmail.com");
        User secondUser = new User(2,"Brad Peate", "kapko2311@gmail.com");
        User thirdUser = new User(3,"Tom Kruise", "kapko2311@gmail.com");
        User fourthUser = new User(4,"Dwane Jonson", "kapko2311@gmail.com");
        User fifthUser = new User(5,"Hugh Lorie", "kapko2311@gmail.com");

        ArrayList<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(firstUser);
        listOfUsers.add(secondUser);
        listOfUsers.add(thirdUser);
        listOfUsers.add(fourthUser);
        listOfUsers.add(fifthUser);
        JSONArray jsArray = new JSONArray(listOfUsers);
    }
}
