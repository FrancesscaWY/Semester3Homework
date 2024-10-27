package javalearn.lab2.view;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EditorDialog<T> extends Dialog<T> {
    private Editor<T> editor;

    public EditorDialog(Editor<T> e){
        this.editor = e;
        this.setTitle("编辑信息");
        ButtonType okButtonType = new ButtonType("确认",ButtonType.OK.getButtonData());
        getDialogPane().getButtonTypes().addAll(okButtonType,ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        String[] values = editor.values();
        TextField[] textFields = new TextField[values.length];
        for(int i=0;i<values.length;i++){
            textFields[i] = new TextField(values[i]);
        }

        String[] fields = editor.fieldNames();
        for(int i=0;i<fields.length;i++){
            grid.add(new Label(fields[i]),0,i);
            grid.add(textFields[i],1,i);
        }

        getDialogPane().setContent(grid);

        setResultConverter(dialogButton->{
            if(dialogButton == okButtonType){
                String[] newValues = new String[values.length];
                for(int i=0;i<values.length;i++){
                    newValues[i] = textFields[i].getText();
                }
                editor.update(newValues);
                return editor.getTarget();
            }
            return null;
        });
    }
}
