package com.example.petadoption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import utils.Utils;

import java.io.IOException;

public class DogsSectionController {
    @FXML
    private Button RegPets;

    @FXML
    private Button activity;

    @FXML
    private Button profile;

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void minimize(MouseEvent e) {
        HelloApplication.primaryStage.setIconified(true);
    }

    @FXML
    public void switchtoSceneProfile(ActionEvent e) throws IOException {
        Utils.changeScene("Profile.fxml");
    }

    @FXML
    public void switchtoSceneSignin1(ActionEvent e) throws IOException {
        Utils.changeScene("Sign1st.fxml");
    }

    @FXML
    void switchtoRegpets(ActionEvent e) throws IOException {
        Utils.changeScene("RegisteredPETS.fxml");
    }
}
