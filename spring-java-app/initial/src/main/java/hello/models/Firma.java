package hello;

import java.util.List;
import java.util.ArrayList;

public class Firma{
    private String nume;
    private int id;

    public Firma() {
    }

    public Firma(int id, String nume) {
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