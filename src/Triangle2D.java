import java.awt.geom.Line2D;

public class Triangle2D {
    private MyPoint triangle[];
    private double side1;
    private double side2;
    private double side3;


    public Triangle2D(){
        triangle = new MyPoint[]{new MyPoint(0, 0), new MyPoint(1,1), new MyPoint(2,5)};
        triangle[0] = new MyPoint(0, 0);
        triangle[1] = new MyPoint(1, 1);
        triangle[2] = new MyPoint(2, 5);
        side1 = triangle[0].distance(triangle[1]);
        side2 = triangle[1].distance(triangle[2]);
        side3 = triangle[2].distance(triangle[0]);
    }

    public Triangle2D(MyPoint pointA, MyPoint pointB, MyPoint pointC){
        triangle = new MyPoint[]{pointA, pointB, pointC};
        side1 = triangle[0].distance(triangle[1]);
        side2 = triangle[1].distance(triangle[2]);
        side3 = triangle[2].distance(triangle[0]);
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
        inside = compareOneSide(triangle[0], point);
        if(inside){ inside = compareOneSide(triangle[1], point); }
        if(inside){ inside = compareOneSide(triangle[2], point); }
        return inside;
    }

    public boolean contains(Triangle2D triangle){
        int pointsInside = 0;
        boolean inside = false;
        if( this.contains(triangle.triangle[0]) ){ pointsInside++; }
        if( this.contains(triangle.triangle[1]) ){ pointsInside++; }
        if( this.contains(triangle.triangle[2]) ){ pointsInside++; }
        if( pointsInside == 3 ){ inside = true; }
        return inside;
    }

    public boolean overlaps(Triangle2D t){
        boolean overlap = false;
        int counter = 0;
        int i = 0;
        int j = 0;
        int k = 1;
        int l = 1;
        if(!this.contains(t)){
            for(i = 0; i < t.triangle.length; i++, k++){
                for(j = 0; j < this.triangle.length; j++, l++){
                    if(i == 2) { k = 0; }
                    if(j == 2){ l = 0; }
                    overlap = intersectingLines(t.triangle[i], t.triangle[k],
                            this.triangle[j], this.triangle[l]);
                    if(overlap){ counter++; }
                }
                l = 1;
            }
            if( counter >=2 ){ overlap = true; }
        }
        return overlap;
    }

    private boolean compareOneSide(MyPoint point, MyPoint refPoint){
        int intersectCounter = 0;
        boolean inside = false;
        boolean intersect = Line2D.linesIntersect(  point.getX(), point.getY(),
                                                    refPoint.getX(), refPoint.getY(),
                                                    triangle[0].getX(), triangle[0].getY(),
                                                    triangle[1].getX(), triangle[1].getY());
        if(intersect){ intersectCounter++; }
        intersect = Line2D.linesIntersect(  point.getX(), point.getY(),
                                            refPoint.getX(), refPoint.getY(),
                                            triangle[1].getX(), triangle[1].getY(),
                                            triangle[2].getX(), triangle[2].getY());
        if(intersect){ intersectCounter++; }

        intersect = Line2D.linesIntersect(  point.getX(), point.getY(),
                                            refPoint.getX(), refPoint.getY(),
                                            triangle[2].getX(), triangle[2].getY(),
                                            triangle[0].getX(), triangle[0].getY());

        if(intersect){ intersectCounter++; }
        if(intersectCounter == 2){ inside = true; }
        return inside;
    }

    private boolean intersectingLines(MyPoint line1Start, MyPoint line1End, MyPoint line2Start, MyPoint line2End){
        return Line2D.linesIntersect(   line1Start.getX(), line1Start.getY(),
                                        line1End.getX(), line1End.getY(),
                                        line2Start.getX(), line2Start.getY(),
                                        line2End.getX(), line2End.getY());
    }


}
