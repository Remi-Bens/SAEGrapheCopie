package fr.univorleans.iut45.SAEGraphe;

public class Affichage {
    

    public void Bienvenue(){
        System.out.println("Bienvenue dans Vivez l'Aventure");
        System.out.println("Explorez les différentes pages du livre, résolvez des énigmes, récupérez des objets indispensables et trouvez le chemin vers la sortie.");
        System.out.println("Etes vous prets à commencer l'aventure cher aventurier ?");
        String commande_brute = System.console().readLine();
        String commande = commande_brute.strip().toLowerCase();
        
    }

    public void (){
        System.out.println("");
    }
}
