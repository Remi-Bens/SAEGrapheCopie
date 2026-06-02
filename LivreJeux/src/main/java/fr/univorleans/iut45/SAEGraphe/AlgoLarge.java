package fr.univorleans.iut45.SAEGraphe;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.graph.DefaultEdge;

public class AlgoLarge {
    List<Page> liste;
    Graphe gr;
    int duree;

public AlgoLarge(Graphe g){
        this.liste = new ArrayList<>();
        this.gr = g;
        this.duree = 0;
    }

    public int start(){

        Page prem = gr.premierePage();
        prem.lire();
        for(DefaultEdge e : gr.getGraphe().outgoingEdgesOf(prem)){
            Page p = this.gr.getGraphe().getEdgeTarget(e);
            liste.add(p);
        }

        while(!liste.isEmpty()){

            Page suiv = liste.remove(0);
            if (!suiv.estLue()){
                suiv.lire();
                this.duree += suiv.getEnigme().length();

                //System.out.println("La page n° "+suiv.getNum()+" est lu !");

                for(DefaultEdge edge : gr.getGraphe().outgoingEdgesOf(suiv)){

                    Page target = gr.getGraphe().getEdgeTarget(edge);
                    if(!target.estLue()){
                        liste.add(target);
                    }
                }
            }
        }
        return this.duree;
    }
}