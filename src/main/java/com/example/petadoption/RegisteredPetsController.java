package com.example.petadoption;

import Classes.Animal;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class RegisteredPetsController implements Initializable {
    private HashMap<String, Animal>pets;
    private ArrayList<Animal> petList;
    private int counter;

    @FXML
    private Parent root;
    private Scene scene;
    private Stage stage;
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
    void switchtoSceneSignin1(ActionEvent e) throws IOException {
        Utils.changeScene("Sign1st.fxml");
    }

    private Animal genANumal(String line) {
        String[] pasts = line.trim().split("##");
        String breed = pasts[0];
        String name = pasts[1];
        String age = pasts[2];
        String food = pasts[3];
        String type = pasts[4];
        String owner = pasts[5];
        return  new Animal(breed, name, age, food, type, owner);
    }


    private void LoadpetsData() {
        try{
            // Reads dog info
            BufferedReader br = new BufferedReader(new FileReader("dog.txt"));
            String line;
            while((line = br.readLine()) != null) {
                Animal a = genANumal(line);
                if(a.getOwner().equalsIgnoreCase(HelloApplication.profile.getUsername())) {
                    pets.put(a.getOwner(), a);
                    petList.add(a);
                }
            }
            br.close();

            // Reads Cat info
            br = new BufferedReader(new FileReader("cat.txt"));
            while((line = br.readLine()) != null) {
                Animal a = genANumal(line);
                if(a.getOwner().equalsIgnoreCase(HelloApplication.profile.getUsername())) {
                    pets.put(a.getOwner(), a);
                    petList.add(a);
                }
            }
            br.close();
        }
        catch (IOException exception){}
    }


    private void updateData(int counter) {
        Animal p = petList.get(counter);
        previous.setDisable(true);

        // Set Info
        txtpet.setText(p.getPetname());
        txtbreed.setText(p.getBreedName());
        txtage.setText(p.getAge());
        txtfood.setText(p.getFoodhabit());
        //imgShow.setFill(new ImagePattern(new Image("file:"+p.getAnimalPic())));

        // next button
        if(counter + 1 == petList.size())
            after.setDisable(true);
        else if(counter + 1 < petList.size())
            after.setDisable(false);

        // Previous Button
        if(counter > 0)
            previous.setDisable(false);
        else if(counter - 1 <= 0)
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
        profilepic.setFill(new ImagePattern(new Image("file:" + HelloApplication.profile.getProfilePic())));



        // loading data
        petList = new ArrayList<>();
        pets=new HashMap<>();
        LoadpetsData();

        // Set first data
        counter = 0;
        if(!(petList.size() == 0)) {
            aPane.setVisible(false);
            maInPane.setVisible(true);
            updateData(counter);
        }
        else {
            maInPane.setVisible(false);
            aPane.setVisible(true);
        }

    }
}
