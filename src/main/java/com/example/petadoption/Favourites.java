package com.example.petadoption;

import Classes.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import utils.FileIO;
import utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import static com.example.petadoption.HelloApplication.receiveObj;
import static com.example.petadoption.HelloApplication.sendObj;

public class Favourites implements Initializable {
    Animal currentAnimal;
    private HashMap<String, Animal> pets;
    private ArrayList<Animal> petList;
    private int counter;
    @FXML
    private Button RegPets;
    @FXML
    private Button Logout;
    @FXML
    private Button activity;
    @FXML
    private Button profile;
    @FXML
    private Circle profilepic;
    @FXML
    private Text txtname;
    @FXML
    private Text txtusername;
    @FXML
    private Text txtage;
    @FXML
    private Text txtbreed;
    @FXML
    private Text txtfood;
    @FXML
    private Text txtpet;
    @FXML
    private Button previous;
    @FXML
    private Button after;
    @FXML
    private AnchorPane aPane;
    @FXML
    private AnchorPane maInPane;
    @FXML
    private Rectangle imgShow;
    @FXML
    private Button favourites;

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

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
    void switchtoSceneProfile(ActionEvent e) throws IOException {
        Utils.changeScene("Profile.fxml");
    }

    @FXML
    void switchtoRegpets(ActionEvent e) throws IOException {
        Utils.changeScene("RegisteredPETS.fxml");
    }

    @FXML
    void switchtoSceneSignin1(ActionEvent e) throws IOException {
        Utils.changeScene("Sign1st.fxml");
    }


    private void LoadpetsData() {
        try {
            // Asking for Cat Info
            System.out.println(" - Requesting for Favorite Animal List");
            sendObj.writeObject("getFavouriteList");
            sendObj.writeObject(FileIO.readObjFromFile(Configs.userTempData));
            petList = (ArrayList<Animal>) receiveObj.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void updateData(int counter) {
        Animal p = petList.get(counter);
        currentAnimal = p;
        previous.setDisable(true);

        // Set Info
        txtpet.setText(p.getPetname());
        txtbreed.setText(p.getBreedName());
        txtage.setText(p.getAge());
        txtfood.setText(p.getFoodhabit());
        imgShow.setFill(new ImagePattern(new Image("file:" + Utils.imgTotempImg(p.getAnimalPic()))));

        // next button
        if (counter + 1 == petList.size())
            after.setDisable(true);
        else if (counter + 1 < petList.size())
            after.setDisable(false);

        // Previous Button
        if (counter > 0)
            previous.setDisable(false);
        else if (counter - 1 <= 0)
            previous.setDisable(true);
    }

    @FXML
    void afterAction(ActionEvent event) {
        counter++;
        updateData(counter);
    }

    @FXML
    void previousAction(ActionEvent event) {
        counter--;
        updateData(counter);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtname.setText(HelloApplication.profile.getName());
        txtusername.setText(HelloApplication.profile.getUsername());
        profilepic.setFill(new ImagePattern(new Image("file:" + Utils.getUserProfilePic())));

        // loading data
        petList = new ArrayList<>();
        LoadpetsData();

        // Set first data
        counter = 0;
        if (!(petList.size() == 0)) {
            aPane.setVisible(false);
            maInPane.setVisible(true);
            updateData(counter);
        } else {
            maInPane.setVisible(false);
            aPane.setVisible(true);
        }
    }
}
