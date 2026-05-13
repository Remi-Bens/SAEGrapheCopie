package fr.univorleans.iut45.SAEGraphe;

public class PageFin {
    private boolean fin;

    PageFin(boolean fin){
        this.fin = fin;
    }

    boolean getFin(){
        return this.fin;
    }

    String findujeu(){
        if (true){
            return "Fin du jeu";

        }
        return "C'est pas encore fini";
    }
}
