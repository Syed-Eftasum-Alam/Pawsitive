package com.example.petadoption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

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
    public void switchtoSceneProfile(ActionEvent e)throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("Profile.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

    }
    @FXML
    public void switchtoSceneSignin1(ActionEvent e)throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("Sign1st.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

    }
    @FXML
    void switchtoRegpets(ActionEvent e) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("RegisteredPETS.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

    }
}
