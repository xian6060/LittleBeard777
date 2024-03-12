module com.example.nobeard777 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nobeard777 to javafx.fxml;
    exports com.example.nobeard777;
}