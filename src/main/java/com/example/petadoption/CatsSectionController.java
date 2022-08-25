package com.example.petadoption;

import Classes.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CatsSectionController implements Initializable {

    @FXML
    private Button RegPets;

    @FXML
    private Button activity;

    @FXML
    private Button profile;
    @FXML
    private Button Logout;
    @FXML
    private Rectangle profile1;

    @FXML
    private Rectangle profile2;

    @FXML
    private Rectangle profile3;

    @FXML
    private Rectangle profile4;

    @FXML
    private Rectangle profile5;

    @FXML
    private Rectangle profile6;

//     Data
    private ArrayList<Animal> list;


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
        HelloApplication.makeDraggable(scene);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

    }
    @FXML
    public void switchtoSceneSignin1(ActionEvent e)throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("Sign1st.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.makeDraggable(scene);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();

    }
    @FXML
    void switchtoRegpets(ActionEvent e) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("RegisteredPETS.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.makeDraggable(scene);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();
    }

    public void switchtoSceneHelloview(ActionEvent e)throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml")) ;

        Scene scene=new Scene(root);
        HelloApplication.makeDraggable(scene);
        HelloApplication.primaryStage.setScene(scene);
        HelloApplication.primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Init();
    }

    private Animal getAnimal(String str) {
        String[] p = str.split("##");
        return new Animal(p[0], p[1], p[2], p[3], p[4], p[5], p[6]);
    }

    private void readData(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line=br.readLine()) != null) {
                list.add(getAnimal(line));
            }
            br.close();
        } catch (Exception e) {}
    }

    private void Init(){
        list = new ArrayList<>();
        readData("cat.txt");
        readData("dog.txt");

        // array
        Rectangle[] rectangles = {profile1, profile2, profile3, profile4, profile5, profile6};
        for(int i = list.size(); i < 6; i++) {
            rectangles[i].setVisible(false);
        }

        for(int i = 0; i < list.size(); i++) {
            rectangles[i].setFill(new ImagePattern(new Image("file:" + list.get(i).getAnimalPic())));
        }
    }
}
