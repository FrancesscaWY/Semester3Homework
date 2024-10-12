module lab1.example.lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab1.example.lab1 to javafx.fxml;
    exports lab1.example.lab1;
}