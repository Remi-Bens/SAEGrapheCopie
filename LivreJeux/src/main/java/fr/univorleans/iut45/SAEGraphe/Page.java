package fr.univorleans.iut45.SAEGraphe;

import java.util.ArrayList;
import java.util.List;

public class Page{

    private int numero;
    private boolean fin;
    private String enigme;
    private List<String> reponse;

    public Page(int numero, boolean fin, String enigme){
        this.numero = numero;
        this.fin = fin ;
        this.enigme = enigme;
        this.reponse = new ArrayList<>();
    }

    public void setReponse(String choix){
        this.reponse.add(choix);
    }

    public int getNum(){
        return this.numero;
    }
    public boolean getFin(){
        return this.fin;
    }

    public String getEnigme(){
        return this.enigme;
    }

    public String afficheEnig(){
        String phr = this.getEnigme();
        phr +="\n";
        
    }
}