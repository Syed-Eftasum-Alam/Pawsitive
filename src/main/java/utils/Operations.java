package utils;

import Classes.Animal;
import Classes.User;
import com.example.petadoption.Configs;
import com.example.petadoption.HelloApplication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static com.example.petadoption.HelloApplication.receiveObj;
import static com.example.petadoption.HelloApplication.sendObj;

public class Operations {
    public static boolean signIn(User user, ObjectInputStream receiveObj, ObjectOutputStream sendObj) {
        try {
            // sending credentials
            System.out.println(" - Sending credentials");
            System.out.println(" - Requesting for login");
            sendObj.writeObject("login");
            sendObj.writeObject(user);

            // reading response
            String response = (String) receiveObj.readObject();
            System.out.println(" - Received response: " + response);
            if (response.contains("SUCCESS")) {
                System.out.println(" - Received logged user info from server");
                HelloApplication.profile = (User) receiveObj.readObject();
                System.out.println(" - Saving user info for later use");
                FileIO.writeObjToFile(HelloApplication.profile, Configs.userTempData);    // writing info to a temp file
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static int signup(User user) {
        try {

            // sending registration data
            System.out.println(" - Sending credentials");
            System.out.println(" - Requesting for registration");
            sendObj.writeObject("signup");
            sendObj.writeObject(user);

            // reading response
            String response = (String) receiveObj.readObject();
            System.out.println(" - Received response: " + response);
            if (response.contains("SUCCESS")) {
                System.out.println(" - Registration Successful!");
                return 1;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void addAnimal(Animal animal) {
        try {
            // sending registration data
            System.out.println(" - Sending Animal Info");
            System.out.println(" - Requesting for Add Animal");
            sendObj.writeObject("addAnimal");
            sendObj.writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePetStatus(Animal a) {
        try {
            // sending registration data
            System.out.println(" - Sending Animal Info");
            System.out.println(" - Requesting for Update Animal Availability");
            sendObj.writeObject("updatePetStatus");
            sendObj.writeObject(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
