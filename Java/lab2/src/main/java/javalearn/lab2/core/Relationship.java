package javalearn.lab2.core;

public class Relationship extends Edge{
//    Data member
    private Entity from;
    private Entity to;
    private String name;
    private String attribute;

//    Constructor without parameters
    public Relationship(){
        this(" "," ",null,null);
    }

//    Constructor with "form" and "to" parameters
    public Relationship(Entity from,Entity to){
        this.from=from;
        this.to=to;
    }
//    Constructor with full parameters
    public Relationship(String name,String attribute,Node from,Node to){
        this.name=name;
        this.attribute=attribute;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAttribute(String attribute){
        this.attribute=attribute;
    }

    public String getName(){
        return name;
    }

    public String getAttribute(){
        return attribute;
    }
}