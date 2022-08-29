package utils;

import com.example.petadoption.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.Objects;

public class Utils {    private static double xOffset;
    private static double yOffset;

    public static void makeDraggable(Scene scene) {
        // Make Scene Draggable
        scene.setOnMousePressed(event -> {
            xOffset = HelloApplication.primaryStage.getX() - event.getScreenX();
            yOffset = HelloApplication.primaryStage.getY() - event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
            HelloApplication.primaryStage.setX(event.getScreenX() + xOffset);
            HelloApplication.primaryStage.setY(event.getScreenY() + yOffset);
        });
    }


    public static void changeScene(String page, double h, double w) {
        try {
            HelloApplication.root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(page)));
            HelloApplication.scene = new Scene(HelloApplication.root, w, h);

            // Make Scene Transparent
            HelloApplication.scene.setFill(Color.TRANSPARENT);

            // Make Scene Draggable
            makeDraggable(HelloApplication.scene);

            // Apply CSS
//            HelloApplication.root.getStylesheets().add(Objects.requireNonNull(Main.class.getResource(Configs.css)).toExternalForm());

            HelloApplication.primaryStage.setScene(HelloApplication.scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeScene(String page) {
        try {
            HelloApplication.root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(page)));
            HelloApplication.scene = new Scene(HelloApplication.root);

            // Make Scene Transparent
            HelloApplication.scene.setFill(Color.TRANSPARENT);

            // Make Scene Draggable
            makeDraggable(HelloApplication.scene);

            // Apply CSS
//            HelloApplication.root.getStylesheets().add(Objects.requireNonNull(Main.class.getResource(Configs.css)).toExternalForm());

            HelloApplication.primaryStage.setScene(HelloApplication.scene);
            HelloApplication.primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sha256(final String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            final StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                final String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }

    public static String upload(File file, String path) {
        try {
            String ext = getFileExtension(file);
            String name = "" + LocalDateTime.now();
            path = path + sha256(name) + "." + ext;
            File dest = new File(path);
            Files.copy(file.toPath(), dest.toPath());
        } catch (IOException e) {}
        return path;
    }
}
