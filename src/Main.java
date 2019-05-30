import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00");
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("Point A - X: ");
		double pointAX = sc.nextDouble();
		System.out.print("Point A - Y: ");
		double pointAY = sc.nextDouble();
		System.out.print("Point B - X: ");
		double pointBX = sc.nextDouble();
		System.out.print("Point B - Y: ");
		double pointBY = sc.nextDouble();
		System.out.print("Point C - X: ");
		double pointCX = sc.nextDouble();
		System.out.print("Point C - Y: ");
		double pointCY = sc.nextDouble();
		*/

		double pointAX = 1;
		double pointAY = 1;
		double pointBX = 3;
		double pointBY = 5;
		double pointCX = 5;
		double pointCY = 1;

	    MyPoint mp1 = new MyPoint(pointAX, pointAY);
	    MyPoint mp2 = new MyPoint(pointBX, pointBY);
	    MyPoint mp3 = new MyPoint(pointCX, pointCY);

	    double dis1 = mp1.distance(mp2);
	    double dis2 = mp2.distance(mp3);
	    double dis3 = mp3.distance(mp1);

		System.out.println("dis1: " +df.format(dis1));
		System.out.println("dis2: " +df.format(dis2));
		System.out.println("dis3: " +df.format(dis3));

		Triangle2D t1 = new Triangle2D(mp1, mp2, mp3);
		System.out.println("t1 area: " +df.format(t1.getArea()));
		System.out.println("t1 parameter: " +df.format(t1.getPerimeter()));

		Triangle2D t2 = new Triangle2D();
		System.out.println("t2 area: " +df.format(t2.getArea()));
		System.out.println("t2 parameter: " +df.format(t2.getPerimeter()));

		MyPoint refPoint = new MyPoint(3, 3);
		System.out.println("t1 contains refPoint: " +t1.contains(refPoint));

    }
}
