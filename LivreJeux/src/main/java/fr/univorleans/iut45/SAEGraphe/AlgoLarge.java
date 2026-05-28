package fr.univorleans.iut45.SAEGraphe;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;
import java.util.ArrayList;

public class AlgoLarge {
    List<Page> liste;
    DefaultDirectedGraph<Page,DefaultEdge> gr;

public AlgoLarge(DefaultDirectedGraph<Page,DefaultEdge> g){
    this.liste = new ArrayList<>();
    this.gr = g;
    }

    public boolean start(){
    Page prem = new Page();
    for (Page page:gr.vertexSet()){
        if (page.getDeb()) {
            prem = page;
            break;
        }
    }

    prem.lire();
    
    for(DefaultEdge e : gr.outgoingEdgesOf(prem)){
        Page p = this.gr.getEdgeTarget(e);
        liste.add(p);}
    while(!liste.isEmpty()){
        Page suiv = liste.remove(0);
        suiv.lire();
        System.out.println("La page n° "+suiv.getNum()+" est lu !");
        for(DefaultEdge edge : gr.outgoingEdgesOf(suiv)){
            Page target = gr.getEdgeTarget(edge);
            if(!target.estLue()){
            liste.add(target);}
            }
        if(suiv.getFin()){
                return true;
        }
        }
        return false;
    }

}
