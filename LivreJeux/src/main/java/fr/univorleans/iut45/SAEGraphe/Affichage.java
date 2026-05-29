package fr.univorleans.iut45.SAEGraphe;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Affichage {

    private Random r;
    private boolean fin;

    public Affichage(boolean fin){
        this.r = new Random();
        this.fin = false;
    }

    public boolean bienvenue(){
        System.out.println("(c)Chabini Corporation 2026 LTD - All rights reserved\n\n\n\n\n\nBienvenue dans Vivez l'Aventure");
        System.out.println("Explorez les différentes pages du livre, résolvez des énigmes, récupérez des objets indispensables et trouvez le chemin vers la sortie.");
        while (!fin){
            System.out.println("Etes vous prets à commencer l'aventure cher aventurier (O/N)?");
            String commande_brute = System.console().readLine();
            String commande = commande_brute.strip().toLowerCase();
            if (commande.equals("o")){
                return true;
            }
            else if (commande.equals("n")){
                return false;
            } else if (commande.equals("chabini")){
                System.out.println("""
                          ░██████  ░██                   ░██        ░██           ░██     ░██████                                                                   ░██    ░██                      
                        ░██   ░██  ░██                   ░██                             ░██   ░██                                                                  ░██                             
                        ░██        ░████████   ░██████   ░████████  ░██░████████  ░██   ░██         ░███████  ░██░████ ░████████   ░███████  ░██░████  ░██████   ░████████ ░██ ░███████  ░████████  
                        ░██        ░██    ░██       ░██  ░██    ░██ ░██░██    ░██ ░██   ░██        ░██    ░██ ░███     ░██    ░██ ░██    ░██ ░███           ░██     ░██    ░██░██    ░██ ░██    ░██ 
                        ░██        ░██    ░██  ░███████  ░██    ░██ ░██░██    ░██ ░██   ░██        ░██    ░██ ░██      ░██    ░██ ░██    ░██ ░██       ░███████     ░██    ░██░██    ░██ ░██    ░██ 
                        ░██   ░██  ░██    ░██ ░██   ░██  ░███   ░██ ░██░██    ░██ ░██    ░██   ░██ ░██    ░██ ░██      ░███   ░██ ░██    ░██ ░██      ░██   ░██     ░██    ░██░██    ░██ ░██    ░██ 
                        ░██████    ░██    ░██  ░█████░██ ░██░█████  ░██░██    ░██ ░██     ░██████   ░███████  ░██      ░██░█████   ░███████  ░██       ░███████      ░████ ░██ ░███████  ░██    ░██ 
                                                                                                                       ░██                                                                          
                                                                                                                       ░██                                                                          
                                                                                                                                                                                                     
                        """);
            }
            else{
                System.out.println("Votre saisie : '" + commande_brute + "' est incorrecte. Veuillez réesayer en écrivant 'O' (oui) ou 'N' (non)");
            }
        }
        return false;
        
    }
    
    public void erreur(String msg) {
        System.out.println("Erreur: "+msg);
    }

    public void affichePage(String textePage){
        List<String> narrations = new ArrayList<>();
        narrations.addAll(Arrays.asList("------------->\nVous entrez dans une nouvelle pièce.\nUne énigme est gravée au sol:\n","Après un éboulement partiel du tunnel, vous parvenez dans une petite pièce éclairée.\nQuel qu'un a écrit un texte à la hâte sur un mur:\n","Vous déboulez dans un vaste hall rempli de crânes humains!!\nC'est un coup de l'URSSAF, pour sûr.\nAu centre se trouve une table de pierre entourée de squelettes, avec\nune énigme et plusieurs boutons numérotés:\n","Un vieillard alcoolique vous attaque par derrière avec une bouteille de bière vide.\nVous vous enfuyez pour finalement vous cacher dans un placard , où une énigme est écrite:\n","Un homme douteux déguisé en minotaure vous propose d'apparaître dans ses vidéos YouTube.\nVous refusez et l'homme, furieux, vous enferme dans sa cave où plusieurs portes sont présentes, et une énigme:\n","Derrière un virage du chemin, vous tombez nez à nez avec une secte vénérant une brique de lait.\nIls acceptent de vous laisser passer si vous répondez à leur énigme:\n","En chemin, vous rencontrez un éboueur Irlandais en état d'Ivresse notable\nIl vous aborde et vous pose la question suivante:\n","Vous décidez de faire une courte sieste pour vous reposer.\n A votre réveil, vous vous trouvez à Fort Boyard, et un vieillard sénile vous pose la question suivante avec insistance:\n"));
        
        int choix = r.nextInt(narrations.size());
        System.out.println("\n\n\n\n"+narrations.get(choix)+"\n"+textePage);
    }

    public void arriveeFin(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n====================================================================================\nAprès une aventure aussi longue que difficile, il semble que vous soyez arrivés\nà la fin. Cependant, avez-vous trouvé tous les objets nécessaires??\n====================================================================================\n");
    }

    public void fin(){
        System.out.println("OUII!!! PSARTEK LES BG VOUS AVEZ REUSSI VOUS VOUS ENFUYEZ DE CE LABYRINTHE MAUDIT!!");
    }

    public void refusFin(){
        System.out.println("Ah non mon coco il t'en manque encore des objets là, va refaire un tour.");
    }

    public void objetTrouve(String objet){
        System.out.println("\n\n\n\n---------------------/!\\-------------------------\nVous trouvez au sol un artefact rare: "+objet+".\nUne sombre puissance en émane, vous décidez de le garder.\n-------------------------------------------------\n\n");
    }

    public boolean finale(){
        System.out.println("============================] FIN DE L'AVENTURE [=============================\nVotre aventure est terminé !");
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("A - Tester les algorithmes de parcours");
        System.out.println("B - Quitter\n==========================================================");
        String commande_brute = System.console().readLine();
        String commande = commande_brute.strip().toLowerCase();
            if (commande.equals("a")){
                return true;
            }

            else if (commande.equals("b")){
                System.out.println("\n\n\n\n\nA LA PROCHAINE POUR DE NOUVELLES AVENTURES !!!");
                System.out.println("Jeu vidéo indépendant réalisé par la Chabini Corporation");
                System.out.println("Produit par :");
                System.out.println("LEMARIO Matteo");
                System.out.println("FONTINI Antonio");
                System.out.println("BOULETTO CHOPINETTI Aymerico");
                System.out.println("BENSINI Remigio");
                System.out.println("Merci d'avoir joué.\n\n\n\n\n\nAppuyez sur [ENTREE]] pour continuer");
                commande_brute = System.console().readLine();
                System.out.println("Nous allons à présent passer aux tests des algorithmes de parcours.\nAppuyez sur [ENTREE] pour continuer...");
                commande_brute = System.console().readLine();
                return false;
            }
            
            else{
                System.out.println("Votre saisie : '" + commande_brute + "' est incorrecte.");
                return false;
            }

          
        
        

    }  


}
