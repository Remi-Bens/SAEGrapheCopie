package fr.univorleans.iut45.SAEGraphe;

import java.util.List;
import java.util.Stack;

public class AlgoPronf {
    Stack<Page> pile;
    Graphe gr;

    public AlgoPronf(Graphe g){
        this.pile = new Stack<>();
        this.gr = g;
    }

    public List<Page> successorListOf(Page vertex){
        return this.gr.getGraphe().successorListOf(vertex);
    }

     public boolean commencer(){
        Page prem = gr.premierePage();
        List<Page> noeudsuiv = gr.successorListOf(prem);
        for(Page p : noeudsuiv){
            pile.push(p);}
        
        while(!pile.isEmpty()){
            Page suiv = pile.pop();
            suiv.lire();
            System.out.println("La page n° "+suiv.getNum()+" est lu !");
            for(Page p : gr.successorListOf(suiv)){
                if(!p.estLue()){
            pile.push(p);}}
        }
    }
}
