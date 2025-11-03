package laba11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class FileExercises {
    public static void main(String[] args) {
        System.out.println("--- ЗАДАНИЕ 1 ---");
        runTask1();
        System.out.println("\n-------------------------------------\n");
        System.out.println("--- ЗАДАНИЕ 2 ---");
        runTask2();
        System.out.println("\n-------------------------------------\n");
        System.out.println("--- ЗАДАНИЕ 3 ---");
        runTask3();
        System.out.println("\n-------------------------------------\n");
    }
    public static void runTask1() {
        String fileName = "about_me.txt";
                try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Привет! Это файл с информацией обо мне.\n");
            writer.write("Меня зовут Виктор.\n");
            System.out.println("Файл '" + fileName + "' успешно создан и заполнен.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }

        System.out.println("\n--- Информация о файле ---");
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Имя файла: " + file.getName());
            System.out.println("Полный путь: " + file.getAbsolutePath());
            System.out.println("Размер (в байтах): " + file.length());
            System.out.println("Доступен для чтения: " + file.canRead());
        } else {
            System.out.println("Файл не найден.");
            return;
        }
        
        System.out.println("\n--- Содержимое файла ---");
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
    public static void runTask2() {
        String fileName = "temperatures.txt";
        Scanner keyboardScanner = new Scanner(System.in);
                try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            System.out.println("Введите 10 вещественных значений температуры:");
            for (int i = 0; i < 10; i++) {
                System.out.print("Температура " + (i + 1) + ": ");
                try {
                    double temp = keyboardScanner.nextDouble();
                    writer.println(temp);
                } catch (InputMismatchException e) {
                    System.out.println("Неверный ввод. Пожалуйста, введите число. Попробуйте снова.");
                    keyboardScanner.next(); 
                    i--; 
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }
        double sum = 0;
        int count = 0;
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            fileScanner.useLocale(java.util.Locale.US);
            while (fileScanner.hasNextDouble()) {
                sum += fileScanner.nextDouble();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл для чтения не найден: " + e.getMessage());
            return;
        }

        if (count > 0) {
            double average = sum / count;
            System.out.printf("\nЧтение из файла... Прочитано %d значений.%n", count);
            System.out.printf("Средняя температура: %.2f%n", average);
        } else {
            System.out.println("\nФайл пуст, невозможно рассчитать среднюю температуру.");
        }
    }
    public static void runTask3() {
        String fileWithNumbers = "numbers.txt";
        String emptyFile = "empty.txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileWithNumbers))) {
            writer.println("10.5");
            writer.println("20.0");
            writer.println("30.5");
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла с числами: " + e.getMessage());
        }
        
        try (FileWriter writer = new FileWriter(emptyFile)) {
        } catch (IOException e) {
            System.err.println("Ошибка при создании пустого файла: " + e.getMessage());
        }
        
        System.out.println("Проверка файла с числами ('" + fileWithNumbers + "'):");
        calculateAverageFromFile(fileWithNumbers);
        
        System.out.println("\nПроверка пустого файла ('" + emptyFile + "'):");
        calculateAverageFromFile(emptyFile);
    }
    
    
    private static void calculateAverageFromFile(String fileName) {
        double sum = 0;
        int count = 0;
        
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.useLocale(java.util.Locale.US);
            while (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            return;
        }
        
        if (count == 0) {
            System.out.println("Файл пуст или не содержит чисел. Деление на ноль предотвращено.");
        } else {
            double average = sum / count;
            System.out.printf("Среднее значение: %.2f%n", average);
        }
    }
}