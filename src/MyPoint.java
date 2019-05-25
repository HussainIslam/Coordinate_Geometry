public class MyPoint {
    private int x;
    private int y;

    public MyPoint(){
        x = 0;
        y = 0;
    }

    public MyPoint(int pointA, int pointB){
        x = pointA;
        y = pointB;
    }

    public double distance(MyPoint destination){
        return  Math.sqrt(Math.pow(this.x - destination.x,2) + Math.pow(this.x - destination.x, 2));
    }

    public double distance(int pointA, int pointB){

        return 1.2;
    }

    public int getX(){ return x; }

    public void setX(int x){ this.x = x; }

    public int getY(){ return y; }

    public void setY(int y) { this.y = y; }

}
