package fr.univorleans.iut45.SAEGraphe;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Page> l = new ArrayList<>();
        for(int i = 0; i< 100; i++){
            l.add(new Page(i, " ", null, 0));
        }
        Affichage a = new Affichage(false);
        a.Bienvenue();
    }
}
