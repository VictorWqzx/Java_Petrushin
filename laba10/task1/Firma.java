package laba10.task1;

import java.util.ArrayList;
import java.util.List;

public class Firma {
    private String nazvanie;
    private List<Otdel> otdely;

    public Firma(String nazvanie) {
        this.nazvanie = nazvanie;
        this.otdely = new ArrayList<>();
    }
    
    public void addOtdel(Otdel otdel) {
        this.otdely.add(otdel);
    }

    public List<Otdel> getOtdely() {
        return otdely;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }
}