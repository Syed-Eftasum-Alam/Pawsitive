package com.example.petadoption;

import Classes.Animal;
import Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimalProfile implements Initializable {

    @FXML
    private Button AddFav;

    @FXML
    private Text Age;

    @FXML
    private Button Logout;

    @FXML
    private Button RegPets;

    @FXML
    private AnchorPane aPane;

    @FXML
    private Button activity;

    @FXML
    private Text breedName;

    @FXML
    private Text contactNumber;

    @FXML
    private Button favourites;

    @FXML
    private Text foodHabit;

    @FXML
    private Text location;

    @FXML
    private Text ownersName;

    @FXML
    private Text txtAdoptionStatus;

    @FXML
    private Text petsName;

    @FXML
    private Button profile;
    @FXML
    private Rectangle animalPic;

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void minimize(MouseEvent e) {

        HelloApplication.primaryStage.setIconified(true);
    }
    @FXML
    void switchtoRegpets(ActionEvent e) throws IOException {
        Utils.changeScene("RegisteredPETS.fxml");
    }

    public void switchtoSceneHelloview(ActionEvent e) throws IOException {
        Utils.changeScene("hello-view.fxml");
    }


    @FXML
    public void switchtoSceneProfile(ActionEvent e) throws IOException {
        Utils.changeScene("Profile.fxml");
    }
    @FXML
    public void switchtoSceneFav(ActionEvent e) throws IOException {
        Utils.changeScene("favourite.fxml");
    }

    @FXML
    public void switchtoSceneSignin1(ActionEvent e) throws IOException {
        Utils.changeScene("Sign1st.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Animal a = HelloApplication.animal;
        breedName.setText(a.getBreedName());
        petsName.setText(a.getPetname());
        Age.setText(a.getAge());
        foodHabit.setText(a.getFoodhabit());
        animalPic.setFill(new ImagePattern(new Image("file:" + Utils.imgTotempImg(a.getAnimalPic()))));
        txtAdoptionStatus.setText(a.getStatus());
        User owner;
        try {
            HelloApplication.sendObj.writeObject("getUserFromUserName");
            HelloApplication.sendObj.writeObject(a.getOwner());
            owner = (User) HelloApplication.receiveObj.readObject();

            // Update Owner Info
            ownersName.setText(owner.getName());
            System.out.println(" - Owner Name: " + owner.getName());
            location.setText(owner.getLocation());
            contactNumber.setText(owner.getContact());
        } catch (Exception ignored) {}
    }
}