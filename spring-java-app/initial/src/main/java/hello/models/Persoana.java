package hello;

import java.util.List;
import java.util.ArrayList;

public class Persoana{
    private String nume;
    private int id;

    public Persoana(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public Persoana() {
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