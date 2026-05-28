package fr.univorleans.iut45.SAEGraphe;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Random random = new Random();

        Map<String,List<String>> enigmes = new HashMap<>();

        enigmes.put("Que dit un coq pour séduire une poule ?",List.of("T'as de beau yeux", "T'as un beau bec", "T'as de oeufs tu sais ?"));
        enigmes.put("À quelle heure, sur un radio-réveil au format 00:00, la somme de tous les chiffres est maximale ?",List.of("19:59", "23:59", "18:59", "12:59"));
        enigmes.put("Il y a un pere et un fils, à eux deux leurs âges est égal à 36 ans. Et le père à 30 ans de plus que le fils. Quel âge à le fils?", List.of("3 ans", "6 ans", "1 ans"));
        enigmes.put("Quest-ce qui est jaune et qui attend?",List.of("Rougeattend", "warning sur maven", "FFFF00", "Jonathan"));
        enigmes.put("De tout l'hiver, il est absent, il vient au milieu du printemps, il revient au cœur de l'été, en scrutant vers le O, en automne, vous le trouverez. qui est-il ?",List.of("Le T", "Le soleil", "Les feuilles"));
        enigmes.put("Un homme regarde une photo. Quelqu’un demande : “Qui regardez-vous ?” Il répond : “Je n’ai ni frère ni sœur, mais le père de cet homme est le fils de mon père.” Qui est sur la photo ?",List.of("Son père", "Son fils", "Lui-même enfant", "Son cousin"));
        enigmes.put("Un train electrique roule vers le nord et le vent va vers le sud. Dans quel direction va la fumée ?",List.of("Nul part", "Sud", "Nord", "Est", "Ouest"));
        enigmes.put("Que vaut 67 en binaire ?",List.of("1000011", "1000001", "1000101"));
        enigmes.put("Quel est la taille max d'un graphe planaire complet?",List.of("6", "7", "5", "3"));
        enigmes.put("Je commence par 'e'. Je finis par 'e'. Je contiens une lettre. Qui suis-je ?",List.of("Une enveloppe", "Ete", "E", "Enceinte"));
        enigmes.put("Je t' appartiens mais les autres m'utilisent plus que toi. Qui suis-je ?",List.of("Ton prénom", "Les connaissances", "Ta console"));
        enigmes.put("Qu'est-ce qui peut remplir tout un espace sans prendre de place ?",List.of("L'eau", "Le feu", "La lumière.", "La terre"));
        enigmes.put("Girafe = 3, Eléphant = 3, Hippopotame = 5, Lion = … ?",List.of("4", "3", "2", "1"));
        enigmes.put("Ma première lettre est un B, ma dernière un E. Je suis long, dur, je peux être droit mais la plupart du temps je ne le suis pas. Le gens me mangent souvent avec joie. Qui suis-je??",List.of("Carambar", "Baguette", "Banane"));
        enigmes.put("Je suis petit. Je suis carré. Je suis jaune. Qu'est-ce que je suis?",List.of("Un petit carré jaune","Une pomme de pin","Une meule de gruyère"));
        enigmes.put("Quel mot est toujours ecrit mal dans le dictionnaire?",List.of("Mal","Hippopotomonstrosesquippedaliophobie","Tractopelle"));
        enigmes.put("Un chasseur quitte sa maison, marche $1\text{ km}$ vers le Sud, puis $1\text{ km}$ vers l'Est, et enfin $1\text{ km}$ vers le Nord. Il se retrouve pile devant sa maison. Là, il voit un ours. De quelle couleur est l'ours ?",List.of("Blanc","Brun","Rouge"));
        enigmes.put("Si un avion s'écrase pile sur la frontière exacte entre la France et la Belgique, où enterre-t-on les survivants ?",List.of("En France","En Belgique","Enterrer des personnes vivantes est considéréé comme un meurtre en France comme en Belgique, donc on ne les enterre pas."));
        enigmes.put("Le père d'Antonio a 3 fils: Aymerico, Matteo et?",List.of("Remiggio","Antonio","Jean-François"));
        enigmes.put("Si je jette un caillou bleu dans la mer rouge, comment devient-il?",List.of("Violet","Noir","Mouillé"));
        enigmes.put("Je monte et je descends, et pourtant je ne bouge pas. Qui suis-je?",List.of("Un ascenseur en panne","Le prix de la salade sodebo du leclerc","Un escalier"));


        List<Page> l = new ArrayList<>();
        int cpt = 0;
        for(String enigme:enigmes.keySet()){

            
            l.add(new Page(cpt,enigme,enigmes.get(enigme), 0));

            cpt++;
        }

        System.out.println(cpt+" pages");

        /*or (Page page:l){
            System.out.println(page.afficheEnig());
        }*/

        GenerateurGraphe gen = new GenerateurGraphe();

        Graph<Page,DefaultEdge> graphos = gen.creation(l.size(), 10, l);

        System.out.println("creation terminee");

        System.out.println(graphos.edgeSet());

        for(Page page:graphos.vertexSet()){
            System.out.println(page.getFin()+" "+page);
        }

        AlgoLarge al = new AlgoLarge(graphos);
        System.out.println(al.start());
        
        

        //format: enigmes.put("enigme",List.of("rep1","rep2","rep3"));

        
        /* 
        Affichage a = new Affichage(false);
        a.Bienvenue();
        */
    }
}
