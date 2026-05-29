package fr.univorleans.iut45.SAEGraphe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.Random;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

import java.io.Serializable;

public class Graphe implements Serializable{
    
    private DefaultDirectedGraph<Page,DefaultEdge> graphe;
    private List<String> inventaire;
    private int inventaireTrouve;
    private Affichage affichage;

    public Graphe(){

        this.graphe = new DefaultDirectedGraph<>(DefaultEdge.class);
        
        this.inventaire = new ArrayList<>();
        this.inventaire.addAll(Arrays.asList("Table de routage","Abricot en plastique","Aspirateur laveur Dyson V15s Detect Submarine™","Clé USB suspecte","Copie physique du fameux jeu PC Splat IUT'O","Manuel d'utilisation de grille pain","Invariant de boucle","Lame d'Aragorn, fils d'Arathorn et héritier d'Isildur, pourfendeuse d'Orcs, reforgée par les Elfes pour vaincre Sauron","Script python nommé Anakin_v2.py","Barbecue electrique HIGH ONE HO-ELTAB4124\nl'étiquette est encore attachée, il semble avoir coûté 19€ chez Electro Depot","Fourchette","Marteau-piqueur","Documentation d'IJVM","Caillou stylé","iPhone 7","Salade Sodebo au thon","Conserve de Maïs","Bonbon crocodile à la framboise","Pied de biche","Article de la jurisprudence de la Cour de cassation de l'Assemblée plénière du 25 février 2000 n° 97-17.378"));

        this.inventaireTrouve = 0;

        this.affichage = new Affichage(false);
    }

    public Graphe(DefaultDirectedGraph graphe){

        this.graphe = graphe;
        
        this.inventaire = new ArrayList<>();
        this.inventaire.addAll(Arrays.asList("Table de routage","Abricot en plastique","Aspirateur laveur Dyson V15s Detect Submarine™","Clé USB suspecte","Copie physique du fameux jeu PC Splat IUT'O","Manuel d'utilisation de grille pain","Invariant de boucle","Lame d'Aragorn, fils d'Arathorn et héritier d'Isildur, pourfendeuse d'Orcs, reforgée par les Elfes pour vaincre Sauron","Script python nommé Anakin_v2.py","Barbecue electrique HIGH ONE HO-ELTAB4124\nl'étiquette est encore attachée, il semble avoir coûté 19€ chez Electro Depot","Fourchette","Marteau-piqueur","Documentation d'IJVM","Caillou stylé","iPhone 7","Salade Sodebo au thon","Conserve de Maïs","Bonbon crocodile à la framboise","Pied de biche","Article de la jurisprudence de la Cour de cassation de l'Assemblée plénière du 25 février 2000 n° 97-17.378"));


        this.inventaireTrouve = 0;

        this.affichage = new Affichage(false);
    }

    public Graphe(DefaultDirectedGraph graphe,List<String> inv,int invT){

        this.graphe = graphe;
        
        this.inventaire = inv;

        this.inventaireTrouve = invT;

        this.affichage = new Affichage(false);
    }

    public void oublierPages(){
        for (Page page:graphe.vertexSet()) {
            page.oublier();
        }
    }

    public void start(){

        if (affichage.bienvenue()) this.explorePage(this.premierePage());
        
    }

    public Graphe duplication(){
        DupliGraphe dup = new DupliGraphe();
        Graphe copie = new Graphe(dup.copie(this.graphe),this.inventaire,this.inventaireTrouve);
        return copie;
    }

    public boolean sauvegarde(String adresse){

        try{
            FileOutputStream fichier = new FileOutputStream(adresse);
            ObjectOutputStream obj = new ObjectOutputStream(fichier);

            obj.writeObject(this);

            obj.close();
            fichier.close();

            //System.out.println("terminado");

            return true;

        }catch (IOException e){
            System.err.println("La sauvegarde n'a pas fonctionné: "+e.getMessage());
        } 
        return false;
        
    }

    public boolean charger(String adresse){

        try{
            FileInputStream fichier = new FileInputStream(adresse); //lecture du truc
            ObjectInputStream obj = new ObjectInputStream(fichier);  //transcription

            Graphe sauveGraphe = (Graphe) obj.readObject();

            this.affichage = sauveGraphe.affichage;
            this.graphe = sauveGraphe.graphe;
            this.inventaire = sauveGraphe.inventaire;
            this.inventaireTrouve = sauveGraphe.inventaireTrouve;

            obj.close();
            fichier.close();

            return true;
        } catch (IOException e ) {
            System.err.println("Erreur lors du chargement: "+e.getMessage());
            
        } catch (ClassNotFoundException e2){
            System.err.println("Classe corrompue ou mal lue: "+e2.getMessage());
        }
        return false;
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
        return inventaireTrouve>=10;        //A REMETTRE A 10
    }

    public DefaultDirectedGraph<Page,DefaultEdge> getGraphe(){
        return this.graphe;
    }

    public void explorePage(Page page){
        System.out.println("\n\nPage "+page.getNum()+" - "+"objets trouvés: "+inventaireTrouve+"----------");
        List<Page> possibilites = Graphs.successorListOf(this.graphe,page);
        if (!page.getFin() && page.getNum()!=-1){ //just si pas la page finale

            

            if (page.getObjet()){
                affichage.objetTrouve(inventaire.get((int)System.currentTimeMillis()%inventaire.size()-1));
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
                if (!possibilites.isEmpty()) this.explorePage(possibilites.get(0));
                
            } else {
                affichage.refusFin();
                try{
                    this.explorePage(this.premierePage());
                } catch (PageNotFoundException e) {
                    System.err.println("Oula mon reuf ya pas de première page là");
                }
                
            }
            
        } 

    }



    

}
