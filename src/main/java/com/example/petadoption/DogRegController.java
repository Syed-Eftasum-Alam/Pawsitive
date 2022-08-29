package com.example.petadoption;

import Classes.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import utils.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DogRegController {
    private File file;

    @FXML
    private Button Back3;

    @FXML
    private Button ConfirmD;

    @FXML
    private Text photoUploadDog;

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
    private TextField tfAge;

    @FXML
    private TextField tfBname;

    @FXML
    private TextArea tfFoodhabit;

    @FXML
    private TextField tfPname;


    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

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
        if (!selectedFile.getName().endsWith(".jpg") && !selectedFile.getName().endsWith(".png")) {
            warning.setText("File not Supported");

        } else {
            file = selectedFile;
        }


    }

    @FXML
    void minimize(MouseEvent e) {

        HelloApplication.primaryStage.setIconified(true);
    }

    @FXML
    public void switchtoSceneSignin1(ActionEvent e) throws IOException {
        Utils.changeScene("Sign1st.fxml");
    }

    @FXML
    void DoginfoSave(ActionEvent event) throws IOException {

        AnimalType = "dog";
        boolean isEmpty = false;

        BufferedWriter f = new BufferedWriter(new FileWriter("dog.txt", true));
        String BreedName = tfBname.getText();
        String PetName = tfPname.getText();
        String Age = tfAge.getText();
        String FoodHabit = tfFoodhabit.getText();

        if (BreedName.isEmpty()) {
            Biv.setText("*");
        } else if (PetName.isEmpty()) {
            Piv.setText("*");

        } else if (Age.isEmpty()) {
            Aiv.setText("*");

        } else if (FoodHabit.isEmpty()) {
            Fiv.setText("*");
        }
        if (BreedName.isEmpty()) {
            Biv.setText("*");
            isEmpty = true;
        } else {
            Biv.setText("");
        }
        if (PetName.isEmpty()) {
            Piv.setText("*");
            isEmpty = true;
        } else {
            Piv.setText("");
        }
        if (Age.isEmpty()) {
            Aiv.setText("*");
            isEmpty = true;
        } else {
            Aiv.setText("");
        }
        if (FoodHabit.isEmpty()) {
            Fiv.setText("*");
            isEmpty = true;
        } else {
            Fiv.setText("");

        }
        if (!isEmpty) {

            String profilePic = Utils.upload(file, "uploads/img/");
            Animal dog = new Animal(BreedName, PetName, Age, FoodHabit, AnimalType, HelloApplication.profile.getUsername(), profilePic);

            f.write(BreedName + "##");
            f.write(PetName + "##");
            f.write(Age + "##");
            f.write(FoodHabit + "##");
            f.write(AnimalType + "##");
            f.write(HelloApplication.profile.getUsername() + "##");
            f.write(profilePic);
            f.newLine();
            f.close();

            Utils.changeScene("Sign1st.fxml");
        }
    }
}
