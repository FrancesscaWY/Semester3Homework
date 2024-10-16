package javalearn.lab2;

import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Font;
import javalearn.lab2.view.KnowledgeGraphView;
import java.io.IOException;

public class KGApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox global = new VBox();
        global.setPadding(new Insets(5.0));

        HBox top = new HBox();
        TextField pathField = new TextField();
        pathField.setPromptText("File path");
        pathField.setDisable(true);
        Button openBtn = new Button("Open file");
        top.getChildren().addAll(openBtn,pathField);
        HBox.setHgrow(pathField,Priority.ALWAYS);
        top.setSpacing(5);
        top.setPadding(new Insets(5));

        SplitPane middle = new SplitPane();
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font(16));
        textArea.setWrapText(true);//wrap automatically
        ScrollPane scroll = new ScrollPane(textArea);
        scroll.setFitToWidth(true);//full the width;
        scroll.setFitToHeight(true);
        KnowledgeGraphView view = new KnowledgeGraphView();
        middle.getItems().addAll(scroll,view);

        global.getChildren().addAll(top,middle);
        VBox.setVgrow(middle,Priority.ALWAYS); // full the rest space
        Scene scene = new Scene(global,600,400);

        openBtn.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if(selectedFile != null){
                pathField.setText(selectedFile.getAbsolutePath());
                try{
                    textArea.setText(Files.readString(Paths.get(selectedFile.getAbsolutePath()),Charset.forName("utf-8")));
                }catch(IOException e1){
                    e1.printStackTrace();
                }
            }
        });

        textArea.setOnKeyPressed(e->{
            switch(e.getCode()) {
                case SPACE: {
                    view.add(textArea.getSelectedText());
                }
                break;
                default:
                    break;
            }
            e.consume();
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("Graph Tool");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}