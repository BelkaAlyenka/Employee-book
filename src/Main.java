public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        Employee alina = new Employee("Чернякова Алина Олеговна", 5, 50);
        Employee sergey = new Employee("Иванов Сергей Иванович", 3, 60);
        Employee galina = new Employee("Сусленкова Галина Сергеевна", 2, 110);
        Employee vera = new Employee("Люблова Вера Николаевна", 4, 90);
        Employee oleg = new Employee("Волков Олег Николаевич", 5, 330);
        Employee nikita = new Employee("Бобылев Никита Георгиевич", 4, 130);
        Employee marina = new Employee("Мартынова Марина Максимовна", 1, 200);
        Employee ivan = new Employee("Иванов Иван Иванович", 1, 280);
        Employee ura = new Employee("Козлов Юрий Олегович", 3, 99);
        Employee ekaterina = new Employee("Лисовская Екатерина Георгиевна", 2, 191);
        Employee employeeForComparison = new Employee("Мартынова Марина Максимовна", 1, 200);

        book.addEmployee(alina);
        book.addEmployee(sergey);
        book.addEmployee(galina);
        book.addEmployee(vera);
        book.addEmployee(oleg);
        book.addEmployee(nikita);
        book.addEmployee(marina);
        book.addEmployee(ivan);
        book.addEmployee(ura);
        book.addEmployee(ekaterina);

        System.out.println("Средняя зарплата равна: " + book.calculateAverageSalary());
        book.indexingSalaries(2, 5);
        book.printAllEmployees();
        book.printTaxes();
        System.out.println("Сотрудник из отдела 5 с зарплатой выше 200:");
        book.findingHighestSalary(5, 200);
        System.out.println("Первые 4 сотрудника с зарплатой меньше 100:");
        book.findingLowerSalaries(100, 4);

        if (book.employeeComparison(employeeForComparison)) {
            System.out.println("Сотрудник найден");
        } else {
            System.out.println("Сотрудник не найден");
        }

        int searchId = 6;
        Employee foundEmployee = book.findById(searchId);

        if (foundEmployee != null) {
            System.out.println("Сотрудник с ID "+ searchId +" найден: " + foundEmployee);
        } else {
            System.out.println("Сотрудник не найден");
        }
    }
}
