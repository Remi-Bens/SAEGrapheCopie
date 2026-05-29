package fr.univorleans.iut45.SAEGraphe;
import java.util.Stack;
import org.jgrapht.graph.DefaultEdge;

public class AlgoPronf {
    
    Stack<Page> pile;
    Graphe gr;
    int duree;

    public AlgoPronf(Graphe g){
        this.pile = new Stack<>();
        this.gr = g;
        this.duree = 0;
    }

    public int start(){

        Page prem = gr.premierePage();
        prem.lire();

        for(DefaultEdge e : gr.getGraphe().outgoingEdgesOf(prem)){
            Page p = this.gr.getGraphe().getEdgeTarget(e);
            pile.push(p);
        }

        while(!pile.isEmpty()){

            Page suiv = pile.pop();
            suiv.lire();
            this.duree += suiv.getEnigme().length();

            //System.out.println("La page n° "+suiv.getNum()+" est lu !");

            for(DefaultEdge edge : gr.getGraphe().outgoingEdgesOf(suiv)){

                Page target = gr.getGraphe().getEdgeTarget(edge);
                if(!target.estLue()){
                    pile.push(target);
                }
            }
        }
        return this.duree;
    }
}