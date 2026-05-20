package fr.univorleans.iut45.SAEGraphe;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.Random;

public class Graphe {
    
    private DirectedGraph<Page,DefaultEdge> graphe;
    private List<Objet> inventaire;
    private Affichage affichage;

    public Graphe(){

        this.graphe = new DefaultDirectedGraph<>(DefaultEdge.class);
        
        this.inventaire = new ArrayList<>();
    }

    public void start(){
        this.graphe.successorListOf();
    }

    public Page premierePage() throws PageNotFoundException{
        for (Page page:graphe.vertexSet()) {
            if (page instanceof PageDebut) {
                return page;
            }
        }
        throw new PageNotFoundException("Aucune première page trouvée ");
    }

    public boolean tousObjets(){
        return inventaire.size()>=10;
    }

    public Graph<Page,DefaultEdge> getGraphe(){
        return this.graphe;
    }

    public void explorePage(Page page){
        page.afficheEnig();

        List<Page> possibilités = Graphs.successorListOf(this.graphe,page);

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



    

}
