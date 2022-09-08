package com.example.petadoption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import utils.Utils;

import java.io.IOException;

public class Sign1stController {
    private String AnimalType;

    @FXML
    private Button Upforadoption;
    @FXML
    private Button Adopting;

    @FXML
    private Button profile;

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
    public void switchtoSceneFav(ActionEvent e) throws IOException {
        Utils.changeScene("favourite.fxml");
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
    public void switchtoSceneCatorDog(ActionEvent e) throws IOException {

        AnimalType = "dog";
        Utils.changeScene("CatorDog.fxml");
    }

    @FXML
    public void switchtoSceneProfile(ActionEvent e) throws IOException {
        Utils.changeScene("Profile.fxml");
    }

    @FXML
    void switchtoCatorDogForAdoption(ActionEvent event) throws IOException {
        Utils.changeScene("CatorDogForadoption.fxml");
    }
}
