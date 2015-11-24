package hello;

import java.util.List;
import java.util.ArrayList;

public class Produs{
    private String nume;
    private int id;

    public Produs() {
    }

    public Produs(int id, String nume) {
        this.nume = nume;
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public int getId() {
        return id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setId(int id) {
        this.id = id;
    }
}