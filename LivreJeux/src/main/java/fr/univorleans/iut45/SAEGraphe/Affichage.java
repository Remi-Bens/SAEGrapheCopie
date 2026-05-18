package fr.univorleans.iut45.SAEGraphe;

public class Affichage {
    private boolean fin;

    public Affichage(boolean fin){
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

}
