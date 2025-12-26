import java.util.Arrays;
import java.util.Objects;
public class EmployeeBook {
    private final Employee[] employees;
    private int count;
    public static final String PROPORTIONAL = "PROPORTIONAL";
    public static final String PROGRESSIVE = "PROGRESSIVE";
    //конструктор
    public EmployeeBook() {
        this.employees = new Employee[10];
        this.count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < 10) {
            employees[count] = employee;
            count++;
        }
    }
    //расчет средней зарплаты
    public double calculateAverageSalary() {
        if (count == 0) {
        return 0;
        }
        int totalSalary = 0;
        for (Employee employee : employees) {
        if (employee == null) {
        break;
        }
        totalSalary += employee.getSalary();
        }
        return (double) totalSalary / count;
    }
    //метод для получения списка всех сотрудников
    public void printAllEmployees() {
         for (Employee employee : employees) {
         if (employee != null) {
         System.out.println(employee);
            }
        }
    }

    //расчет налогов
    public double calculateTax(int salary, String taxType) {
         double taxRate = 0;

         switch (taxType) {
         case PROPORTIONAL:
         taxRate = 0.13;
         break;
         case PROGRESSIVE:
         if (salary <= 150) {
         taxRate = 0.13;
         } else if (salary <= 350) {
         taxRate = 0.17;
         } else {
         taxRate = 0.21;
         }
         break;
         default:
         throw new IllegalArgumentException("Такого типа налога нет");
         }
         return salary * taxRate;
        }
    //вывод информации о налоге
    public void printTaxes(String taxType) {
        for (Employee employee : employees) {
            if (employee != null) {
            double tax = calculateTax(employee.getSalary(), taxType);
            System.out.println("Сотрудник: " + employee.getName() + ", зарплата: " + employee.getSalary() + ", налог: " + tax);
            }
        }
    }
    //индексируем зарплату
    public void indexingSalaries(int department, double percentage) {
        if (percentage < 0) {
        throw new IllegalArgumentException("Процент индексации должен быть положительным");
        }

        for (Employee employee : employees) {
        if (employee == null || employee.getDepartment() != department) {
        continue;
        }

        double newSalary = employee.getSalary() * (1 + percentage / 100);
        employee.setSalary((int) newSalary);
        }
    }
    }

