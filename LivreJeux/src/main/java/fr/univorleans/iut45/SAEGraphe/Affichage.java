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

    public void Bienvenue(){
        System.out.println("Bienvenue dans Vivez l'Aventure");
        System.out.println("Explorez les différentes pages du livre, résolvez des énigmes, récupérez des objets indispensables et trouvez le chemin vers la sortie.");
        while (!fin){
            System.out.println("Etes vous prets à commencer l'aventure cher aventurier (O/N)?");
            String commande_brute = System.console().readLine();
            String commande = commande_brute.strip().toLowerCase();
            if (commande.equals("o")){
                //démarrer la partie
            }
            else if (commande.equals("n")){
                fin = true;
            }
            else{
                System.out.println("Votre saisie : '" + commande_brute + "' est incorrecte. Veuillez réesayer en écrivant 'O' (oui) ou 'N' (non)");
            }
        }
        
    }
    public void erreur(String msg) {
        System.out.println("Erreur: "+msg);
    }

    public void affichePage(String textePage){
        List<String> narrations = new ArrayList<>();
        narrations.addAll(Arrays.asList("Vous entrez dans une nouvelle pièce.\n","Après un éboulement partiel du tunnel, vous parvenez dans une petite pièce éclairée.\n","Vous déboulez dans un vaste hall rempli de crânes humains!!\nC'est un coup de l'URSSAF, pour sûr.\n","Un vieillard alcoolique vous attaque par derrière avec une bouteille de bière vide.\nVous vous enfuyez pour finalement vous cacher dans un placard , où une énigme est écrite:\n","Un homme douteux déguisé en minotaure vous propose d'apparaître dans ses vidéos YouTube.\nVous refusez et l'homme, furieux, vous enferme dans sa cave où plusieurs portes sont présentes, et une énigme..\n"));
        
        int choix = r.nextInt(narrations.size());
        System.out.println("\n\n\n\n"+narrations.get(choix)+textePage);
    }

    public void arriveeFin(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nAprès une aventure aussi longue que difficile, il semble que vous soyez arrivés\nà la fin. Cependant, avez-vous trouvé tous les objets nécessaires??");
    }

    public void fin(){
        System.out.println("OUII!!! PSARTEK LES BG VOUS AVEZ REUSSI VOUS VOUS ENFUYEZ DE CE LABYRINTHE MAUDIT!!");
    }

    public void refusFin(){
        System.out.println("Ah non mon coco il t'en manque encore des objets là, va refaire un tour.");
    }

    public void objetTrouve(String objet){
        System.out.println("Vous trouvez au sol un artefact rare: "+objet+".\nUne sombre puissance en émane, vous décidez de le garder.\n");
    }
}
