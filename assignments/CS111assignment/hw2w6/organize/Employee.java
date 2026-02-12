package organize;

public class Employee {
    public enum Department {
        IT,
        Production
    }

    private String fullName;
    private int age;
    private Department department;
    private int performanceScore;

    public String getFullName() {
        return fullName;
    }
    public String getName() {
        return fullName.subSequence(0, fullName.indexOf('-')).toString();
    }
    public String getLastName() {
        return fullName.subSequence(fullName.indexOf('-') + 1, fullName.length()).toString();
    }
    public int getAge() {
        return age;
    }
    public Department getDepartment() {
        return department;
    }
    public int getPerformanceScore() {
        return performanceScore;
    }

    //
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setDepartment (Department department) {
        this.department = department;
    }
    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }
}
