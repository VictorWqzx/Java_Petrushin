package com.example;

public class Tester {
    // Поля класса
    private String name;
    private String surname;
    private int expirienceInYears;
    private String englishLevel;
    private double salary;

    public Tester(String name, String surname, int expirienceInYears, String englishLevel, double salary) {
        this.name = name;
        this.surname = surname;
        this.expirienceInYears = expirienceInYears;
        this.englishLevel = englishLevel;
        this.salary = salary;
    }

    public Tester(String name, String surname, int expirienceInYears) {
        this(name, surname, expirienceInYears, "B1", 3000.0);
    }
    
    public Tester(String name, String surname) {
        this(name, surname, 0);
    }
    
    
    public Tester(String name) {
        this(name, "Unknown");
    }

    
    public void printInfo() {
        System.out.println("Name: " + name + ", Surname: " + surname);
    }
    
    
    public void printInfo(boolean full) {
        if (full) {
            System.out.println(String.format("Full info: %s %s, experience: %d years, english: %s, salary: %.2f",
                this.name, this.surname, this.expirienceInYears, this.englishLevel, this.salary));
        } else {
            printInfo();
        }
    }

    
    public void printInfo(String prefix) {
        System.out.println(prefix + " -> Name: " + name + ", Surname: " + surname + ", Experience: " + expirienceInYears + " years.");
    }

    public static void printWelcome() {
        System.out.println("Welcome! This is a static method from the Tester class.");
    }
}