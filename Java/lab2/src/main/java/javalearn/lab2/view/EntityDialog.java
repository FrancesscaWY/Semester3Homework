package javalearn.lab2.view;

import javalearn.lab2.core.Entity;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EntityDialog extends Dialog<Entity>{
    private Entity entity;

    public EntityDialog(Entity e){
        entity = e;
        this.setTitle("You can change the contents then click \"OK\".");
        ButtonType okButtonType = new ButtonType("OK",ButtonType.OK.getButtonData());
        getDialogPane().getButtonTypes().addAll(okButtonType,ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField typeField = new TextField(entity.getType());
        TextField nameField = new TextField(entity.getName());
        TextField attrField = new TextField(entity.getAttribute());

        grid.add(new Label("Type: "),0,0);
        grid.add(typeField,1,0);
        grid.add(new Label("Name:"),0,1);
        grid.add(nameField,1,1);
        grid.add(new Label("Attribute:"),0,2);
        grid.add(attrField,1,2);

        getDialogPane().setContent(grid);

        setResultConverter(dialogButton->{
            if(dialogButton == okButtonType){
                entity.setType(typeField.getText());
                entity.setName(nameField.getText());
                entity.setAttribute(attrField.getText());
                return entity;
            }
            return null;
        });
    }
}
