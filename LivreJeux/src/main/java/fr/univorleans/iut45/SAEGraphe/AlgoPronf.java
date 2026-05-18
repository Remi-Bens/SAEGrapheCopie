package fr.univorleans.iut45.SAEGraphe;

import java.util.Stack;

public class AlgoPronf {
    Stack<Page> pile;
    Graphe gr;

    public AlgoPronf(Graphe g){
        this.pile = new Stack<>();
        this.gr = g;
    }

     public boolean start(){
        Page prem = gr.premierePage();
        for(Page p : gr.getGraphe().successorListOf(prem)){
            pile.push(p);}
        
        while(!pile.isEmpty()){
            Page suiv = pile.pop();
            suiv.lecture();
            System.out.println("La page n° "+suiv.getNum()+" est lu !");
            for(Page p : gr.getGraphe().successorListOf(suiv)){
                if(!p.estLu()){
            pile.push(p);}}
        }
    }
}
