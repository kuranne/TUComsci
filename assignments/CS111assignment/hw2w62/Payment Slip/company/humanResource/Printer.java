// Wirakorn Thanabat
// 6809617415

package company.humanResource;

import company.employee.HourlyEmployee;
import company.employee.PermanentEmployee;

public class Printer {
    public String slipFormat(PermanentEmployee permanentEmployee) {
        double socialSecurityRemittance = permanentEmployee.socialSecurityRemittance();
        double monthlyPayment = permanentEmployee.getMonthlyPayment();
        double salary = permanentEmployee.getSalary();
        return String.format(
"""
*****************************************************************************

                    Payment Slip of %s

*****************************************************************************

%-34s %s

%-34s %s

%-34s %s

%-34s %s

%-34s
""",    
        permanentEmployee.getFullName().toUpperCase(),
        String.format("First Name: %s", permanentEmployee.getName()),
        String.format("Last Name: %s", permanentEmployee.getLastName()),
        String.format("Department: %s", permanentEmployee.getDepartment()),
        String.format("Age: %,d", permanentEmployee.getAge()),
        String.format("Salary    : %,.2f THB", salary),
        String.format("Performance Score: %,d", permanentEmployee.getPerformanceScore()),
        String.format("Monthly Payment: %,.2f THB", monthlyPayment),
        String.format("Deducted of Social Security: %,.2f THB", socialSecurityRemittance),
        String.format("Diligent Allowance: %,.2f THB", monthlyPayment + socialSecurityRemittance - salary)
        );
    }

        //

    public String slipFormat(HourlyEmployee hourlyEmployee) {
        return String.format(
"""
*****************************************************************************

                    Payment Slip of %s

*****************************************************************************

%-34s %s

%-34s %s

%-34s %s

%-34s %s

%-34s
""",    
        hourlyEmployee.getFullName().toUpperCase(),
        String.format("First Name: %s", hourlyEmployee.getName()),
        String.format("Last Name: %s", hourlyEmployee.getLastName()),
        String.format("Department: %s", hourlyEmployee.getDepartment()),
        String.format("Age: %,d", hourlyEmployee.getAge()),
        String.format("Performance Score: %,d", hourlyEmployee.getPerformanceScore()),
        String.format("Hourly Wage Rate: %,.2f THB", hourlyEmployee.getHourlyWageRate()),
        String.format("Working Sessions of Month: %,d ", hourlyEmployee.getWorkingSessionsPerMonth()),
        String.format("Working Hours Per Session: %,d", hourlyEmployee.getWorkingHoursPerSession()),
        String.format("Monthly Payment: %,.2f THB", hourlyEmployee.getMonthlyPayment())
        );
    }
}
