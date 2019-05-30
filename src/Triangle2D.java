import java.awt.geom.Line2D;

public class Triangle2D {
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;
    private double side1;
    private double side2;
    private double side3;


    public Triangle2D(){
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(1, 1);
        p3 = new MyPoint(2, 5);
        side1 = p1.distance(p2);
        side2 = p2.distance(p3);
        side3 = p3.distance(p1);
    }

    public Triangle2D(MyPoint pointA, MyPoint pointB, MyPoint pointC){
        p1 = pointA;
        p2 = pointB;
        p3 = pointC;
        side1 = p1.distance(p2);
        side2 = p2.distance(p3);
        side3 = p3.distance(p1);
    }

    public double getArea(){
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    public boolean contains(MyPoint point){
        boolean inside;
        inside = compareOneSide(p1, point);
        if(inside){ inside = compareOneSide(p2, point); }
        if(inside){ inside = compareOneSide(p3, point); }
        return inside;
    }

    public boolean contains(Triangle2D triangle){
        int pointsInside = 0;
        boolean inside = false;
        if( this.contains(triangle.p1) ){ pointsInside++; }
        if( this.contains(triangle.p2) ){ pointsInside++; }
        if( this.contains(triangle.p3) ){ pointsInside++; }
        if( pointsInside == 3 ){ inside = true; }
        return inside;
    }

    public boolean overlaps(Triangle2D triangle){

        return true;
    }

    private boolean intersectLines(MyPoint line1Start, MyPoint line1End, MyPoint line2Start, MyPoint line2End){
        double a = line1Start.getY() - line1End.getY();
        double b = -line1Start.getX() + line1End.getX();
        double c = line2Start.getY() - line2End.getY();
        double d = -line2Start.getX() + line2End.getX();
        double e = (a * line1Start.getX()) + (b * line1Start.getY());
        double f = (c * line2Start.getX()) + (d * line2Start.getY());
        double denominator = a * d - b * c;
        double x;
        double y;
        boolean intersect = false;
        if( denominator == 0 ) {
            System.out.println("These lines are parallel and never intersect");
        }
        else {
            x = (e * d - b * f) / denominator;
            y = (a * f - e * c) / denominator;
            //System.out.println("intersect value x: " +x);
            //System.out.println("intersect value y: " +y);
            intersect = true;
        }

        return intersect;
    }

    private boolean compareOneSide(MyPoint point, MyPoint refPoint){
        int intersectCounter = 0;
        boolean inside = false;
        boolean intersect = Line2D.linesIntersect(  point.getX(), point.getY(),
                                                    refPoint.getX(), refPoint.getY(),
                                                    p1.getX(), p1.getY(),
                                                    p2.getX(), p2.getY());
        if(intersect){
            intersectCounter++;
        }
        intersect = Line2D.linesIntersect(  point.getX(), point.getY(),
                                            refPoint.getX(), refPoint.getY(),
                                            p2.getX(), p2.getY(),
                                            p3.getX(), p3.getY());
        if(intersect){
            intersectCounter++;
        }

        intersect = Line2D.linesIntersect(  point.getX(), point.getY(),
                                            refPoint.getX(), refPoint.getY(),
                                            p3.getX(), p3.getY(),
                                            p1.getX(), p1.getY());

        if(intersect){
            intersectCounter++;
        }
        if(intersectCounter == 2){
            inside = true;
        }
        return inside;
    }


}
