package fr.univorleans.iut45.SAEGraphe;


import java.util.ArrayList;
import java.util.List;

import java.util.Random;
import java.util.Vector;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;

public class GenerateurGraphe {
    public Graph<Page> creation(int ordre,int nbObjets,List<Page> pages){
        Graph<Page> graphe = nuageDePoints(ordre, pages);
        return graphe;

    }

    private Graph<Page> nuageDePoints(int ordre,List<Page> pages){
        Graph<Page> graphe = new DefaultDirectedGraph<>();

        Random choix = new Random();
        for (int i=0;i<ordre;i++) {
            graphe.addVertex(pages.get(choix.nextInt(pages.size()))); // remplacer i par random
        }
        return graphe;
    }
}