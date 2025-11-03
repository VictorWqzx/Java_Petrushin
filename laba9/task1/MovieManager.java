package laba9.task1;

import java.util.HashMap;
import java.util.Map;

class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Фильм '" + title + "'";
    }
}

class Action extends Movie {
    public Action(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Боевик '" + getTitle() + "'";
    }
}

class Drama extends Movie {
    public Drama(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Драма '" + getTitle() + "'";
    }
}

public class MovieManager {
    public static void main(String[] args) {
        Map<String, Movie> movieCollection = new HashMap<>();

        movieCollection.put("Крепкий орешек", new Action("Крепкий орешек"));
        movieCollection.put("Побег из Шоушенка", new Drama("Побег из Шоушенка"));
        movieCollection.put("Терминатор 2", new Action("Терминатор 2"));
        movieCollection.put("Зеленая миля", new Drama("Зеленая миля"));
        movieCollection.put("Матрица", new Action("Матрица"));

        System.out.println("Все фильмы в коллекции (ключи):");
        for (String title : movieCollection.keySet()) {
            System.out.println(title);
        }
        for (Map.Entry<String, Movie> entry : movieCollection.entrySet()) {
        System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
