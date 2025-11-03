package laba5.src.com.example.domain;

public class ResortCity extends City {
    private int hasSea;

    public ResortCity(String name, int population, int hasSea) {
        super(name, population);
        this.hasSea = hasSea;
    }

    public void showInfo() {
        System.out.println("Resort: " + getName() + ", population: " + getPopulation() + ", sea places: " + hasSea);
    }
}
