package laba5.src.com.example.domain;

public class Capital extends City {
    private String country;

    public Capital(String name, int population, String country) {
        super(name, population);
        this.country = country;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println(", country: " + country);
    }
}
