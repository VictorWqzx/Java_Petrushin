package laba10.task1;

public class ShtatnySotrudnik extends Sotrudnik {
    private double premiya;

    public ShtatnySotrudnik(String fio, String dolzhnost, double oklad, double premiya) throws OkladException {
        super(fio, dolzhnost, oklad); 
        this.premiya = premiya;
    }

    public double getPremiya() {
        return premiya;
    }

    public void setPremiya(double premiya) {
        this.premiya = premiya;
    }

    @Override
    public void rasschitatZarplatu() {
        try {
            if (this.premiya < 0) {
                throw new PremiyaException("Премия не может быть отрицательной.");
            }
            if (this.getOklad() == 0) {
                throw new ArithmeticException("Оклад не может быть равен нулю для расчета.");
            }

            double totalSalary = this.getOklad() + this.premiya;
            System.out.printf("З/П штатного сотрудника %s (оклад %.2f + премия %.2f): %.2f%n",
                    this.getFio(), this.getOklad(), this.getPremiya(), totalSalary);

        } catch (PremiyaException e) {
            System.out.printf("ОШИБКА РАСЧЕТА ЗАРПЛАТЫ для %s: %s%n", this.getFio(), e.getMessage());
        } catch (Exception e) {
            System.out.printf("ОШИБКА РАСЧЕТА ЗАРПЛАТЫ для %s: Произошла непредвиденная ошибка - %s%n",
                    this.getFio(), e.getMessage());
        }
    }
}