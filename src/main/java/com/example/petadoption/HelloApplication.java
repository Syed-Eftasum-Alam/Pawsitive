package com.example.petadoption;


import Classes.User;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.Operations;
import utils.Utils;

import java.io.*;
import java.net.Socket;

public class HelloApplication extends Application {
    public static User profile;
    public static Stage primaryStage;
    public static Parent root;
    public static Scene scene;
    public static Socket sc;
    public static ObjectOutputStream sendObj;
    public static ObjectInputStream receiveObj;

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Stage Settings
        primaryStage = stage;
//        stage.getIcons().add(new Image("D:\\Aop Project\\PetAdoption\\src\\main\\resources\\img\\dog-cat-bunny-bird-love-removebg-preview.png"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("4 PAWsitive");
        stage.setResizable(false);

        // Server Configure
        sc = new Socket(Configs.server, Configs.port);
        OutputStream oo = sc.getOutputStream();
        sendObj = new ObjectOutputStream(oo);

        InputStream inputStream = sc.getInputStream();
        receiveObj = new ObjectInputStream(inputStream);

        File f2 = new File(Configs.userTempData);
        if (f2.exists()) f2.delete();

        Utils.changeScene(Configs.homeScene);
    }
}