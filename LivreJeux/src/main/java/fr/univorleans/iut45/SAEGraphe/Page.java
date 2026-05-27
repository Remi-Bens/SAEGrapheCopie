package fr.univorleans.iut45.SAEGraphe;

import java.util.ArrayList;
import java.util.List;

public class Page{

    private int numero;
    private String enigme;
    private List<String> reponse;
    private boolean lecture;
    private boolean objet;
    private int pos;


    public Page(int numero,  String enigme,List<String> rep, int pos){
        this.numero = numero;
        this.enigme = enigme;
        this.reponse = rep;
        this.lecture = false;
        this.objet = false;
        this.pos = pos;
    }

    public void setReponse(String choix){
        this.reponse.add(choix);
    }

    public int getNum(){
        return this.numero;
    }

    public boolean getObjet() {
        return this.objet;
    }

    public void setObjet(boolean ob){
        this.objet = ob;
    }

    public boolean getFin(){
        if(this.pos > 0){return true;}
        return false;
    }

    public boolean getDeb(){
        if(this.pos < 0){return true;}
        return false;
    }

    public String getTexte(){
        return this.enigme;
    }

    public int getNbReponses(){
        return reponse.size();
    }

    public boolean estLue(){
        return this.lecture;
    }

    public void lire(){
        this.lecture = true;
    }

    public void setFin(){
        this.pos = 1;
    }

    public void setDeb(){
        this.pos = -1;
    }
    
    public String afficheEnig(){
        int cpt =0;
        String phr = this.getTexte();
        phr +="\n";
        for(String i : this.reponse){
        phr += String.valueOf(cpt)+" : "+i+"\n";
        cpt +=1;}
        return phr;
    }
}