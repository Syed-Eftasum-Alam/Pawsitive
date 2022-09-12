package com.example.petadoption;

import Classes.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DogsSectionController implements Initializable {

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

    @FXML
    private Button back1;

    @FXML
    private Button next1;

    // Data
    private int count;
    private ArrayList<Animal> list;
    @FXML
    private Button favourites;
    Rectangle[] rectangles;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Init();
    }

    // added data to rectangle
    private void refreshData(int currentPosition, boolean forward) {
        int j = 0;
        if(forward) {
            for (int i = currentPosition; i < list.size() && i < currentPosition + 6; i++, j++, count++)
                rectangles[j].setFill(new ImagePattern(new Image("file:" + list.get(i).getAnimalPic())));
        } else {
            int sub = count % 6;
            count -= sub;
            for (int i = currentPosition - sub - 6; j < 6; i++, j++, count--)
                rectangles[j].setFill(new ImagePattern(new Image("file:" + list.get(i).getAnimalPic())));
        }
        // updating button state
        if(forward) {
            for(int i = j; i < 6; i++)
                rectangles[i].setVisible(false);
        } else {
            for(int i = 0; i < 6; i++)
                rectangles[i].setVisible(true);
        }
        changeButtonState();
    }

    // Refresh button state based on how many element remains
    private void changeButtonState() {
        int rem = list.size() - count;
        back1.setDisable(rem > 5 || count < 7);
        next1.setDisable(rem < 1 || count > list.size());

    }

    private void readData(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
//                list.add(getAnimal(line));
            }
            br.close();
        } catch (Exception ignored) {}
    }

    private void Init() {
        // data init
        count = 0;
        list = new ArrayList<>();
        rectangles = new Rectangle[]{profile1, profile2, profile3, profile4, profile5, profile6};

        // load data
//        readData("cat.txt");
        readData("dog.txt");

        // Button Configs
        changeButtonState();

        // data box config
        for (int i = list.size(); i < 6; i++) {
            rectangles[i].setVisible(false);
        }

        // refresh data
        refreshData(count, true);
    }

    @FXML
    void nextActrion(ActionEvent event) {
        refreshData(count, true);
    }

    @FXML
    void backAction(ActionEvent event) {
        refreshData(count, false);
    }


    @FXML
    void exit(MouseEvent event) {
        System.exit(0);
    }
    @FXML
    public void switchtoSceneFav(ActionEvent e) throws IOException {
        Utils.changeScene("favourite.fxml");
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

    public void switchtoSceneHelloview(ActionEvent e) throws IOException {
        Utils.changeScene("hello-view.fxml");
    }
}
