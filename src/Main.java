public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        Employee alina = new Employee("Чернякова Алина Олеговна", 5, 60000);
        Employee sergey = new Employee("Иванов Сергей Иванович", 3, 65600);
        Employee galina = new Employee("Сусленкова Галина Сергеевна", 2, 71000);
        Employee vera = new Employee("Люблова Вера Николаевна", 4, 89500);
        Employee oleg = new Employee("Волков Олег Николаевич", 5, 55000);
        Employee nikita = new Employee("Бобылев Никита Георгиевич", 4, 134000);
        Employee marina = new Employee("Мартынова Марина Максимовна", 1, 20000);
        Employee ivan = new Employee("Иванов Иван Иванович", 1, 68000);
        Employee ura = new Employee("Козлов Юрий Олегович", 3, 99000);
        Employee ekaterina = new Employee("Лисовская Екатерина Георгиевна", 2, 19500);
        Employee alisa = new Employee("Пушистова Алиса Юрьевна", 5, 110000);
        Employee employeeForComparison = new Employee("Мартынова Марина Максимовна", 1, 20000);

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
        book.addEmployee(alisa);

        book.indexingSalaries(2, 5);
        System.out.println("Средняя зарплата равна: " + book.calculateAverageSalary());
        book.printAllEmployees();
        book.printTaxes();
        System.out.println("Сотрудник из отдела 5 с зарплатой выше 50000:");
        book.findingHighestSalary(5, 50000);
        System.out.println("Первые 5 сотрудников с зарплатой меньше 80000:");
        book.findingLowerSalaries(80000, 5);

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
