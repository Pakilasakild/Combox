module com.example.combox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.combox to javafx.fxml;
    exports com.example.combox;
}