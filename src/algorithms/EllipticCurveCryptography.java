package algorithms;

import utils.Point;

public class EllipticCurveCryptography {
    private double a;
    private double b;

    public EllipticCurveCryptography(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Point pointOperation(Point p, Point q) {
        double x1 = p.getX();
        double y1 = p.getY();

        double x2 = q.getX();
        double y2 = q.getY();

        double m = 0;

        // P == Q => POINT DOUBLING
        if (Double.compare(x1, x2) == 0 && Double.compare(y1, y2) == 0) {
            m = (3 * Math.pow(x1, 2) + a) / (2 * y1);
        }
        // P != Q => POINT ADDITION
        else {
            m = (y2 - y1) / (x2 - x1);
        }

        double x3 = Math.pow(m, 2) - x2 - x1;
        double y3 = m * (x1 - x3) - y1;

        return new Point(x3, y3);
    }

    public Point doubleAndAdd(int n, Point p) {
        Point temp = new Point(p.getX(), p.getY());

        String nBinary = Integer.toBinaryString(n);

        for (int i = 1; i < nBinary.length(); i++) {
            int bit = Integer.parseInt(Character.toString(nBinary.charAt(i)));

            temp = pointOperation(temp, temp);

            if (bit == 1) {
                temp = pointOperation(temp, p);
            }
        }

        return temp;
    }
}
