package laba5.src.com.example;

import laba5.src.com.example.domain.Employee;
import laba5.src.com.example.domain.Capital;
import laba5.src.com.example.domain.ResortCity;
import laba5.src.com.example.domain.IndustrialCity;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setName("John Dep");
        emp.setSalary(120_345.27);
        emp.setSsn("012-34-5678");

        System.out.println("=== Employee Info ===");
        System.out.println("Employee ID: " + emp.getEmpId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Soc Sec #: " + emp.getSsn());
        System.out.println("Employee Salary: " + emp.getSalary());

        Capital capital = new Capital("Brussels", 1200000, "Belgium");
        ResortCity resort = new ResortCity("Nice", 340000, 200);
        IndustrialCity industrial = new IndustrialCity("Minsk", 2000000, "Computers");

        capital.showInfo();
        resort.showInfo();
        industrial.showInfo();
    }
}
