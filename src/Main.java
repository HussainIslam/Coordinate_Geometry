import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00");
		double pointAX = 2.5;
		double pointAY = 2;
		double pointBX = 4.2;
		double pointBY = 3;
		double pointCX = 5;
		double pointCY = 3.5;

		Triangle2D t1 = new Triangle2D(	new MyPoint(pointAX, pointAY),
										new MyPoint(pointBX, pointBY),
										new MyPoint(pointCX, pointCY));
		System.out.println("t1 area: " +df.format(t1.getArea()));
		System.out.println("t1 parameter: " +df.format(t1.getPerimeter()));
		System.out.println("t1.contains(3, 3): " +t1.contains(new MyPoint(3, 3)));
		System.out.println("t1.contains(2,9)(4,1)(1,3.4): "
				+ t1.contains(
							new Triangle2D(
										new MyPoint(2.9,2),
										new MyPoint(4,1),
										new MyPoint(1,3.4))));

		System.out.println("t1.overlaps(2,5.5)(4,-3)(2.6.5): "
				+t1.overlaps(
							new Triangle2D(
										new MyPoint(2,5.5),
										new MyPoint(4,-3),
										new MyPoint(2,6.5))));
    }
}
