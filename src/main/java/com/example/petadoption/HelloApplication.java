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

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    public static User profile;
    public static Stage primaryStage;
//    private double xOffset=0;
//    private double yOffset=0;
    @Override
    public void start(Stage stage) throws IOException {

        primaryStage=stage;
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene= new Scene(root);
        Image icon=new Image("D:\\Aop Project\\PetAdoption\\src\\main\\resources\\img\\dog-cat-bunny-bird-love-removebg-preview.png");
        stage.getIcons().add(icon);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("4 PAWsitive");
        stage.setScene(scene);
        stage.setResizable(false);
        makeDraggable(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }

    private static double xOffset;
    private static double yOffset;

    public static void makeDraggable(Scene scene) {
        // Make Scene Draggable
        scene.setOnMousePressed(event -> {
            xOffset = primaryStage.getX() - event.getScreenX();
            yOffset = primaryStage.getY() - event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() + xOffset);
            primaryStage.setY(event.getScreenY() + yOffset);
        });
    }
}