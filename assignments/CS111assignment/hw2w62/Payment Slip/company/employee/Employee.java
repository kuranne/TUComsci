// Wirakorn Thanabat
// 6809617415

package company.employee;

public class Employee {
    // 
    public enum Department {
        IT,
        Production,
        Unknow
    }

    // Variable field
    private String fullName;
    private int age, performanceScore;
    private Department department;
    public static int employerNumber = 0;

    // Constructor
    public Employee() {
        ++employerNumber;
    }

    // Getter Method
    public String getFullName() {
        return fullName;
    }
    public String getDepartment() {
        return departmentParserToString(department);
    }
    public int getAge() {
        return age;
    }
    public int getPerformanceScore() {
        return performanceScore;
    }

    // Special Getter Method
    public String getName() {
        return fullName.subSequence(0, fullName.indexOf('-')).toString();
    }
    public String getLastName() {
        return fullName.subSequence(fullName.indexOf('-') + 1, fullName.length()).toString();
    }


    // Setter Method
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    // Private
    private String departmentParserToString(Department department) {
        return switch (department) {
            case IT -> "IT";
            case Production -> "Production";
            default -> "Unknow";
        };
    }
}