package fr.univorleans.iut45.SAEGraphe;

import org.jgrapht.Graph;
import java.util.List;
import java.util.ArrayList;

public class Graphe {
    
    private Graph<Page,DefaultEdge> graphe;
    private List<Objet> inventaire;

    public Graphe(){

        this.graphe = new Graph();
        this.inventaire = new ArrayList<>();
    }

    public void start(){
        
    }

    public boolean tousObjets(){

    }

    public void explorePage(Page page){

    }

    

}
