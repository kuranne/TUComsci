// Wirakorn Thanabat
// 6809617415

package company.employee;

public class PermanentEmployee extends Employee {
    // Variable
    private double salary;

    // Method
    public double getMonthlyPayment() {
        return calcBonus(getPerformanceScore()) * salary - socialSecurityRemittance();
    }
    public double socialSecurityRemittance() { // PraganSungkom
        double remittance = salary * 0.05;
        return (remittance >= 750) ? 750.0 : remittance;
    }

    // Getter Method
    public double getSalary() {
        return salary;
    }

    //Setter Method  
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Private Method
    private double calcBonus(int performanceScore) {
        return (performanceScore >= 8) ? 1.03 : 1.00;
    }
}
