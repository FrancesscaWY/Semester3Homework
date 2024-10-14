package com.javaLearn.tools;
import com.javaLearn.lab2.Geometry;

import java.util.ArrayList;
import java.util.Objects;


public class Calculator {
    public Calculator(){};

    public static int add(int x,int y){Stream.out("Double int addition.");return x+y;}
    public static double add(double x,double y){Stream.out("Double double addition.");return x+y;}
    public static double add(int x,double y){Stream.out("int and double addition.");return x+y;}
    public static double add(double x,int y){Stream.out("double and int addition.");return x+y;}

    public static double sumArea(ArrayList<Geometry> lists){
        double sum=0;
        for(Geometry o:lists){
            sum += o.area();
        }
        return sum;
    }

    public static String keepDD(double d){
        return String.format("%1f",d);
    }

}
