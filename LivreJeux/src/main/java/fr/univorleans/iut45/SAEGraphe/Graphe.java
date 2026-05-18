package fr.univorleans.iut45.SAEGraphe;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;
import java.util.List;
import java.util.ArrayList;

public class Graphe {
    
    private Graph<Page,DefaultEdge> graphe;
    private List<Objet> inventaire;
    private Affichage affichage;

    public Graphe(){

        this.graphe = new DefaultDirectedGraph();
        this.inventaire = new ArrayList<>();
    }

    public void start(){
        
    }

    public Page premierePage(){

    }

    public boolean tousObjets(){
        return inventaire.size()>=10;
    }

    public Graph<page> getGraphe(){
        return this.graphe;
    }

    public void explorePage(Page page){
        page.afficheEnig();
        List<Page> possibilités = this.graphe.getEdges(page);

        String rep = System.console().readLine();
        rep = rep.strip().toLowerCase();

        if (rep.equals("a")) {
            this.explorePage(possibilités.get(0));
        }
        else if(rep.equals("b") && possibilités.size()>=2) {
            this.explorePage(possibilités.get(1));
        }
        else if(rep.equals("b") && possibilités.size()>=3) {
            this.explorePage(possibilités.get(2));
        }
        else if(rep.equals("b") && possibilités.size()>=4) {
            this.explorePage(possibilités.get(3));
        }
        else if(rep.equals("b") && possibilités.size()>=5) {
            this.explorePage(possibilités.get(4));
        }
        else {
            this.affichage.erreur("Veuillez entrer un caractère valide!");
            this.explorePage(page);
        }



    }

    public void tempsDeParcours() {

    }



    

}
