package com.javaLearn.lab2;
import com.javaLearn.tools.Stream;

public class Rectangle extends Geometry{

//    Initializer:value the type of Rectangle object.
    {
        this.type = TYPE.Rectangle;
    }

//    The attributes of Rectangle : width and  length
    private double width;
    private double height;

//    Constructors without with Parameters
    public Rectangle(){}
    public Rectangle(double w,double h){
        this.width=w;
        this.height=h;
    }

//    Method setWidth:set the width of Rectangle Object
    public void setWidth(double w){
        this.width = w;
    }

//    Method setHeight:set the height of Rectangle Object
    public void setHeight(double h){
        this.height=h;
    }

//    Method getHeight:return the height of Rectangle Object

    public double getHeight(){
        return this.height;
    }

//    Method getWidth:return the width of Rectangle Object
    public double getWidth(){
        return this.width;
    }

//    Override method bin from superclass Geometry
    @Override
    public String bin(){
        return "The type of Geometry is: " + type +" and it's width: " + width + "height: " + height;
    }

//    Override method area:return the area of Rectangle
    @Override
    public double area(){ return width*height;}

    static class SquareShape{

        private TYPE sType = TYPE.Square;
        private double width;

//        SquareShape Constructor without parameter
        public SquareShape(){setWidth(1.0);};

//        SquareShape Constructor with parameter
        public SquareShape(double w){setWidth(w);}

//        Method setWidth:set the width of SquareShape
        public void setWidth(double w){
            this.width=w;
        }

//        Method getSArea:return the area of SquareShape object
        public double getSArea(){ return width*width;}

//        Method getType:return type of SquareShape object
        public TYPE getType(){return sType;}

    }

//    Override method getType:return the type of Rectangle object
    @Override
    public TYPE getType(){
        return this.type;
    }

//    Nested class-anonymous class--how to use the anonymous class.
    public void showAC(){
        Object o = new Object(){
            String sayHello = "This sentence is defined in anonymous class.";
            public void show(){Stream.out(sayHello);}
        };
    }

}
