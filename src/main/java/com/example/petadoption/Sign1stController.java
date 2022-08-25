package com.example.petadoption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    public void switchtoSceneCatorDog(ActionEvent e)throws IOException {

        AnimalType ="dog";
        Parent root= FXMLLoader.load(getClass().getResource("CatorDog.fxml")) ;
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
    void switchtoCatorDogForAdoption(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("CatorDogForadoption.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

    }

}
