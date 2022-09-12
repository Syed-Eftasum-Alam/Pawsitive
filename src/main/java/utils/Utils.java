package utils;

import Classes.Img;
import com.example.petadoption.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static String imgToBase64(String imgPath) {
        // image path declaration
        String imageString;

        // read image from file
        FileInputStream stream;
        try {
            stream = new FileInputStream(imgPath);
            // get byte array from image stream
            int bufLength = 2048;
            byte[] buffer = new byte[2048];
            byte[] data;

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int readLength;
            while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
                out.write(buffer, 0, readLength);
            }

            data = out.toByteArray();
            imageString = Base64.getEncoder().withoutPadding().encodeToString(data);

            out.close();
            stream.close();
//            System.out.println("Encode Image Result : " + imageString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return imageString;
    }

    public static String base64ToImg(String base64string, String extension, String imgPath, String fileName){
        String path;
        //convert base64 string to binary data
        byte[] data =  Base64.getDecoder().decode(base64string);
        if(fileName == null)
            fileName = UUID.randomUUID().toString();
        path = imgPath + fileName + "." + extension;
        File file = new File(path);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
    public static String base64ToImg(Img img, String imgPath) {
        return base64ToImg(img.getBase64(), img.getExtension(), imgPath, null);
    }

    public static String base64ToImg(Img img, String imgPath, String imgName) {
        return base64ToImg(img.getBase64(), img.getExtension(), imgPath, imgName);
    }

    public static String getUserProfilePic() {
        Img img = HelloApplication.profile.getProfilePic();
        return Utils.base64ToImg(img, "", img.getPath());
    }

    public static Img fileToImg(File file) {
        return new Img(Utils.getFileExtension(file), Utils.imgToBase64(file.getPath()));
    }

    public static String imgTotempImg(Img img) {
        return Utils.base64ToImg(img, "", img.getPath());
    }
}
