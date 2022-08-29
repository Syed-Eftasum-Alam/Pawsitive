package com.example.petadoption;


import Classes.User;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.Utils;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    public static User profile;
    public static Stage primaryStage;
    public static Parent root;
    public static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        // Stage Settings
        primaryStage=stage;
        stage.getIcons().add(new Image("D:\\Aop Project\\PetAdoption\\src\\main\\resources\\img\\dog-cat-bunny-bird-love-removebg-preview.png"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("4 PAWsitive");
        stage.setResizable(false);

        // Start
        Utils.changeScene("hello-view.fxml");
    }

    public static void main(String[] args) {

        launch();
    }
}