package javalearn.lab2.core;

public class Entity extends Node{
//    Data member
    private String type;
    private String name;
    private String attribute;


//    Constructor with no parameter
    public Entity(){this("","","");}
//    Constructor with one parameter
    public Entity(String n){
        this(" ",n," ");
    }

//    Constructor with full parameters
    public Entity(int id,String t, String n, String a){
        super(0);
        type=t;
        name=n;
        attribute=a;
    }

    public Entity(String type, String name, String attribute) {
        super(0);
        this.type = type;
        this.name = name;
        this.attribute = attribute;
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
