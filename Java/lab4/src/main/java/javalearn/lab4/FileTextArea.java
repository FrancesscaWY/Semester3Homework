package javalearn.lab4;

import javafx.scene.control.TextArea;

import java.io.IOException;

public class FileTextArea extends TextArea {
    private String path;
    public void load(String filePath) throws IOException {
        this.path = filePath;
        this.setText(FileTool.read(filePath));
    }
    public void save()throws IOException{
        FileTool.save(path,this.getText());
    }
    public void saveAs(String newPath)throws IOException{
        this.path = newPath;
        FileTool.save(newPath,this.getText());
    }

}
