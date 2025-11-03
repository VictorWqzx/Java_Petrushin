package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello Victor!");
        System.out.println("--------------------");

        
        Tester.printWelcome();
        System.out.println("--------------------");

        System.out.println("Creating objects...");
        Tester t1 = new Tester("Victor"); 
        Tester t2 = new Tester("Victor", "Petrushin"); 
        Tester t3 = new Tester("Victor", "Petrushin", 5); 
        System.out.println("Objects created.");
        System.out.println("--------------------");


        
        System.out.println("Calling methods...");
        t1.printInfo();
        t2.printInfo(true);
        t3.printInfo("Employee");
        System.out.println("--------------------");
    }
}