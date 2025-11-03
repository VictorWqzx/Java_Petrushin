package laba6;

public class Piano {
    private Key[] keys;
    private Pedal pedal;

    public Piano() {
        keys = new Key[]{ new Key("До"), new Key("Ре"), new Key("Ми") };
        pedal = new Pedal("Сустейн");
    }

    public void tune() {
        System.out.println("Пианино настроено");
    }

    public void play() {
        System.out.println("Играем:");
        for (Key key : keys) {
            key.press();
        }
        pedal.press();
    }

    public void pressKey(int index) {
        if (index >= 0 && index < keys.length) {
            keys[index].press();
        } else {
            System.out.println("Такой клавиши нет");
        }
    }
}

