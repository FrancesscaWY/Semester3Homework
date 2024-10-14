module javalearn.lab2.lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens javalearn.lab2.view to javafx.fxml;
    exports javalearn.lab2.view;
}