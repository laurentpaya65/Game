package org.epita.game;

import org.epita.anomalie.ValeurCarteAbsurdeException;

public class Carte {
    private int valeur;
    private Carte carte;

    public Carte(int valeur)  {
        if (valeur < 1 || valeur > 99) {
            throw new ValeurCarteAbsurdeException("valeur de carte incoherente !");
        }
        this.valeur = valeur;
    }

    public Carte getCarte() {
        return this.carte;
    }

    public int getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        String valeurString;
        if (valeur > 9) {
            return "[" + valeur + "]";
        }
        return "[0" + valeur + "]";
    }
}
