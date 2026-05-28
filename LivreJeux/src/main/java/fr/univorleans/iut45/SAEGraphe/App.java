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
        enigmes.put("Un chasseur quitte sa maison, marche 1 km vers le Sud, puis 1 km vers l'Est, et enfin 1 km vers le Nord. Il se retrouve pile devant sa maison. Là, il voit un ours. De quelle couleur est l'ours ?",List.of("Blanc","Brun","Rouge"));
        enigmes.put("Si un avion s'écrase pile sur la frontière exacte entre la France et la Belgique, où enterre-t-on les survivants ?",List.of("En France","En Belgique","Enterrer des personnes vivantes est considéréé comme un meurtre en France comme en Belgique, donc on ne les enterre pas."));
        enigmes.put("Le père d'Antonio a 3 fils: Aymerico, Matteo et?",List.of("Remiggio","Antonio","Jean-François"));
        enigmes.put("Si je jette un caillou bleu dans la mer rouge, comment devient-il?",List.of("Violet","Noir","Mouillé"));
        enigmes.put("Je monte et je descends, et pourtant je ne bouge pas. Qui suis-je?",List.of("Un ascenseur en panne","Le prix de la salade sodebo du leclerc","Un escalier"));

        enigmes.put("On envoie un ARP who has sur votre machine. Quelle est l'adresse de destination ?", List.of("1A:2B:3C:4D:5E", "FF:FF:FF:FF:FF", "00:00:00:00:00"));
        enigmes.put("Plus j'ai de gardiens, moins je suis gardé. Qui suis-je ?", List.of("Un secret", "Une clé", "De l'argent"));
        enigmes.put("Qu'est-ce qui a des dents, mais ne mange pas ?",List.of("Un peigne", "Le soleil", "un Sèche cheveux"));
        enigmes.put("Je commence la nuit et je termine le matin. Qui suis-je ?",List.of("Le N ","Le soleil","La rosée du matin"));
        enigmes.put("Quelle est la lettre préférée des bûcherons ?",List.of("Le H ","Le A ","Le B "));
        enigmes.put("Quelle est la monnaie des poissons ?",List.of("L'argent", "Le sous marin","Le chou marin"));
        enigmes.put("Qu'est-ce qu'un hippopotame qui fait du camping ?",List.of("Un rhinocerose", "Un singe", "Un hippocampe"));
        enigmes.put("Quel est le comble pour un Prof de maths ?",List.of("D'avoir trop de problèmes","De ne pas savoir faire des graphes","De ne pas connaitre Pythagore"));
        enigmes.put("Quel est le juron préféré des vampires ?",List.of("Dieux merci !","Bon sang !","OMG !"));
        enigmes.put("Qu’est-ce qui est plus grand que la Tour Eiffel, mais infiniment moins lourd ?",List.of("La muraille de Chine", "Le soleil", "Son ombre"));
        enigmes.put("Qu’est-ce qui est plein de trous mais arrive quand même à retenir l’eau ?",List.of("Un nid de poule", "Un fromage", "Une éponge"));
        enigmes.put("C’est le jour de la paie. La poule reçoit 7 €, l’abeille 21 €, l’araignée 28 €. Combien reçoit le chien ?",List.of("7 €", "2,50 €", "100 €", "14 €", "4,50 €"));
        enigmes.put("Jean-Luc est un jeune homme mineur de 17 ans, doté d'une nationalité canadienne ainsi que d'un visa en règle pour la France.\nIl se fait abattre par tir à balles par un terroriste suédois\nlors de sa montée à bord d'un train SNCF alors qu'il est muni d'un titre de transport valide.\nQuelles règles juridiques s'appliquent dans cette situation?",List.of("Article L126-1 du Code des assurances, Livre Ier, Titre II, Chapitre VI : L'assurance des risques de catastrophes technologiques et l'indemnisation des victimes d'actes de terrorisme","Article 1231-1 du Code civil, Livre III, Titre III, Sous-titre Ier, Chapitre IV, Section 3, Sous-section 1 : Les dommages et intérêts en cas d'inexécution de l'obligation","Cour de cassation, Assemblée plénière, 25 février 2000, n° 97-17.378"));
        enigmes.put("On peut me trouver au fond d’un bateau de pêche ou au milieu d’un court de tennis. Qui suis-je ?",List.of("une balle", "un filet", "Un joueur"));
        enigmes.put("Combien de gouttes d’eau peut-on mettre dans un verre vide ?",List.of("1", "100", "500", "10"));
        enigmes.put("Sans moi Paris serait pris. Qui suis je ? ",List.of("Le gouvernement", "L'armée", "Le a", "Charles de Gaulle"));
        enigmes.put("Je suis à l'abri et cependant toujours humide. Qui suis je ? ",List.of("Mon pied", "Mon nez", "Ma langue"));
        enigmes.put("Certains mois ont 30 jours, d'autres en ont 31. Combien de mois ont 28 jours ?",List.of("12", "1", "0", "10"));
        enigmes.put("Quel nombre suit cette suite logique : 1-11-21-1211-111221-?",List.of("99999", "212211", "312211"));
        enigmes.put("Quel nombre suit cette suite logique : 2-6-12-20-30-?", List.of("40", "36", "42", "0"));
        enigmes.put("Comment appelle-t-on les habitants de la Papouasie-Nouvelle-Guinée?", List.of("Les papous", "les papouillous", "Les papas", "Les papouasiens"));

        List<Page> l = new ArrayList<>();
        int cpt = 0;
        for(String enigme:enigmes.keySet()){

            
            l.add(new Page(cpt,enigme,enigmes.get(enigme), 0));

            cpt++;
        }

    

        GenerateurGraphe gen = new GenerateurGraphe();

        DefaultDirectedGraph<Page,DefaultEdge> graphos = gen.creation(l.size(), 15, l);

        for(Page page:graphos.vertexSet()){ //debug des pages par numero
            System.out.println(page.getFin()+" "+page);
        }



        Graphe parcoursGraphe = new Graphe(graphos);

        parcoursGraphe.start();

        /*AlgoLarge al = new AlgoLarge(graphos);
        System.out.println(al.start());*/
        
        

        //format: enigmes.put("enigme",List.of("rep1","rep2","rep3"));

        
        /* 
        Affichage a = new Affichage(false);
        a.Bienvenue();
        */
    }
}
