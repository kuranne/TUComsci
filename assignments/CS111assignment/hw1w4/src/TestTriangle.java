// Wirakorn Thanabat
// 6809617415

public class TestTriangle {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.setA(3);
        t1.setB(4);
        t1.setC(5);
        double a = t1.getA();
        double b = t1.getB();
        double c = t1.getC();
        if (t1.isRightTriangle(a,b,c)) {
            System.out.printf("Area of Triangle with sides (%.2f, %.2f, %.2f) = %.2f%n", a, b, c, t1.getArea());
        } else {
            System.out.printf("Triangle with sides (%.2f, %.2f, %.2f) is not a right triangle.", a, b, c);
        }
    }

    public static class Triangle {
        private double a_side;
        private double b_side;
        private double c_side;
        
        public Triangle(){};

        private boolean validate(double length) {
            return length >= 0;
        }

        public void setA(double length) {
            a_side = (validate(length)) ? length : -1;
        }
        public void setB(double length) {
            b_side = (validate(length)) ? length : -1;
        }
        public void setC(double length) {
            c_side = (validate(length)) ? length : -1;
        }

        public double getA() {
            return a_side;
        }
        public double getB() {
            return b_side;
        }
        public double getC() {
            return c_side;
        }

        public double getArea() {
            return a_side * b_side / 2;
        }
        public boolean isRightTriangle(double a, double b, double c) {
            return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) == c;
        }

    }
}
