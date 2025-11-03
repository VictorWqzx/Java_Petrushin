package laba8;
public class Hammer implements Tool {
    private final String model;

    public Hammer() {
        this("Standard Hammer");
    }

    public Hammer(String model) {
        this.model = model;
    }

    @Override
    public void use() {
        System.out.println(model + " — стучу гвоздь.");
    }

    @Override
    public String toString() {
        return "Hammer{model='" + model + "'}";
    }
}

