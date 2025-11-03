package laba6;

public class Key {
    private String note;

    public Key(String note) {
        this.note = note;
    }

    public void press() {
        System.out.println("Нажата клавиша: " + note);
    }

    public String getNote() {
        return note;
    }
}

