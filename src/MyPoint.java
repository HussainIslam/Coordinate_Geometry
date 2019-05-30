public class MyPoint {
    private double x;
    private double y;

    public MyPoint(){
        x = 0;
        y = 0;
    }

    public MyPoint(double pointA, double pointB){
        x = pointA;
        y = pointB;
    }

    public double distance(MyPoint destination){
        return  Math.sqrt(Math.pow(this.x - destination.x, 2) + Math.pow(this.y - destination.y, 2));
    }

    public double distance(double pointA, double pointB){
        return Math.sqrt(Math.pow(this.x - pointA, 2) + Math.pow(this.y - pointB, 2));
    }

    public double getX(){ return x; }

    public void setX(double x){ this.x = x; }

    public double getY(){ return y; }

    public void setY(double y) { this.y = y; }

}
