package javalearn.lab2.view;

import java.util.Optional;
import javafx.scene.layout.Pane;
import  javalearn.lab2.core.KnowledgeGraph;
import javalearn.lab2.core.Entity;
import javalearn.lab2.core.Relationship;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class KnowledgeGraphView extends Pane{
        private KnowledgeGraph graph;
        private static EntityLabel selectedStart,selectedEnd;

        public KnowledgeGraphView(){
                graph = new KnowledgeGraph();
                actionInitialize();
        }

        public void actionInitialize(){
                this.setOnMousePressed(event->{
                        if(event.getButton() == MouseButton.PRIMARY){
                                clear();
                        }
                        event.consume();
                });
                this.setOnMouseClicked(event->this.requestFocus());
                this.setOnKeyPressed(e->{
                        System.out.println(e.getCode());
                        switch(e.getCode()){
                                case SPACE:{
                                        createRelationship().ifPresent(line->{
                                                this.getChildren().add(0,line);
                                                clear();
                                        });
                                }
                                break;
                                default:break;
                        }
                        e.consume();
                });
        }

//        create an entity by the "text"
        public void add(String text){
                graph.addEntity(" ",text," ").ifPresent(e->{
                   getChildren().add(new EntityLabel(e));
                });
        }

        public void select(EntityLabel e){
                if(selectedStart == null){
                        selectedStart = e;
                        selectedStart.selectedStyle();
                }else if( selectedStart != null && selectedEnd == null){
                        selectedEnd = e;
                        selectedEnd.selectedStyle();
                }else{
                        selectedStart.nonSelectedStyle();
                        selectedStart=selectedEnd;
                        selectedEnd = e;
                        selectedEnd.selectedStyle();
                }
        }

//        clear selected
        public void clear(){
                if(selectedStart != null){
                        selectedStart.nonSelectedStyle();
                        selectedStart = null;
                }
                if(selectedEnd != null){
                        selectedEnd.nonSelectedStyle();
                        selectedEnd = null;
                }
        }

//        create relationship
        public Optional<RelationLine> createRelationship(){
                if(selectedStart != null && selectedEnd != null){
                        Entity from = selectedStart.getEntity();
                        Entity to = selectedEnd.getEntity();
                        Optional<RelationLine> line = Optional.empty();
                        Optional<Relationship> relation = graph.addRelation(from,to);
                        if(relation.isPresent()){
                                line = Optional.ofNullable(new RelationLine(selectedStart,selectedEnd,relation.get()));
                        }
                        return line;
                }else{
                        return Optional.empty();
                }
        }

        public class EntityLabel extends Label{
                private Entity entity;
                private double offsetX,offsetY;
                public EntityLabel(Entity entity){
                        setEntity(entity);
                        this.setText(entity.getName());
                        nonSelectedStyle();
//                      Move event
                        this.setOnMousePressed(event->{
                                if(event.getButton()==MouseButton.PRIMARY){
                                        offsetX = event.getSceneX() - this.getLayoutX();
                                        offsetY = event.getSceneY() - this.getLayoutY();
                                }
                        });
                        this.setOnMouseDragged(event->{
                                if(event.getButton()==MouseButton.PRIMARY){
                                        this.setLayoutX(event.getSceneX()-offsetX);
                                        this.setLayoutY(event.getSceneY()-offsetY);
                                };
                        });

//                        Click twice change label color
                        this.setOnMouseClicked(event->{
                                if(event.getClickCount()==2){
                                        new EntityDialog(entity).showAndWait().ifPresent(update->{
                                                this.updateText();
                                        });
                                }else if(event.getButton()==MouseButton.SECONDARY){
                                        select(this);
                                }
                        });

                }
                public void setEntity(Entity entity){
                        this.entity=entity;
                }
                public void nonSelectedStyle(){
                        this.setStyle("-fx-background-color: #cee5ec;"
                        +"-fx-padding:10;"
                        +"-fx-background-radius:15;"
                        +"-fx-border-color:#8383f5;"
                        +"-fx-border-radius:15;"
                        +"-fx-border-width:2;");
                }

                public void selectedStyle(){
                        this.setStyle("-fx-background-color:#c8e6ef;"
                        +"-fx-padding:0;"
                        +"-fx-border-color:#9e9e7a;"
                        +"-fx-border-radius:15;"
                        +"-fx-border-width:2;");
                }

                public void updateText(){
                        this.setText(entity.getName());
                }

                public Entity getEntity(){
                        return entity;
                }
        }

        public class RelationLine extends Group{
                private Relationship relation;
                private Line line = new Line();
                private Text label;
                public RelationLine(EntityLabel start,EntityLabel end,Relationship rel){
                        this.relation=rel;
                        line.setStrokeWidth(2.0);
                        line.setFill(Color.RED);
                        line.startXProperty().bind(start.layoutXProperty().add(start.widthProperty().divide(2)));
                        line.startYProperty().bind(start.layoutYProperty().add(start.heightProperty().divide(2)));
                        line.endXProperty().bind(end.layoutXProperty().add(end.widthProperty().divide(2)));
                        line.endYProperty().bind(end.layoutYProperty().add(end.heightProperty().divide(2)));
                        label.xProperty().bind(line.startXProperty().add(line.endXProperty()).divide(2));
                        label.yProperty().bind(line.startYProperty().add(line.endYProperty()).divide(2).subtract(5));

                        this.getChildren().addAll(line,label);
                        this.setOnMouseClicked(event->{
                                if(event.getClickCount()==2){
                                        new RelationshipDialog(relation).showAndWait().ifPresent(update->{
                                                this.updateText();
                                        });
                                }
                        });
                }
                public void updateText(){
                        label.setText(relation.getName());
                }
        }

}