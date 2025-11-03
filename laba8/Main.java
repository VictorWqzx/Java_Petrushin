package laba8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Tool> toolbox = new ArrayList<>();
        toolbox.add(new Hammer("Hammer"));
        toolbox.add(new Screwdriver("Flat"));

        for (Tool t : toolbox) {
            System.out.println("Использую инструмент: " + t);
            t.use();
        }
    }
}

