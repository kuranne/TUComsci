// Wirakorn Thanabat
// 6809617415

package company.employee;

public class HourlyEmployee extends Employee {
    // Constant
    private final double MIN_HOURLY_WAGE_RATE = 50.0; // THB/hrs.

    // Variable
    private int workingSessionsPerMonth;
    private static int workingHoursPerSession = 0;

    // Method
    public double getMonthlyPayment() {
        return calculatePersonalHourlyWage() * workingSessionsPerMonth;
    }
    public double calculatePersonalHourlyWage() {
        return workingHoursPerSession * MIN_HOURLY_WAGE_RATE * calcBonus(getPerformanceScore());
    }

    // Getter Method
    public double getHourlyWageRate() {
        return MIN_HOURLY_WAGE_RATE;
    }
    public int getWorkingSessionsPerMonth() {
        return workingSessionsPerMonth;
    }
    public int getWorkingHoursPerSession() {
        return workingHoursPerSession;
    }

    // Setter Method
    public static void setWorkingHoursPerSession(int workingHoursPerSession) {
        HourlyEmployee.workingHoursPerSession = workingHoursPerSession;
    }
    public void setWorkingSessionsPerMonth(int workingSessionsPerMonth) {
        this.workingSessionsPerMonth = workingSessionsPerMonth;
    }

    // Private Method
    private double calcBonus(int performanceScore) {
        return (performanceScore <= 5) ? 1.0 : switch (performanceScore) {
            case 10 -> 1.5;
            default -> (performanceScore % 5) * 0.1 + 1.0;
        };
    }
}
