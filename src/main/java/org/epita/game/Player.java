package org.epita.game;

import org.epita.anomalie.NotAValidPlayException;
import org.epita.anomalie.UnavailableCardException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player {
    private String nom;
    private UneMain uneMain = new UneMain();

    public Player(String nom, UneMain uneMain) {
        this.nom = nom;
        this.uneMain = uneMain;
    }

    public void jouerCarte(Carte carte) throws UnavailableCardException {
         uneMain.rechercherCarte(carte);
         uneMain.enleverCarte(carte);
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
}
