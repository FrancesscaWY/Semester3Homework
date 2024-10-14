package com.javaLearn.work2;

public class SimpleCalculator {
    public static double calculate(double num1, double num2,String operator){
        double result = 0.0;
        switch(operator){
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "*":
                result = num1*num2;
                break;
            case "/":
                result = num1/num2;
                break;
        }
        return result;
    }

    public static void main(String[] args){
        if(args.length!=3){
            System.out.println("输入错误");
        }else{
            double v1 = Double.parseDouble(args[0]);
            double v2 = Double.parseDouble(args[2]);
            String operator = args[1];
            System.out.println(calculate    (v1,v2,operator));
        }
    }
}
