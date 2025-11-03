package laba6;

public class Ferret {
    private String name;
    protected int age;
    public String color;
    private boolean isHungry;

    public Ferret() {
        this.name = "Безымянный хорек";
        this.age = 1;
        this.color = "белый";
        this.isHungry = true;
    }

    public Ferret(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.isHungry = false;
    }

    public void eat() {
        if (isHungry) {
            System.out.println(name + " ест, не голоден");
            isHungry = false;
        } else {
            System.out.println(name + " не голоден");
        }
    }

    protected void sleep() {
        System.out.println(name + " спит");
    }

    private void play() {
        System.out.println(name + " играет");
    }

    public void showInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Цвет: " + color);
        System.out.println("Голоден: " + (isHungry ? "Да" : "Нет"));
        play();
    }
}
