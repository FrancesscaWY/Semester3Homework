package com.javaLearn.lab2;
import com.javaLearn.tools.Calculator;
import com.javaLearn.tools.Stream;
import com.javaLearn.lab2.Rectangle.SquareShape;
import com.javaLearn.lab2.Circle.Point;

import java.util.ArrayList;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Stream.topic("Override method");
//        test the override method add and Stream.out with different type argument
        Stream.out(Calculator.add(1,1));
        Stream.out(Calculator.add(1.3,1.4));
        Stream.out(Calculator.add(1,1.3));
        Stream.out(Calculator.add(1.2,2));

        Stream.delimiter();

//        test the override method bin to show the different information of objects
        Geometry geo = new Geometry();
        Geometry rect = new Rectangle(1.0,2.2);
        Geometry cir = new Circle(3.0);

//        The implement of method depend on object instead of the type of variable
        Stream.out(geo.bin());
        Stream.out(rect.bin());
        Stream.out(cir.bin());

        Stream.delimiter();

        Stream.topic("up-casting&down-casting");
//        create a superclass Geometry object and refer  subclass Rectangle object.
//        Rectangle object will be up-casting
        Rectangle r = new Rectangle(11,10.2);
        Geometry g = r;
        Stream.out("g is equal to r,true or false:");
        Stream.out(g==r);

//        create a subclass Circle object and refer superclass Geometry object.
//        Geometry object will be down-casting
        Geometry g2 = new Circle(3.12);
        Circle c = (Circle) g2;
        Stream.out("g2 is equal to c,true or false:");
        Stream.out(g2==c);

        Stream.delimiter();

        Stream.topic("Sum of Area and keep float");
//        create a Geometry list to store the object of Geometry and also it's subclass.
        ArrayList<Geometry> gs = new ArrayList<Geometry>();
        gs.add(c);
        gs.add(g);
        gs.add(rect);
        gs.add(cir);
        gs.add(g2);
//        use method sumArea to calculate the sum of all geometry.
        double sum = Calculator.sumArea(gs);
        Stream.out("Total areas is "+ Calculator.keepDD(sum));

        Stream.delimiter();

//        the nested static class of Rectangle needed to import as line 4
        Stream.topic("Nested-Static-Class");
//        create SquareShape object square
        SquareShape square = new SquareShape(2.0);
//        use method getSArea and getType and Stream.out to print the nested static class's information
        Stream.out("The area of square is: " + square.getSArea());
        Stream.out("The type of SquareShape is "+square.getType());

        Stream.delimiter();

        Stream.topic("Nested-Object-Member-Class");
//        create two Point object by two different ways.
        Circle c1 = new Circle(2.0);
        Point p1 = c1.new Point();
        Point p2 = new Circle().new Point();

        Stream.out("p1's type: " + p1.getPType() + " ; p2's type: " + p2.getPType());
        Stream.out("p1's area: " + p1.getPArea() + " ; p2's area: " + p2.getPArea());

        Stream.delimiter();
        Stream.topic("Nested-Local-CLass");
//        use the method count which is implement by local class
        c1.Count();
        r.showAC();
    }
}
