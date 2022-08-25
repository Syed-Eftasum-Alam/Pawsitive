module PetAdoption {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.petadoption to javafx.fxml;
    exports com.example.petadoption;

    opens Classes to javafx.fxml;
    exports Classes;

}