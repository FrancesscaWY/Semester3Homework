package lab1.example.lab1;


import javafx.stage.Stage;

public class Rectangle {

//    Attributes
    protected double width;
    protected double height;
    protected double centerX;
    protected double centerY;
    protected double angle;
    static final int VERTEX0 =0 , VERTEX1=1,VERTEX2=2,VERTEX3=3;
//    Constructor
    public Rectangle(){};
    public Rectangle(double x,double y, double w, double h ){
        centerX=x;
        centerY=y;
        width=w;
        height=h;
    }
//    Method move: change the location of Rectangle by dx and dy
    public void move(double dx,double dy){
        centerX+=dx;
        centerY+=dy;
    }
//    Method moveTo: change the location of Rectangle to x and y
    public void moveTo(double x,double y){
        centerX=x;
        centerY=y;
    }
//    Method rotate:rotate Rectangle by the "angle"
    public void rotate(double a){
        angle=a;
    }
//    Method getCenterX: return centerX of Rectangle
    public double getCenterX(){
        return centerX;
    }
//    Method getCenterY: return centerY of Rectangle
    public double getCenterY(){
        return centerY;
    }
//    Method getAngle: return "angle" of Rectangle
    public double getAngle(){
        return angle;
    }
//    Method getWidth: return width of Rectangle
    public double getWidth(){
        return width;
    }
//    Method getHeight: return height of Rectangle
    public double getHeight(){
        return height;
    }

}