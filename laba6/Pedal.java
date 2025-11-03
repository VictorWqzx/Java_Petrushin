package laba6;

public class Pedal {
    private String type;

    public Pedal(String type) {
        this.type = type;
    }

    public void press() {
        System.out.println("Нажата педаль: " + type);
    }
}

