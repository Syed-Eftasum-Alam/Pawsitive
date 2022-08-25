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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DogRegController {

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
        if(!selectedFile.getName().endsWith(".jpg")&&!selectedFile.getName().endsWith(".png")){
            warning.setText("File not Supported");

        }
        else{
            warning.setText("");
        }


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
    @FXML
    void DoginfoSave(ActionEvent event) throws IOException {

        AnimalType="dog";

        BufferedWriter f = new BufferedWriter(new FileWriter("dog.txt", true));
        String BreedName=tfBname.getText();
        String PetName=tfPname.getText();
        String Age= tfAge.getText();
        String FoodHabit=tfFoodhabit.getText();

        if(BreedName.isEmpty()){
            Biv.setText("*");
        } else if (PetName.isEmpty()) {
            Piv.setText("*");

        } else if (Age.isEmpty()) {
            Aiv.setText("*");

        } else if (FoodHabit.isEmpty()) {
            Fiv.setText("*");
        }
        else {
            Animal dog= new Animal(BreedName,PetName,Age,FoodHabit,AnimalType,HelloApplication.profile.getUsername());

            f.write(BreedName+"##");
            f.write(PetName+"##");
            f.write(Age+"##");
            f.write(FoodHabit+"##");
            f.write(AnimalType+"##");
            f.write(HelloApplication.profile.getUsername());
            f.newLine();
            f.close();


            Parent root= FXMLLoader.load(getClass().getResource("Sign1st.fxml")) ;

            Scene scene=new Scene(root);
            HelloApplication.primaryStage.setScene(scene);
            HelloApplication.primaryStage.show();


        }


    }

}
