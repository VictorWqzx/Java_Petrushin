package laba7;
abstract class Tool {
    public String name;
    public Tool(String name) {
        this.name = name;
    }
    abstract void use();
}
    

class  Hammer extends Tool {
    public Hammer(String name){
        super(name);
    }
    
    @Override
    void use() {
        System.out.println("Бью молотком по гвоздю");
    }
}

class Screwdriver extends Tool {
    public Screwdriver(String name){
        super(name);
    }
    
    @Override
    void use() {
        System.out.println("Закручиваю винт отверткой");
    }
}

public class Main {
    public static void main(String[] args) {
        Tool hammer = new Hammer();
        Tool screwdriver = new Screwdriver();

        hammer.use();
        screwdriver.use();
    }
}
