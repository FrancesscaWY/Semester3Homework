package com.javaLearn.tools;

public class Stream {

//    method text can be used in other package because "public"
//    method text:print string type data;
    public static void out(String str){
        System.out.println(str);
    }
    public static void out(int x){
        System.out.println(x);
    }
    public static void out(double x){
        System.out.println(x);
    }
    public static void out(boolean x){
        System.out.println(x);
    }

    public static void blank(String word){
        System.out.print(word+" ");
    }

    public static void blank(double d){
        System.out.print(d+" ");
    }

    public static void topic(String str){
        System.out.println("=========================="+str.toUpperCase()+"=============================");
    }
    public static void delimiter(){
        System.out.println("============================================================================");
    }


}
