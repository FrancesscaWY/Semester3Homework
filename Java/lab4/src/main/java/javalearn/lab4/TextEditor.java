package javalearn.lab4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class TextEditor extends Application {
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage)throws Exception{
        VBox global = new VBox();
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("文件");
        MenuItem newItem = new MenuItem("新建");
        MenuItem openItem = new MenuItem("打开");
        MenuItem saveItem = new MenuItem("保存");
        MenuItem saveAsItem = new MenuItem("另存为");
        menu.getItems().addAll(newItem,openItem,saveItem,saveAsItem);
        mb.getMenus().add(menu);

        FileTextArea textArea = new FileTextArea();
        textArea.setFont(Font.font("Arial",22));
        VBox textLayout = new VBox();
        textLayout.setPadding(new Insets(5.0));
        textLayout.getChildren().add(textArea);
        global.getChildren().addAll(mb,textLayout);

        //剩余空间填充
        VBox.setVgrow(textArea, Priority.ALWAYS);
        VBox.setVgrow(textLayout,Priority.ALWAYS);

        newItem.setOnAction(e->{
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("文本文件",".txt" ,".md"));
            File selected = chooser.showSaveDialog(primaryStage);
            if(selected != null){
                textArea.clear();
                try {
                    textArea.saveAs(selected.getPath());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        openItem.setOnAction(e->{
            FileChooser file = new FileChooser();
            File selected = file.showOpenDialog(primaryStage);
            if(selected!=null){
                try{
                    textArea.load(selected.toPath().toString());
                }catch (IOException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
        saveItem.setOnAction(e->{
            try{
                textArea.save();
            }catch (IOException ex){
                throw new RuntimeException(ex);
            }
        });
        saveAsItem.setOnAction(e->{
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("文本文件",".txt",".md"));
            File selected = chooser.showSaveDialog(primaryStage);
            if(selected != null){
                try{
                    textArea.saveAs(selected.getPath());
                }catch (IOException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
        Scene scene = new Scene(global,500,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("文本编辑器");
        primaryStage.show();
    }
}
