package fr.univorleans.iut45.SAEGraphe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.Random;

public class Graphe {
    
    private DefaultDirectedGraph<Page,DefaultEdge> graphe;
    private List<String> inventaire;
    private int inventaireTrouve;
    private Affichage affichage;

    public Graphe(){

        this.graphe = new DefaultDirectedGraph<>(DefaultEdge.class);
        
        this.inventaire = new ArrayList<>();
        this.inventaire.addAll(Arrays.asList("","","","","","Fourchette","Marteau-piqueur","Documentation d'IJVM","Caillou stylé","iPhone 7","Salade Sodebo au thon","Conserve de Maïs","Bonbon crocodile à la framboise","Pied de biche","Article de la jurisprudence de la Cour de cassation de l'Assemblée plénière du 25 février 2000 n° 97-17.378"));

        this.inventaireTrouve = 0;

        this.affichage = new Affichage(false);
    }

    public Graphe(DefaultDirectedGraph graphe){

        this.graphe = graphe;
        
        this.inventaire = new ArrayList<>();
        this.inventaire.addAll(Arrays.asList("","","","","","Fourchette","Marteau-piqueur","Documentation d'IJVM","Caillou stylé","iPhone 7","Salade Sodebo au thon","Conserve de Maïs","Bonbon crocodile à la framboise","Pied de biche","Article de la jurisprudence de la Cour de cassation de l'Assemblée plénière du 25 février 2000 n° 97-17.378"));


        this.inventaireTrouve = 0;

        this.affichage = new Affichage(false);
    }

    public void start(){
        this.explorePage(this.premierePage());
    }

    public Page premierePage() throws PageNotFoundException{
        for (Page page:graphe.vertexSet()) {
            if (page.getDeb()) {
                return page;
            }
        }
        throw new PageNotFoundException("Aucune première page trouvée ");
    }

    public boolean tousObjets(){
        return inventaireTrouve>=10;
    }

    public DefaultDirectedGraph<Page,DefaultEdge> getGraphe(){
        return this.graphe;
    }

    public void explorePage(Page page){
        System.out.println("objets trouvés: "+inventaireTrouve);
        List<Page> possibilites = Graphs.successorListOf(this.graphe,page);
        if (!page.getFin()){ //just si pas la page finale

            System.out.println("affichage de l'enigme");

            if (page.getObjet()){
                affichage.objetTrouve(inventaire.get(inventaireTrouve));
                this.inventaireTrouve++;
                page.setObjet(false);
            }

            affichage.affichePage(page.afficheEnig());


            String rep = System.console().readLine();
            if (rep.equals("0")) {
                this.explorePage(possibilites.get(0));
            }
            else if(rep.equals("1") && possibilites.size()>=2) {
                this.explorePage(possibilites.get(1));
            }
            else if(rep.equals("2") && possibilites.size()>=3) {
                this.explorePage(possibilites.get(2));
            }
            else if(rep.equals("3") && possibilites.size()>=4) {
                this.explorePage(possibilites.get(3));
            }
            else if(rep.equals("4") && possibilites.size()>=5) {
                this.explorePage(possibilites.get(4));
            }
            else {
                this.affichage.erreur("Veuillez entrer un caractère valide!");
                this.explorePage(page);
            }
        } else if (page.getNum()==-1){
            affichage.finale();
        } else {
        
            affichage.arriveeFin();
            if (this.tousObjets()) {
                affichage.fin();
                this.explorePage(possibilites.get(0));
            } else {
                affichage.refusFin();
                this.explorePage(possibilites.get(1));
            }
            
        } 

    }



    

}
