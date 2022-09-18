package com.example.petadoption;

import Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import utils.Operations;
import utils.Utils;

import java.io.File;
import java.io.IOException;

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
    public void UserInfosave(ActionEvent e) {
        boolean check = false;

        String name = tfname.getText();
        String Username = tfusername.getText();
        String password = tfpassword.getText();
        String Email = tfemail.getText();
        String location = tflocation.getText();
        String contact = tfcontact.getText();

        if (!Utils.validateEmail(Email)) {
            warning.setText("Invalid Email Address!");
            return;
        }

        if (name.isEmpty()) {
            nIV.setText("*");
            check = true;

        } else {
            nIV.setText("");
        }
        if (Username.isEmpty()) {
            uIV.setText("*");
            check = true;

        } else {
            uIV.setText("");
        }
        if (password.isEmpty()) {
            pIV.setText("*");
            check = true;

        } else {
            pIV.setText("");
        }
        if (Email.isEmpty()) {
            eIV.setText("*");
            check = true;

        } else {
            eIV.setText("");
        }
        if (location.isEmpty()) {
            lIV.setText("*");
            check = true;

        } else {
            lIV.setText("");
        }
        if (contact.isEmpty()) {
            cIV.setText("*");
            check = true;

        } else {
            cIV.setText("");
        }

        if (!check) {
            // register
            User u1 = new User(name, Username, password, Email, location, contact, Utils.fileToImg(file));

            int res = Operations.signup(u1);

            if (res == 1)
                Utils.changeScene(Configs.homeScene);
            else
                DupUsernameorEmail.setText("The username or the Email is already in use");
        }
    }
}










