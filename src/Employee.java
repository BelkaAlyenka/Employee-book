import java.util.Objects;

public class Employee {
    private final String fullName;
    private int department;
    private int salary;
    private static int idCounter = 1;
    private final int id;

    //конструктор
    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = idCounter++;
    }

    public String getName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public String toString() {
        return "Сотрудник №" + id + ", ФИО:" + fullName + ", отдел:" + department + ", зарплата:" + salary;
    }

    public void printShortInfo() {
        System.out.println("Сотрудник: " + fullName + ", зарплата: " + salary);
    }
}
