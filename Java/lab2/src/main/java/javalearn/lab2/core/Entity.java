package javalearn.lab2.core;

public class Entity extends Node{
//    Data member
    private String type;
    private String name;
    private String attribute;

//    Constructor with one parameter
    public Entity(String n){
        this(" ",n," ");
    }

//    Constructor with full parameters
    public Entity(String t, String n, String a){
        type=t;
        name=n;
        attribute=a;
    }

//    Method set type,name,attribute
    public void setType(String t){type=t;}
    public void setName(String n){name=n;}
    public void setAttribute(String a){attribute=a;}

//    Method get type,name,attribute
    public String getType(){return type;}
    public String getName(){return name;}
    public String getAttribute(){return attribute;}
}
