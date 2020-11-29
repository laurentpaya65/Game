package org.epita.game;

import org.epita.anomalie.NotAValidPileException;

public class Table {
    private Pile pileAsc1 = new Pile();
    private Pile pileAsc2 = new Pile();
    private Pile pileDsc1 = new Pile();
    private Pile pileDsc2 = new Pile();
    private Player joueurCourant;

    public void initPiles() {
        pileAsc1.initPile('A');
        pileAsc2.initPile('A');
        pileDsc1.initPile('D');
        pileDsc2.initPile('D');
    }

    public void afficherTable(Player joueurCourant) {
        System.out.println("Piles ascendantes  1-2 : "+pileAsc1.carteSurPile().toString()+pileAsc2.carteSurPile().toString());
        System.out.println("Piles descendantes 3-4 : "+pileDsc1.carteSurPile().toString()+pileDsc2.carteSurPile().toString());
        joueurCourant.getUneMain().afficheMain();
    }

    public void carteSurPile(int pile,Carte carte) throws NotAValidPileException {
        if (pile < 1 || pile > 4) {
            throw new NotAValidPileException("cette Pile n'existe pas !");
        }
        if (pile == 1) {
            pileAsc1.ajouterCarteSurPile(carte);
        }
        if (pile == 2) {
            pileAsc2.ajouterCarteSurPile(carte);
        }
        if (pile == 3) {
            pileDsc1.ajouterCarteSurPile(carte);
        }
        if (pile == 4) {
            pileDsc2.ajouterCarteSurPile(carte);
        }

    }
    public boolean testerPiles(Carte carte) {
        if (    !pileAsc1.carteSurPilePossible(carte)
            || !pileAsc2.carteSurPilePossible(carte)
            || !pileDsc1.carteSurPilePossible(carte)
            || !pileDsc2.carteSurPilePossible(carte) ) {
            return false;
        }
        return true;
    }
}
