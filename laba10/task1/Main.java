package laba10.task1;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Проверка задания (б): Создание сотрудника с отрицательным окладом ---");
        try {
            Sotrudnik invalidEmployee = new ShtatnySotrudnik("Петров П.П.", "Бездельник", -50000, 10000);
            System.out.println("Сотрудник с отрицательным окладом был успешно создан (ЭТОГО НЕ ДОЛЖНО ПРОИЗОЙТИ).");
        } catch (OkladException e) {
        
            System.out.println("Невозможно создать сотрудника - " + e.getMessage());
            
        }
        System.out.println("------------------------------------------------------------------");

        System.out.println("\n--- Проверка задания (а): Расчет зарплаты с ошибками ---");

        try {
            ShtatnySotrudnik employeeWithBadBonus = new ShtatnySotrudnik("Сидоров С.С.", "Инженер", 60000, -5000);
            employeeWithBadBonus.rasschitatZarplatu(); 

            SotrudnikPoKontraktu employeeWithTypeError = new SotrudnikPoKontraktu("", "Дизайнер", 75000);
            employeeWithTypeError.rasschitatZarplatu(); 

            ShtatnySotrudnik employeeWithValueError = new ShtatnySotrudnik("Кузнецов К.К.", "Стажер", 0, 5000);
            employeeWithValueError.rasschitatZarplatu(); 

        } catch (OkladException e) {
            System.out.println("Произошла ошибка при создании тестового сотрудника: " + e.getMessage());
        }
        System.out.println("------------------------------------------------------------------");

        System.out.println("\n Демонстрация работы ");

        try {
            Firma myFirm = new Firma("КБИП");
            Otdel itDepartment = new Otdel("IT-отдел");
            Otdel accountingDepartment = new Otdel("Бухгалтерия");

            Sotrudnik emp1 = new ShtatnySotrudnik("Иванов И.И.", "Программист", 120000, 30000);
            Sotrudnik emp2 = new SotrudnikPoKontraktu("Алексеев А.А.", "Тестировщик", 90000);
            Sotrudnik emp3 = new ShtatnySotrudnik("Смирнова О.В.", "Главный бухгалтер", 100000, 45000);

            itDepartment.addSotrudnik(emp1);
            itDepartment.addSotrudnik(emp2);
            accountingDepartment.addSotrudnik(emp3);

            myFirm.addOtdel(itDepartment);
            myFirm.addOtdel(accountingDepartment);

            System.out.println("Фирма: '" + myFirm.getNazvanie() + "'");
            for (Otdel dep : myFirm.getOtdely()) {
                System.out.printf("  Отдел: '%s' (Сотрудников: %d)%n", dep.getNazvanie(), dep.getKolichestvoSotrudnikov());
                for (Sotrudnik emp : dep.getSotrudniki()) {
                    emp.rasschitatZarplatu();
                }
            }

        } catch (OkladException e) {
            System.out.println("Произошла неожиданная ошибка при создании структуры фирмы: " + e.getMessage());
        }
    }
}