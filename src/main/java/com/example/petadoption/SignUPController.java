package com.example.petadoption;

import Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import utils.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SignUPController {
    private File file;
    @FXML
    private Text warning;


    @FXML
    private Button Back1;

    @FXML
    private Button ConfirmU;

    @FXML
    private Text photoUploadUser;
    @FXML
    private TextField tfcontact;

    @FXML
    private TextField tfemail;

    @FXML
    private TextField tflocation;

    @FXML
    private TextField tfname;

    @FXML
    private TextField tfpassword;

    @FXML
    private TextField tfusername;
    @FXML
    private Text DupUsernameorEmail;
    @FXML
    private Text cIV;

    @FXML
    private Text eIV;

    @FXML
    private Text lIV;

    @FXML
    private Text nIV;

    @FXML
    private Text pIV;

    @FXML
    private Text uIV;


    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    public void fileSelector(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(HelloApplication.primaryStage);
        if (selectedFile == null)
            System.out.println(" - Canceled!");
        else {
            handleFile(selectedFile);
        }
    }

    @FXML
    private void handleFile(File selectedFile) {
        if (!selectedFile.getName().toLowerCase().endsWith(".jpg") && !selectedFile.getName().toLowerCase().endsWith(".png")) {
            warning.setText("File not Supported");
        } else
            warning.setText("");
            file = selectedFile;
    }

    @FXML
    void minimize(MouseEvent e) {

        HelloApplication.primaryStage.setIconified(true);
    }

    @FXML
    public void switchtoSceneHelloview(ActionEvent e) throws IOException {
        Utils.changeScene("hello-view.fxml");
    }

    @FXML
    public void UserInfosave(ActionEvent e) throws IOException {
        HashMap<String, User> u = new HashMap<>();
        boolean check2 = false;
        boolean check = false;


        String name = tfname.getText();
        String Username = tfusername.getText();
        String password = tfpassword.getText();
        String Email = tfemail.getText();
        String location = tflocation.getText();
        String contact = tfcontact.getText();
        File f2 = new File("data.txt");
        Scanner sc = new Scanner(f2);
        String line = " ";
        if (name.isEmpty()) {
            nIV.setText("*");
            check2 = true;

        } else {
            nIV.setText("");
        }
        if (Username.isEmpty()) {
            uIV.setText("*");
            check2 = true;

        } else {
            uIV.setText("");
        }
        if (password.isEmpty()) {
            pIV.setText("*");
            check2 = true;

        } else {
            pIV.setText("");
        }
        if (Email.isEmpty()) {
            eIV.setText("*");
            check2 = true;

        } else {
            eIV.setText("");
        }
        if (location.isEmpty()) {
            lIV.setText("*");
            check2 = true;

        } else {
            lIV.setText("");
        }
        if (contact.isEmpty()) {
            cIV.setText("*");
            check2 = true;

        } else {
            cIV.setText("");
        }
        if (!check2) {
            while (sc.hasNext()) {
                line = sc.nextLine();
                String[] parts = line.split("##");
                String name1 = parts[0];
                String userName1 = parts[1];
                String password1 = parts[2];
                String Email1 = parts[3];
                String location1 = parts[4];
                String contact1 = parts[5];
                u.put(Email1, new User(name1, userName1, password1, Email1, location1, contact1));
                u.put(userName1, new User(name1, userName1, password1, Email1, location1, contact1));
            }
            sc.close();
            check = u.containsKey(Email) || u.containsKey(Username);
            if (check) {
                DupUsernameorEmail.setText("The username or the Email is already in use");
            } else {
                String profilePic = Utils.upload(file, "uploads/img/");
                BufferedWriter f = new BufferedWriter(new FileWriter("data.txt", true));
                User u1 = new User(name, Username, password, Email, location, contact, profilePic);

                f.write(name + "##");
                f.write(Username + "##");
                f.write(password + "##");
                f.write(Email + "##");
                f.write(location + "##");
                f.write(contact + "##");
                f.write(profilePic);
                f.newLine();

                u.put(Username, u1);
                u.put(Email, u1);

                f.close();
                Utils.changeScene("hello-view.fxml");
            }
        }
    }
}










