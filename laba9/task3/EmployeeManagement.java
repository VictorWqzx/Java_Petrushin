package laba9.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

abstract class Employee {
    private static int idCounter = 1;
    protected int id;
    protected String name;

    public Employee(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateAverageMonthlySalary();

    @Override
    public String toString() {
        return String.format(Locale.US, "ID: %-3d | Имя: %-20s | Среднемесячная з/п: %,.2f",
                getId(), getName(), calculateAverageMonthlySalary());
    }
}

class FixedSalaryEmployee extends Employee {
    private double fixedMonthlyPayment;

    public FixedSalaryEmployee(String name, double fixedMonthlyPayment) {
        super(name);
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    @Override
    public double calculateAverageMonthlySalary() {
        return fixedMonthlyPayment;
    }
}

class HourlyRateEmployee extends Employee {
    private double hourlyRate;

    public HourlyRateEmployee(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateAverageMonthlySalary() {
        return 20.8 * 8 * hourlyRate;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FixedSalaryEmployee("Анатолий Вассерман", 80000.00));
        employees.add(new HourlyRateEmployee("Борис Крюк", 500.0));
        employees.add(new FixedSalaryEmployee("Сергей Светлаков", 120000.00));
        employees.add(new FixedSalaryEmployee("Евгений Понасенков", 83200.00));
        employees.add(new HourlyRateEmployee("Дмитрий Нагиев", 850.5));
        employees.add(new HourlyRateEmployee("Михаил Галустян", 500.0));
        employees.add(new FixedSalaryEmployee("Александр Друзь", 95000.00));

        employees.sort(
            Comparator.comparing(Employee::calculateAverageMonthlySalary).reversed()
                      .thenComparing(Employee::getName).reversed()
        );
        

        System.out.println("--- a) Отсортированный список всех сотрудников ---");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        System.out.println("\n--- b) Первые 5 имен работников из списка ---");
        for (int i = 0; i < 5 && i < employees.size(); i++) {
            System.out.println(employees.get(i).getName());
        }

        System.out.println("\n--- c) Последние 3 ID работников из списка ---");
        int totalSize = employees.size();
        for (int i = Math.max(0, totalSize - 3); i < totalSize; i++) {
            System.out.println("ID: " + employees.get(i).getId());
        }
    }
}
