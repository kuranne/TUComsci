package organize;

public class PermanentEmployee extends Employee {
    private int salary;

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getMonthlyPayment() {
        return salary * ((super.getPerformanceScore() >= 8) ? 1.03 : 1.00) - ((praganSangkom() >= 750) ? 750 : praganSangkom());
    }
    public double praganSangkom() {
        return salary * 0.05;
    }
}
