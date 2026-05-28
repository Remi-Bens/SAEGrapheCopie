package fr.univorleans.iut45.SAEGraphe;


import java.util.ArrayList;
import java.util.List;

import java.util.Random;
import java.util.Vector;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class GenerateurGraphe {

    private Random choix = new Random();

    public Graph<Page,DefaultEdge> creation(int ordre,int nbObjets,List<Page> pages){

        Graph<Page,DefaultEdge> graphe = nuageDePoints(ordre, pages);

        randomPage(new ArrayList<>(graphe.vertexSet())).setDeb(); //on met une carte aléatoire en début

        Page fin = randomPage(new ArrayList<>(graphe.vertexSet()));

        if (!fin.getDeb()) fin.setFin();

        System.out.println(fin);

        System.out.println(fin.getFin());


        for (Page page:graphe.vertexSet()) {
            if (!page.getFin()){
                int tentatives = 0;
                while ((page.getNbReponses()>graphe.outDegreeOf(page)) && tentatives<100){
                    try {
                        
                        graphe.addEdge(page,randomPage(new ArrayList<>(graphe.vertexSet())));
                        
                        tentatives ++;
                    } catch (NoJoinablePageException e){
                        System.err.println("Erreur: "+e.getMessage());
                        break;
                    }
                    
                }
                

            }

        }

        System.out.println("graphe termine");
        return graphe;

    }

    private Graph<Page,DefaultEdge> nuageDePoints(int ordre,List<Page> pages){
        Graph<Page,DefaultEdge> graphe = new DefaultDirectedGraph<>(DefaultEdge.class);

        while (graphe.vertexSet().size() < ordre) {
            graphe.addVertex(randomPage(pages));
        }
        System.out.println(graphe.vertexSet()+"\n\n\n nuage de points généré");
        return graphe;
    }


    private Page randomPage(List<Page> liste) {
        return liste.get(this.choix.nextInt(liste.size()));
    }

    /*private Page randomPageJoinable(List<Page> liste) throws NoJoinablePageException{
        if (liste.size()>1) {
            boolean found = false;
            while (!found) {
                Page choix = randomPage(liste);
                if (!choix.getDeb()) {
                    return choix; 
                }
            }
        } else if (liste.size()==1) {
            if (!liste.get(0).getDeb()){
                return liste.get(0);
            } else{
                throw new NoJoinablePageException("La liste ne contient qu'un début");
            }
        }
        throw new NoJoinablePageException("La liste est vide");
        
    }*/


}