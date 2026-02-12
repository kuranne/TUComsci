package organize;

public class HourlyEmployee extends Employee {
    private final int MIN_HOURLY_WAGE_RATE = 50; // bath/hrs.
    private int workingSessionPerMonth;
    private int workingHoursPerSession;

    public int getWorkingHoursPerSession() {
        return workingHoursPerSession;
    }
    public int getWorkingSessionPerMonth() {
        return workingSessionPerMonth;
    }
    public int getHourlyWageRate() {
        return MIN_HOURLY_WAGE_RATE;
    }
    public void setWorkingHoursPerSession(int workingHoursPerSession) {
        this.workingHoursPerSession = workingHoursPerSession;
    }
    public void setWorkingSessionPerMonth(int workingSessionPerMonth) {
        this.workingSessionPerMonth = workingSessionPerMonth;
    }

    public double getMonthlyPayment() {
        return calculatePersonalHourlyWage() * workingHoursPerSession * workingSessionPerMonth * MIN_HOURLY_WAGE_RATE;
    }

    public double calculatePersonalHourlyWage() {
        int perf = super.getPerformanceScore();
        if (perf > 5) {
            return 1.0 + ((perf == 10) ? 0.5 : (perf % 5) * 0.1);
        } else {
            return 1.0;
        }
    }
}
