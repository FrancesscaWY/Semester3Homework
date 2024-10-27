package javalearn.lab2.core;

public class Relationship extends Edge{
//    Data member

    private String name;
    private String attribute;

//    Constructor without parameters

//    Constructor with "form" and "to" parameters
    public Relationship(Entity from,Entity to){
        super(from,to);
    }
//    Constructor with full parameters

//    Method Setters
    public void setName(String name){
        this.name=name;
    }

    public void setAttribute(String attribute){
        this.attribute=attribute;
    }

//    Method Getters
    public String getName(){
        return name;
    }

    public String getAttribute(){
        return attribute;
    }
}