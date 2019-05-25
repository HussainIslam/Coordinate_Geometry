public class Triangle2D {
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;

    public Triangle2D(){
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(1, 1);
        p3 = new MyPoint(2, 5);
    }

    public Triangle2D(int pointA, int pointB, int pointC, int pointD, int pointE, int pointF){
        p1 = new MyPoint(pointA, pointB);
        p2 = new MyPoint(pointC, pointD);
        p3 = new MyPoint(pointE, pointF);
    }

    public double getArea(Triangle2D source){

        return 1.1;
    }

    public double getPerimeter(Triangle2D source){

        return 2.2;
    }

    public boolean contains(MyPoint point){

        return true;
    }

    public boolean constain(Triangle2D triangle){

        return true;
    }

    public boolean operlaps(Triangle2D triangle){

        return true;
    }


}
