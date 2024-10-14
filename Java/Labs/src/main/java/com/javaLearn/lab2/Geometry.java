package com.javaLearn.lab2;



public class Geometry {

    protected enum TYPE {Circle,Rectangle,GEOM,Square,Point};

    protected TYPE type = TYPE.Circle;

    public Geometry(){};

    public String bin(){
        return "No defined about the Geometry ";
    }

    public TYPE getType(){
        return type;
    }

    public double area(){return 0;}


}
