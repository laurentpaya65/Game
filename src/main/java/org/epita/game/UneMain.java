package org.epita.game;

import org.epita.anomalie.UnavailableCardException;

import java.util.HashMap;
import java.util.Map;

public class UneMain {
    private Map<Integer,Carte> uneMain = new HashMap<>();
    public final static int TAILLE_MAIN = 4;

    public void genererMain(Deck deck) {
        Carte carte;
        while (uneMain.size() < TAILLE_MAIN && !deck.isDeckVide()) {
            carte = deck.piocher();
            uneMain.put(carte.getValeur(),carte);
            System.out.println(carte);
        }
    }

    public Map<Integer, Carte> getMain() {
        return uneMain;
    }

    public boolean rechercherCarte(int valeur) throws  UnavailableCardException {
        if (!uneMain.containsKey(valeur)) {
           throw new UnavailableCardException("Carte non présente en main, rejouez");
        }
        return true;
    }

    public void enleverCarte(int valeur) throws UnavailableCardException {
        if (uneMain.containsKey(valeur)) {
            uneMain.remove(valeur);
        } else {
            throw new UnavailableCardException("Carte non présente en main, rejouez");
        }
    }

    public void afficheMain() {
        System.out.print("Main : ");
        for (Map.Entry<Integer,Carte> carte : uneMain.entrySet()) {
            System.out.print(carte.getValue().toString());
        }
        System.out.println("");
    }
}
