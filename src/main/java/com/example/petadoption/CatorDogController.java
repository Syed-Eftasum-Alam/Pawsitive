package com.example.petadoption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import utils.Utils;

import java.io.IOException;

public class CatorDogController {

    @FXML
    private Button Bcat;

    @FXML
    private Button Bdog;

    @FXML
    private Text Cat;

    @FXML
    private Text Dog;

    @FXML
    private Button activity;

    @FXML
    private Button profile;
    private String AnimalType;

    @FXML
    private Button Logout;
    @FXML
    private Button RegPets;
    @FXML
    private Button favourites;

    @FXML
    void switchtoRegpets(ActionEvent e) throws IOException {
        Utils.changeScene("RegisteredPETS.fxml");
    }

    public void switchtoSceneHelloview(ActionEvent e) throws IOException {
        Utils.changeScene("hello-view.fxml");
    }

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void minimize(MouseEvent e) {
        HelloApplication.primaryStage.setIconified(true);
    }

    @FXML
    public void switchtoSceneCatReg(ActionEvent e) throws IOException {
        AnimalType = "cat";
        Utils.changeScene("CatReg.fxml");
    }

    @FXML
    public void switchtoSceneDogReg(ActionEvent e) throws IOException {
        AnimalType = "dog";
        Utils.changeScene("DogReg.fxml");
    }

    @FXML
    public void switchtoSceneProfile(ActionEvent e) throws IOException {
        Utils.changeScene("Profile.fxml");
    }

    @FXML
    public void switchtoSceneSignin1(ActionEvent e) throws IOException {
        Utils.changeScene("Sign1st.fxml");
    }

}
