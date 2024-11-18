module javalearn.lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens javalearn.lab4 to javafx.fxml;
    exports javalearn.lab4;
}