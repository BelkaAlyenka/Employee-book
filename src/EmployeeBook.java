public class EmployeeBook {
    private final Employee[] employees;
    private int count;
    public static final String PROPORTIONAL = "PROPORTIONAL";
    public static final String PROGRESSIVE = "PROGRESSIVE";
    //конструктор
    public EmployeeBook() {
        this.employees = new Employee[11];
        this.count = 0;
    }
    //добавляем сотрудников
    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                count++;
                return true;
            }
        }
        return false;
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
         double taxRate;
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
    public void printTaxes() {
        for (Employee employee : employees) {
        if (employee != null) {
        String taxType = determineTax(employee.getSalary());
        double tax = calculateTax(employee.getSalary(), taxType);
        System.out.println("Сотрудник: " + employee.getName() + ", зарплата: " + employee.getSalary() + ", налог: " + tax);
        }
        }
    }
    //определяем тип налога при вызове метода
    private String determineTax(int salary) {
        if (salary < 100000) {
            return PROPORTIONAL;
        } else {
            return PROGRESSIVE;
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
    //поиск сотрудника с наибольшей зарплатой
    public void findingHighestSalary (int department, int minimalSalary) {
        for (int i = 0; i < count; i++) {
        Employee employee = employees[i];
        if (employee == null) {
        continue;
        }
        if (employee.getDepartment() == department && employee.getSalary() > minimalSalary) {
        employee.printShortInfo();
        break;
        }
    }
}
    //поиск сотрудников с меньшей зарплатой
    public void findingLowerSalaries (int wage, int employeeNumber) {
        int i = 0;
        int foundEmployeeNumber = 0;
        while (i < count) {
        Employee employee = employees[i];
        if (employee != null && employee.getSalary() < wage) {
        System.out.println(employee);
        foundEmployeeNumber++;
        if (foundEmployeeNumber == employeeNumber) {
        break;
        }
        }
        i++;
        }
}
    //сравнение сотрудников
    public boolean employeeComparison (Employee employee) {
        if (employee == null) return false;
        for (Employee emp : employees) {
        if (emp != null && emp.getSalary() == employee.getSalary() && emp.getName().equals(employee.getName())) {
        return true;
        }
        }
        return false;
        }
    //получение сотрудника по id
    public Employee findById (int id) {
        for (int i = 0; i < count; i++) {
        Employee e = employees[i];
        if (e != null && e.getId() == id) {
            return e;
        }
}
        return null;
}
}




