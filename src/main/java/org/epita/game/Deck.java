package org.epita.game;

import org.epita.anomalie.PiocheVideException;
import org.epita.anomalie.ValeurCarteAbsurdeException;

import java.util.*;

import static org.epita.game.Pile.*;

public class Deck {
    private Deque<Carte> pioche = new ArrayDeque<>();
    private boolean deckVide = false;

    public void initDeck() {
        for (int i = DEBUT_PILE_INITIALE; i < DEBUT_PILE_INITIALE + TAILLE_PILE_INITIALE ; i++) {
            pioche.add(new Carte(i));
        }
        melanger();
    }
    public void melanger() {
        int taillePile = pioche.size();
        Carte[] tabCarte = new Carte[taillePile];

        for (int j = 0; j < taillePile; j++) {
            tabCarte[j] = pioche.poll();
        }
        int indPermut;
        Carte carte;
        for (int j = 0; j < tabCarte.length; j++) {
            indPermut = (int) (Math.random()*tabCarte.length);
//            System.out.println("indPermut="+indPermut);
            // permutation Indices  j  et indPermut
            carte = tabCarte[j];
            tabCarte[j] = tabCarte[indPermut];
            tabCarte[indPermut] = carte;
        }
        for (int j = 0; j < tabCarte.length; j++) {
            pioche.add(tabCarte[j]);
        }
    }
    public Carte piocher() {
        if (deckVide) {
            throw new PiocheVideException("la pioche est vide !!!");
        }
        Carte carte = pioche.pollFirst();
        if (pioche.size() == 0) {
            deckVide = true;
        }
        return carte;
    }

    public boolean isDeckVide() {
        return deckVide;
    }
    @Override
    public String toString() {
        String valeurString;
        if (pioche.size() > 9) {
            return "[[[" + pioche.size() + "]";
        }
        return "[[[0" + pioche.size() + "]";
    }

    public Deque<Carte> getPioche() {
        return pioche;
    }
}
