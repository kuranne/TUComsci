// Wirakorn Thanabat
// 6809617415

package company.humanResource;

import company.employee.Employee;
import company.employee.HourlyEmployee;
import company.employee.PermanentEmployee;
import java.util.ArrayList;

public class Register {
    // For Perm.
    public static void registing(
        ArrayList<PermanentEmployee> permanentEmployees,
        String fullName,
        int age,
        Employee.Department department,
        int performanceScore,
        double salary
    ) {
        PermanentEmployee newEmployer = new PermanentEmployee();
        newEmployer.setFullName(fullName);
        newEmployer.setAge(age);
        newEmployer.setDepartment(department);
        newEmployer.setPerformanceScore(performanceScore);
        newEmployer.setSalary(salary);
        permanentEmployees.add(newEmployer);
    }

    // For Hourly
    public static void registing(
        ArrayList<HourlyEmployee> hourlyEmployees,
        String fullName,
        int age,
        Employee.Department department,
        int workingSessionsPerMonth,
        int performanceScore
    ) {
        HourlyEmployee newEmployer = new HourlyEmployee();
        newEmployer.setFullName(fullName);
        newEmployer.setAge(age);
        newEmployer.setDepartment(department);
        newEmployer.setWorkingSessionsPerMonth(workingSessionsPerMonth);
        newEmployer.setPerformanceScore(performanceScore);
        hourlyEmployees.add(newEmployer);
    }
}
