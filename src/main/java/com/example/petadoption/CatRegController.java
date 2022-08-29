package com.example.petadoption;

import Classes.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.Utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class CatRegController {

    private File file;

    @FXML
    private TextField tfAge;

    @FXML
    private TextField tfBname;

    @FXML
    private TextArea tfFoodhabit;

    @FXML
    private TextField tfPname;

    @FXML
    private Button Back2;

    @FXML
    private Button ConfirmC;

    @FXML
    private Text photoUploadCat;
    @FXML
    private Text warning;

    private String AnimalType;
    @FXML
    private Text Fiv;
    @FXML
    private Text Aiv;

    @FXML
    private Text Piv;
    @FXML
    private Text Biv;

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void minimize(MouseEvent e) {

        HelloApplication.primaryStage.setIconified(true);
    }


    @FXML
    public void fileSelector(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(HelloApplication.primaryStage);
        if (selectedFile == null)
            System.out.println(" - Canceled!");
        else {
            handleFile(selectedFile);
        }
    }

    private void handleFile(File selectedFile) {
        if(!selectedFile.getName().endsWith(".jpg")&&!selectedFile.getName().endsWith(".png")){
            warning.setText("File not Supported");
        }
        else{
            file = selectedFile;
        }
    }

    @FXML
    public void switchtoSceneSignin1(ActionEvent e)throws IOException {
        Utils.changeScene("Sign1st.fxml");
    }
    @FXML
    void CatinfoSave(ActionEvent event) throws  IOException {


        boolean isEmpty =false;
        AnimalType="Cat";

        BufferedWriter f = new BufferedWriter(new FileWriter("cat.txt", true));
        String BreedName=tfBname.getText();
        String PetName=tfPname.getText();
        String Age= tfAge.getText();
        String FoodHabit=tfFoodhabit.getText();

        if(BreedName.isEmpty()){
            Biv.setText("*");
            isEmpty=true;
        }
        else {
            Biv.setText("");
        }
        if (PetName.isEmpty()) {
            Piv.setText("*");
            isEmpty=true;
        }
        else {
            Piv.setText("");
        }
        if (Age.isEmpty()) {
            Aiv.setText("*");
            isEmpty=true;
        }
        else {
            Aiv.setText("");
        }
        if (FoodHabit.isEmpty()) {
            Fiv.setText("*");
            isEmpty=true;
        }
        else {
            Fiv.setText("");

        }
        if (!isEmpty){
//            Animal cat= new Animal(BreedName,PetName,Age,FoodHabit,AnimalType,HelloApplication.profile.getUsername());
            String profilePic = Utils.upload(file, "uploads/img/");
            Animal Cats= new Animal(BreedName,PetName,Age,FoodHabit,AnimalType,HelloApplication.profile.getName(),profilePic);

            f.write(BreedName+"##");
            f.write(PetName+"##");
            f.write(Age+"##");
            f.write(FoodHabit+"##");
            f.write(AnimalType+"##");
            f.write(HelloApplication.profile.getUsername()+"##");
            f.write(profilePic);

            f.newLine();
            f.close();
            Utils.changeScene("Sign1st.fxml");
        }
    }
}

