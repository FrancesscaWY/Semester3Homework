package javalearn.lab2;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

public class KGApp extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 全局采用垂直布局，上中下三个部分
        VBox global = new VBox();
        global.setPadding(new Insets(6.0));

        // 上排布局与控件
        HBox top = new HBox();
        TextField pathField = new TextField();
        pathField.setPromptText("文件路径");
        pathField.setDisable(true);
        Button openBtn = new Button("打开文件");
        top.getChildren().addAll(openBtn, pathField);
        HBox.setHgrow(pathField, Priority.ALWAYS);
        top.setSpacing(5);
        top.setPadding(new Insets(5));

        // 中排布局与控件
        SplitPane middle = new SplitPane();
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font(16));
        textArea.setWrapText(true); // 自动换行
        ScrollPane scroll = new ScrollPane(textArea);
        scroll.setFitToWidth(true); // 横向占满
        scroll.setFitToHeight(true); // 纵向占满
        KnowledgeGraphView view = new KnowledgeGraphView();
        middle.getItems().addAll(scroll, view);

        global.getChildren().addAll(top, middle);
        VBox.setVgrow(middle, Priority.ALWAYS); // 占满剩余空间
        Scene scene = new Scene(global, 600, 400);

        // 事件处理
        openBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                pathField.setText(selectedFile.getAbsolutePath());
                try {
                    textArea.setText(Files.readString(Paths.get(selectedFile.getAbsolutePath()), Charset.forName("utf-8")));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // 空格键触发实体创建事件
        textArea.setOnKeyPressed(e -> {
            switch(e.getCode()) {
                case SPACE : {
                    view.add(textArea.getSelectedText());
                }break;
                default : break;
            }
            e.consume();
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("图谱工具"); // 窗口标题
        primaryStage.show();
    }

}