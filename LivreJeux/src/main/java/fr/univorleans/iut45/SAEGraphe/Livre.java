package fr.univorleans.iut45.SAEGraphe;

import java.util.ArrayList;
import java.util.List;

public class Livre {
    private List<Page> pa;

    public Livre(){
        this.pa = new ArrayList<>();
    }

    public Livre(Page p){
        this.pa.add(p);
    }

    public Page getDebut(){
        return this.pa.get(0);
    }
}
