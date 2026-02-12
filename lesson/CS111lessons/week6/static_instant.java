package week6;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class static_instant {
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) {
        Student maisa = new Student("Kuranne Maisa", 1);
        out.printf("%s, %d\n", maisa.getName(), maisa.getAmount());
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < 10; i ++) {
            students.add(new Student(String.format("%d", i), i));
            out.printf("%s, %d\n", students.get(i).getName(), students.get(i).getAmount());
        }

        out.println(Student.amount);

        out.flush();
    }

    public static class Student {
        private final String name;
        private final int year;
        private static int amount = 0;
        
        public Student(String name, int year) {
            this.name = name;
            this.year = year;
            amount += 1;
        }
        public int getAmount() {
            return amount;
        }
        public String getName() {
            return name;
        }
    }
}
