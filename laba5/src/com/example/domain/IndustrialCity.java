package laba5.src.com.example.domain;

public class IndustrialCity extends City {
    private String factories;

    public IndustrialCity(String name, int population, String factories) {
        super(name, population);
        this.factories = factories;
    }

    public void showInfo() {
        System.out.println("Industrial: " + getName() + ", population: " + getPopulation() + ", factories: " + factories);
    }
}
