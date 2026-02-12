// Wirakorn Thanabat
// 6809617415

import company.employee.Employee.Department;
import company.employee.HourlyEmployee;
import company.employee.PermanentEmployee;
import company.humanResource.Printer;
import company.humanResource.Register;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmployeeTest {
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) {
        // Variable Init
        ArrayList<PermanentEmployee> permanentEmployees = new ArrayList<>();
        ArrayList<HourlyEmployee> hourlyEmployees = new ArrayList<>();

        HourlyEmployee.setWorkingHoursPerSession(8);

        // Registing Data
        Register.registing(permanentEmployees, "Somchai-Hankla", 25, Department.IT, 8, 20_000);
        Register.registing(permanentEmployees, "Somsong-Bunthum", 22, Department.IT, 4, 12_000);
        Register.registing(hourlyEmployees, "Manee-Dumkum", 21, Department.Production, 25, 6);
        Register.registing(hourlyEmployees, "Piti-Rukthai", 25, Department.Production, 30, 5);
        Register.registing(hourlyEmployees, "Veera-Rukdee", 30, Department.Production, 20, 8);

        printMonthlyPaymentSlip(hourlyEmployees, permanentEmployees);
        out.flush();
    }

    // Method
    public static void printMonthlyPaymentSlip(ArrayList<HourlyEmployee> list1, ArrayList<PermanentEmployee> list2) {
        for (PermanentEmployee permanentEmployee : list2) {
            out.printf("%s\n\n\n", new Printer().slipFormat(permanentEmployee));
        }
        for (HourlyEmployee hourlyEmployee : list1) {
            out.printf("%s\n\n\n", new Printer().slipFormat(hourlyEmployee));
        }
    }
}