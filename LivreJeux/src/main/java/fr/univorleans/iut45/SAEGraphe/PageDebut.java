package fr.univorleans.iut45.SAEGraphe;

public class PageDebut {
        private boolean debut;
        private int num;

    PageDebut(boolean debut){
        this.debut = debut;
        this.num = 1;
    }

    boolean getDebut(){
        return this.debut;
    }
    int getNum(){
        return this.num;
    }

    String Debutdujeu(){
        if (getNum() == 1){
            return "Ceci est la page du début du jeu !";

        }
        return " ";
    }
}