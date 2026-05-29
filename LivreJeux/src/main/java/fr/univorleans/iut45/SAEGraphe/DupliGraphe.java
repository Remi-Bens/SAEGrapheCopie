package fr.univorleans.iut45.SAEGraphe;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.HashMap;
import java.util.Map;

public class DupliGraphe {

    public DefaultDirectedGraph<Page,DefaultEdge> copie(DefaultDirectedGraph<Page,DefaultEdge> graphe){

        DefaultDirectedGraph<Page,DefaultEdge> cop = new DefaultDirectedGraph<Page,DefaultEdge>(DefaultEdge.class);

        Map<Page,Page> lienSommets = new HashMap<>();

        for (Page anciennePage:graphe.vertexSet()){
            Page nouvellePage = new Page(anciennePage);

            lienSommets.put(anciennePage,nouvellePage);

            cop.addVertex(nouvellePage);
        }

        for (DefaultEdge ancienneArete:graphe.edgeSet()){

            Page ancienneDebut = graphe.getEdgeSource(ancienneArete);
            Page ancienneFin = graphe.getEdgeTarget(ancienneArete);

            Page nouveauDebut = lienSommets.get(ancienneDebut);
            Page nouvelleFin = lienSommets.get(ancienneFin);

            cop.addEdge(nouveauDebut,nouvelleFin);

        }

        return cop;
    }
}