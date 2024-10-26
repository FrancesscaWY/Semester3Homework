package jv.lab3;

public class Rectangle extends Geometry implements Moveable{
    private double length;
    private double width;
    private double x,y;
    public Rectangle(){
        super();
        setLength(0.0);
        setWidth(0.0);
    }
    public Rectangle(double l,double w){
        super();
        setLength(l);
        setWidth(w);
    }
    public Rectangle(double l,double w,double x, double y){
        super();
        setLength(l);
        setWidth(w);
        setX(x);
        setY(y);
    }
    public  void setLength(double l){
        length = l;
    }
    public void setWidth(double w){
        width = w;
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

    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public double area(){
        return length*width;
    }
    public double perimeter(){
        return 2*(length+width);
    }
    @Override
    public void move(double dx,double dy){
        this.x += dx;
        this.y += dy;
    }
    @Override
    public void getLocation(){
        System.out.println("The rectangle's location is: (" +x +","+y +")" );
    }
}
