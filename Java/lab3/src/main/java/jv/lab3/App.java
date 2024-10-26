package jv.lab3;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
       Geometry[] geoArray = {new Circle(1),new Rectangle(1,2)};
       System.out.println("The sum of the geometries : "+areaSum(geoArray));
       Moveable[] geoArray2 = {new Circle(1,0,0), new Rectangle(1,2,0,0)};
       getLocation(geoArray2);
       move(geoArray2,3.5,4);
       getLocation(geoArray2);
    }
    public static double areaSum(Geometry[] geos){
        double sum=0.0;
        for(Geometry g: geos){
            sum += g.area();
        }
        return sum;
    }
    public static void move(Moveable[] a, double dx,double dy){
        for(Moveable g:a){
            g.move(dx,dy);
        }
    }
    public static void getLocation(Moveable[] a){
        for(Moveable g:a){
            g.getLocation();
        }
    }
}
