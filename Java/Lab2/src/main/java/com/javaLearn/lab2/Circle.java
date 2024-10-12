package com.javaLearn.lab2;
import com.javaLearn.tools.Stream;

public class Circle extends Geometry {
//    Initializer : value the type of circle object
    {
        this.type = TYPE.Circle;
    }
    private double radius;

//    Constructor without parameters calls Constructor with parameters more complex.

    public Circle(){};
//    Constructor with parameters
    public Circle(double r){
        setRadius(r);
    }

//    Method getRadius:return radius of Circle object.
    public double getRadius(){
        return radius;
    }

//    Method setRadius:set radius of Circle object.
    public void setRadius(double r){
        this.radius=r;
    }

//    override the method bin from superclass Geometry
    @Override
    public String bin(){
        return "The type of Geometry is " + type +" and it's radius is : " + radius;
    }

//    Override method area:return the area of Circle object
    @Override
    public double area(){ return radius*radius*Math.PI; }

//    Method getType : return type of Circle object
    @Override
    public TYPE getType(){
        return type;
    }

//    Nest class--object member class --depend on the object
    public class Point{
//        class attributes:rd and pType
            private final double rd=0.0;
            private TYPE pType = TYPE.Point;

//            Constructor without parameter
            public Point(){};
//            Method getPArea:return the Area of Point
            public double getPArea(){return 0;}

//            Method getPType:return the type of Point
            public TYPE getPType(){return pType;}
    }

//    Nest class--local class--implement in this class
    static void Count(){
        class Counter{
            int countValue;
            void addC(){countValue++;}
            void getC(){Stream.out("The count after add: "+countValue);}
        }
        Counter count = new Counter();
        count.addC();
        count.getC();
    }
}
