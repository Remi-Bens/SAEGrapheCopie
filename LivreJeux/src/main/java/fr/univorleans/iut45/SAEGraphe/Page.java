package fr.univorleans.iut45.SAEGraphe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.io.Serializable;

public class Page implements Serializable{

    private int numero;
    private String enigme;
    private List<String> reponse;
    private boolean lecture;
    private boolean objet;
    private int pos;


    public Page(){
        this.numero = -1;
        this.enigme = "";
        this.reponse = new ArrayList<>();
        this.lecture = false;
        this.objet = false;
        this.pos = 0;
    }

    public Page(int numero,  String enigme,List<String> rep, int pos){
        this.numero = numero;
        this.enigme = enigme;
        this.reponse = rep;
        this.lecture = false;
        this.objet = false;
        this.pos = pos;
    }

    public Page(Page autre){
        this.numero = autre.numero;
        this.enigme = new String(autre.enigme);
        this.reponse = new ArrayList<>(autre.reponse);
        this.lecture = autre.lecture;
        this.objet = autre.objet;
        this.pos = autre.pos;
    }

    public void setReponse(String choix){
        this.reponse.add(choix);
    }

    public int getNum(){
        return this.numero;
    }

    public String getEnigme(){
        return this.enigme;
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

    public void ajouteReponse(String reponse){
        
    }

    public void lire(){
        this.lecture = true;
    }

    public void oublier(){
        this.lecture = false;
    }

    public void setFin(){
        this.pos = 1;
        this.enigme = "psartek";
        this.reponse = new ArrayList<>();
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

    @Override
    public String toString() {
        if (this.pos < 0) return "Début "+ this.numero;
        if (this.pos > 0) return "Finitoto "+ this.numero;
        return "Page " + this.numero;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getNum());
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Page)) return false;
        Page p2 = (Page) o;
        return (p2.getNum()==this.getNum());
    }
}