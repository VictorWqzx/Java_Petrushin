package laba6;

public class MainFerret {
    public static void main(String[] args) {
        Ferret f1 = new Ferret();
        Ferret f2 = new Ferret("Федя", 3, "коричневый");

        f1.showInfo();
        f1.eat();
        f1.sleep();

        System.out.println("\n--- Второй хорёк ---");
        f2.showInfo();
        f2.eat();
        f2.sleep();
    }
}

