package laba10.task1;

public abstract class Sotrudnik {
    private String fio;
    private String dolzhnost;
    private double oklad;
    public Sotrudnik(String fio, String dolzhnost, double oklad) throws OkladException {
        if (oklad < 0) {
            throw new OkladException("указан отрицательный оклад: " + oklad);
        }
        this.fio = fio;
        this.dolzhnost = dolzhnost;
        this.oklad = oklad;
    }
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDolzhnost() {
        return dolzhnost;
    }

    public void setDolzhnost(String dolzhnost) {
        this.dolzhnost = dolzhnost;
    }

    public double getOklad() {
        return oklad;
    }

    public void setOklad(double oklad) throws OkladException {
        if (oklad < 0) {
            throw new OkladException("указан отрицательный оклад: " + oklad);
        }
        this.oklad = oklad;
    }

    // Абстрактный метод, который должны реализовать все наследники
    public abstract void rasschitatZarplatu();
}