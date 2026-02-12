import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import organize.*;

public class EmployeeTest {
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final Employer med = new Employer();

    public static void main(String[] args) {
        ArrayList<HourlyEmployee> sessionEmployee = new ArrayList<>();
        ArrayList<PermanentEmployee> monthlyEmployee = new ArrayList<>();

        med.setPermanentEmployee(monthlyEmployee, "Somchai-Hankla", 25, Employee.Department.IT, 8, 20000);
        med.setPermanentEmployee(monthlyEmployee, "Somsong-Bunthum", 22, Employee.Department.IT, 4, 12000);
        
        med.setHourlyEmployee(sessionEmployee, "Manee-Dumkum", 21, Employee.Department.Production, 6, 25);
        med.setHourlyEmployee(sessionEmployee, "Piti-Rukthai", 25, Employee.Department.Production, 5, 30);
        med.setHourlyEmployee(sessionEmployee, "Veera-Rukdee", 30, Employee.Department.Production, 8, 20);

        printMonthlyPaymentSlip(sessionEmployee, monthlyEmployee);
        out.flush();
    }

    public static void printMonthlyPaymentSlip(ArrayList<HourlyEmployee> sessionEmployee, ArrayList<PermanentEmployee> monthlyEmployee) {
        for (PermanentEmployee pm: monthlyEmployee) {
            printer(pm);
        }

        for (HourlyEmployee hr: sessionEmployee) {
            printer(hr);
        }
    }

    public static void printer(PermanentEmployee pm) {
        out.printf("""
************************************************************

            Payment Slip of %s

************************************************************

First Name: %-20s Last Name: %s

Department: %-20s Age: %d

Salary    : %-20s Performance Score: %d 

Monthly Payment: %-15s Deducted for Social Security: %,.2f THB

Diligent Allowance: %,.2f THB\n\n\n
""", 
        pm.getFullName().toUpperCase(), 
        pm.getName(), pm.getLastName(), 
        parseDepartment(pm), 
        pm.getAge(), 
        String.format("%,.2f THB", (double)pm.getSalary()), 
        pm.getPerformanceScore(), 
        String.format("%,.2f THB", pm.getMonthlyPayment()), 
        pm.praganSangkom(), 
        (pm.praganSangkom() >= 750) ? 750 : pm.praganSangkom());
    }

    public static void printer(HourlyEmployee hr) {
        out.printf("""
************************************************************

            Payment Slip of %s

************************************************************

First Name: %-20s Last Name: %s

Department: %-20s Age: %d

Performance Score: %-13d Hourly Wage Rate: %,.2f THB

Working Session of Month: %-6d Working Hour Per Session: %,d

Monthly Payment: %,.2f THB\n\n\n
""",    hr.getFullName().toUpperCase(), 
        hr.getName(), 
        hr.getLastName(), 
        parseDepartment(hr), 
        hr.getAge(), 
        hr.getPerformanceScore(), 
        (double) hr.getHourlyWageRate(), 
        hr.getWorkingSessionPerMonth(), 
        hr.getWorkingHoursPerSession(), 
        hr.getMonthlyPayment());
    }

    private static String parseDepartment(HourlyEmployee hr) {
        switch (hr.getDepartment()) {
            case Employee.Department.IT:
                return "IT";
            case Employee.Department.Production:
                return "Production";
            default:
                return "None";
        }
    }

    private static String parseDepartment(PermanentEmployee pm) {
        switch (pm.getDepartment()) {
            case Employee.Department.IT:
                return "IT";
            case Employee.Department.Production:
                return "Production";
            default:
                return "None";
        }
    }

    private static class Employer {
        public void setPermanentEmployee(ArrayList<PermanentEmployee> employeeType, String name, int age, Employee.Department department, int performanceScore, int salary) {
            PermanentEmployee pm = new PermanentEmployee();
            pm.setFullName(name);
            pm.setAge(age);
            pm.setDepartment(department);
            pm.setPerformanceScore(performanceScore);
            pm.setSalary(salary);
            employeeType.add(pm);
        }
        
        public void setHourlyEmployee(ArrayList<HourlyEmployee> employeeType, String name, int age, Employee.Department department, int performanceScore, int sessionPerMonth) {
            HourlyEmployee hr = new HourlyEmployee();
            hr.setFullName(name);
            hr.setAge(age);
            hr.setDepartment(department);
            hr.setPerformanceScore(performanceScore);
            hr.setWorkingHoursPerSession(8);
            hr.setWorkingSessionPerMonth(sessionPerMonth);
            employeeType.add(hr);
        }
    }
}
