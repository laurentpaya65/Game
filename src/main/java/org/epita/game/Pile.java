package org.epita.game;

import org.epita.anomalie.NotAValidPlayException;

public class Pile {
    public final static int TAILLE_PILE_INITIALE = 11;
    public final static int DEBUT_PILE_INITIALE = 2;
    // 'A'=Ascendant , 'D'=Descendant
    private char sens;
    private Carte carteSurPile;

    public void initPile(char sens) {
        this.sens = sens;
        if (sens == 'A') {
            carteSurPile = new Carte(DEBUT_PILE_INITIALE - 1);
        } else {
            carteSurPile = new Carte(DEBUT_PILE_INITIALE + TAILLE_PILE_INITIALE);
        }
    }
    public Carte carteSurPile() {
        return carteSurPile;
    }

    public void ajouterCarteSurPile(Carte carte) throws NotAValidPlayException {
        if (!carteSurPilePossible(carte) ) {
                throw new NotAValidPlayException("Incohérent avec la Pile choisie , recommencez !");
        }
        carteSurPile = carte;
    }
    public boolean carteSurPilePossible(Carte carte) {
        if (sens == 'A') {
            if ( carte.getValeur() < carteSurPile.getValeur()
                    && ( carteSurPile.getValeur() - carte.getValeur() != 10 ) ) {
                return false;
            }
        }
        if (sens == 'D') {
            if (carte.getValeur() > carteSurPile.getValeur()
                    && ( carte.getValeur() - carteSurPile.getValeur() != 10 ) ) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return carteSurPile.toString();
    }
}
