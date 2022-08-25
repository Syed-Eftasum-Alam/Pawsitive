package com.example.petadoption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CatorDogForAdoption {

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
    void switchtoRegpets(ActionEvent e) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("RegisteredPETS.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

    }

    public void switchtoSceneHelloview(ActionEvent e)throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

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
    public void switchtoSceneCatSec(ActionEvent e)throws IOException {

        AnimalType ="cat";


        Parent root= FXMLLoader.load(getClass().getResource("CatsSection.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

    }

    @FXML
    public void switchtoSceneDogSec(ActionEvent e)throws IOException {
        AnimalType ="dog";

        Parent root= FXMLLoader.load(getClass().getResource("DogsSection.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

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

}


