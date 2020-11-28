package org.epita.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player {
    private String nom;
    private UneMain uneMain = new UneMain();

    public void jouerCarte(int valeur) throws Exception {
         uneMain.rechercherCarte(valeur);
         uneMain.enleverCarte(valeur);
    }
    @Override
    public String toString() {
        return nom;
    }

    public String getNom() {
        return nom;
    }

    public UneMain getUneMain() {
        return uneMain;
    }

    public void creerJoueur(String nom,Deck deck) {
         this.nom = nom;
         uneMain.genererMain(deck);
    }
}
