package laba8;

public class Screwdriver implements Tool {
    private final String type;

    public Screwdriver() {
        this("Phillips");
    }

    public Screwdriver(String type) {
        this.type = type;
    }

    @Override
    public void use() {
        System.out.println(type + " отвертка — закручиваю/откручиваю винт.");
    }

    @Override
    public String toString() {
        return "Screwdriver{" + "type='" + type + '\'' + '}';
    }
}

