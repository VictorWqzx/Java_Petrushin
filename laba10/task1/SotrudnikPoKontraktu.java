package laba10.task1;

public class SotrudnikPoKontraktu extends Sotrudnik {

    public SotrudnikPoKontraktu(String fio, String dolzhnost, double oklad) throws OkladException {
        super(fio, dolzhnost, oklad);
    }

    @Override
    public void rasschitatZarplatu() {
        try {
            if (this.getFio() == null || this.getFio().isEmpty()) {
                throw new IllegalArgumentException("Невозможно рассчитать зарплату для сотрудника без ФИО.");
            }

            double totalSalary = this.getOklad();
            System.out.printf("З/П сотрудника по контракту %s (оклад): %.2f%n", this.getFio(), totalSalary);

        } catch (Exception e) {
            System.out.printf("ОШИБКА РАСЧЕТА ЗАРПЛАТЫ для '%s': %s%n", this.getFio(), e.getMessage());
        }
    }
}