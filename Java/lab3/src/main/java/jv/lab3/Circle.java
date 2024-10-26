package jv.lab3;

public class Circle extends Geometry implements Moveable{
    private double radius;
    private double x,y;
    public Circle(){
        super(); //call superClass constructor explicitly,make sure superClass object is initialized
        setR(0.0);
    }
    public Circle(double r){
        super();
        setR(r);
    }
    public Circle(double radius,double x,double y){
        super();
        setR(radius);
        setX(x);
        setY(y);
    }
    public void setR(double radius){
        this.radius=radius;
    }
    public double getR(){
        return radius;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public double getX(){
        return  x;
    }
    public double getY(){
        return y;
    }
    public double area(){
        return Math.PI*radius*radius;
    }
    public double perimeter(){
        return 2*Math.PI*radius;
    }
    @Override
        public void move(double dx,double dy){
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void getLocation(){
        System.out.println("The circle's location is: (" +x +","+y +")" );
    }
}
