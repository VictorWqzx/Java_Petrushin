package laba5.src.com.example.domain;

public class City {
    private String name;
    private int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() { return name; }
    public int getPopulation() { return population; }
    public void showInfo() {
        System.out.println(name + population);
    }
}
