package com.example.petadoption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProfileCOntroller implements Initializable {

    @FXML
    private Button activity;
    @FXML
    private Button Logout;
    @FXML
    private Text contacttxt;

    @FXML
    private Text emailtxt;

    @FXML
    private Text locationtxt;

    @FXML
    private Text nameTxt;

    @FXML
    private Text usernameTxt;
    @FXML
    private Circle profilepic;
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
    public void switchtoSceneSignin1(ActionEvent e)throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("Sign1st.fxml")) ;

       Scene scene=new Scene(root);
       HelloApplication.primaryStage.setScene(scene);
       HelloApplication.primaryStage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameTxt.setText(HelloApplication.profile.getUsername());
        nameTxt.setText(HelloApplication.profile.getName());
        emailtxt.setText(HelloApplication.profile.getEmail());
        locationtxt.setText(HelloApplication.profile.getLocation());
        contacttxt.setText(HelloApplication.profile.getContact());

        // profile pic
//        try {
            profilepic.setFill(new ImagePattern(new Image("file:" + HelloApplication.profile.getProfilePic())));
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
    }
}
