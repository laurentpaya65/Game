package org.epita.game;

public class Pile {
    public final static int TAILLE_PILE_INITIALE = 6;
    public final static int DEBUT_PILE_INITIALE = 2;
    // 'A'=Ascendant , 'D'=Descendant
    private char sens;
    private Carte carteSurPile;

    public void initPile(char sens) {
        if (sens == 'A') {
            carteSurPile = new Carte(1);
        } else {
            carteSurPile = new Carte(99);
        }
    }

}
