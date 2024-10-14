package javalearn.lab2.view;
import javalearn.lab2.core.Relationship;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RelationshipDialog extends Dialog<Relationship>{
        private Relationship relation;
        public RelationshipDialog(Relationship rel){
            relation=rel;
            this.setTitle("");
            ButtonType okButtonType = new ButtonType("OK",ButtonType.OK.getButtonData());
            getDialogPane().getButtonTypes().addAll(okButtonType,ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            TextField nameField = new TextField(relation.getName());
            TextField attrField = new TextField(relation.getAttribute());

            grid.add(new Label(" "),0,1);
            grid.add(nameField,1,1);
            grid.add(new Label(" "),0,2);
            grid.add(attrField,1,2);

            getDialogPane().setContent(grid);

            setResultConverter(dialogButton->{
                if(dialogButton == okButtonType){
                    relation.setName(nameField.getText());
                    relation.setAttribute(attrField.getText());
                    return relation;
                }
                return null;
            });
        }
}
