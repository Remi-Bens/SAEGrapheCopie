package fr.univorleans.iut45.SAEGraphe;

import java.util.List;

public class PageDebut extends Page{

    PageDebut(int numero,  String enigme){
        super(numero,enigme);
    }

    PageDebut(int numero,  String enigme,List<String> rep){
        super(numero,enigme,rep);
    }

    public String debutDuJeu(){
        if (getNum() == 1){
            return "Ceci est la page du début du jeu !";

        }
        return " ";
    }
}