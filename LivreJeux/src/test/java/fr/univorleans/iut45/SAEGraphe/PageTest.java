package fr.univorleans.iut45.SAEGraphe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PageTest {
    @Test
    public void testgetNumPage(){
        Page a = new Page(1, "Que dit un coq pour séduire une poule ?");
        assertEquals(1, a.getNum());
    }

    @Test
    public void testgetTexte(){
        Page a = new Page(1, "Que dit un coq pour séduire une poule ?");
        assertEquals("Que dit un coq pour séduire une poule ?", a.getTexte());
    }
    @Test
    public void testgetEnigme(){
        List<String> enig = new ArrayList<>();
        enig.add("Le soleil");
        enig.add("La lune");
        Page a = new Page(1,  "Que dit un coq pour séduire une poule ?",enig);
        assertEquals("Que dit un coq pour séduire une poule ?\n0 : Le soleil\n1 : La lune\n", a.afficheEnig());
    }
}
