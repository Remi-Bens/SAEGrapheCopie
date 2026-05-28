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

    public DefaultDirectedGraph<Page,DefaultEdge> creation(int ordre,int nbObjets,List<Page> pages){

        DefaultDirectedGraph<Page,DefaultEdge> graphe = nuageDePoints(ordre, pages,nbObjets);

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
        Page sortie = new Page();
        graphe.addVertex(sortie);

        graphe.addEdge(fin,sortie);
        graphe.addEdge(fin,randomPageNotFin(pages)); //cas où les objets ne sont pas tous collectés

        System.out.println("graphe termine");
        return graphe;

    }

    private DefaultDirectedGraph<Page,DefaultEdge> nuageDePoints(int ordre,List<Page> pages,int objets){
        DefaultDirectedGraph<Page,DefaultEdge> graphe = new DefaultDirectedGraph<>(DefaultEdge.class);

        int objRestants = objets;

        while (graphe.vertexSet().size() < ordre) {
            Page choixPage = randomPage(pages);

            if (objets>0) choixPage.setObjet(true);
            objets --;

            graphe.addVertex(choixPage);
        }
        return graphe;
    }


    private Page randomPage(List<Page> liste) {
        return liste.get(this.choix.nextInt(liste.size()));
    }

    private Page randomPageNotFin(List<Page> liste) throws PageNotFoundException{
        int cpt = 0;
        while (cpt<100) {
            Page choix = randomPage(liste);
            if (!choix.getFin()) return choix;
            cpt ++;
        }
        throw new PageNotFoundException("Soit vous venez d'avoir la chance la plus improbable du millénaire, soit la liste ne contient que la fin.");
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