package fr.univorleans.iut45.SAEGraphe;

import java.util.List;
import java.util.Stack;

import org.jgrapht.graph.DefaultEdge;

public class AlgoPronf {
    Stack<Page> pile;
    Graphe gr;

    public AlgoPronf(Graphe g){
        this.pile = new Stack<>();
        this.gr = g;
    }

     public boolean start(){
        Page prem = gr.premierePage();
<<<<<<< HEAD
        prem.lire();
        for(DefaultEdge e : gr.getGraphe().outgoingEdgesOf(prem)){
            Page p = this.gr.getGraphe().getEdgeTarget(e);
=======
        List<Page> noeudsuiv = gr.successorListOf(prem);
        for(Page p : ){
>>>>>>> 67f2a1b (test recup graphe)
            pile.push(p);}
        
        while(!pile.isEmpty()){
            Page suiv = pile.pop();
            suiv.lire();
            System.out.println("La page n° "+suiv.getNum()+" est lu !");
            for(DefaultEdge edge : gr.getGraphe().outgoingEdgesOf(suiv)){
            Page target = gr.getGraphe().getEdgeTarget(edge);
            if(!target.estLue()){
                pile.push(target);}
                }
            }
        return true;
    }
}

