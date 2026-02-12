public class TestTriangle {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.setA(3);
        t1.setB(4);
        t1.setC(5);
        double a = t1.getA();
        double b = t1.getB();
        double c = t1.getC();

        if (t1.isRightTriangle(a, b, c)) {
            System.out.printf("Area of Triangle with sides (%.2f, %.2f, %.2f) = %.2f%n", a, b, c, t1.getArea());
        } else {
            System.out.printf("Triangle with sides (%.2f, %.2f, %.2f) is not a right triangle%n", a, b, c, t1.getArea());
        }
    }

    private static class Triangle {
        private double a;
        private double b;
        private double c;

        // Validate
        public boolean isRightTriangle(double a, double b, double c) {
            return (c == Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
        }
        private boolean isMoreThanZero(int n) {
            return n > 0;
        }

        // Set variables
        public void setA(int a) {
            if (isMoreThanZero(a)) {
                this.a = (double)a;
            }
        }
        public void setB(int b) {
            if (isMoreThanZero(b)) {
                this.b = (double)b;
            }
        }
        public void setC(int c) {
            if (isMoreThanZero(c)) {
                this.c = (double)c;
            }
        }

        // Get varieables
        public double getA() {
            return a;
        }
        public double getB() {
            return b;
        }
        public double getC() {
            return c;
        }

        // Operator
        public double getArea() {
            double s = a + b + c;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
    }
}