package org.epita.game;

import java.util.*;

public class Game {
    Deck deck = new Deck();
    List<Player> joueurs = new LinkedList<>();
    Table table = new Table();
    int joueurCourant = 0;
    boolean deckVide = false;
    int carte;
    int pileCourante;
    String nom = "";
    String reponse = "";
    boolean demandeFinTour = false;
    boolean finTour = false;
    boolean finPartie = false;
    int nbCarteJoue =0;

    public void passerJoueurSuivant() {
        if (joueurCourant < joueurs.size()) {
            joueurCourant = joueurCourant + 1;
        } else {
            joueurCourant = 0;
        }
        demandeFinTour = false;
        finTour = false;
        finPartie = false;
        nbCarteJoue =0;
    }

    public void tourJoueur() {
        table.afficherTable(joueurs.get(joueurCourant));
        if (!controlerJoueurPeutJouer()) {
            System.out.println(joueurs.get(joueurCourant).getNom()+" a perdu la partie !" );
            finPartie = true;
        } else {
            while (!controlerReponse()) {
                continue;
            };
            if (finTour) {
                piocher();
            } else {
                jouerCarte(carte);
                table.carteSurPile(pileCourante,new Carte(carte).getCarte(carte));
            }

        }
    }
    public void initierJeu() {
        while (!nom.matches("FIN") ) {
            acquerirNom();
            joueurs.add(new Player(nom,deck));
        }
        table.initPiles();
        deck.initDeck();
    }
    public boolean controlerJoueurPeutJouer() {
        Map<Integer,Carte> carteMain = new HashMap<>(joueurs.get(joueurCourant).getUneMain());
        for (Map.Entry<Integer,Carte> carte : carteMain.entrySet()) {
            for (int i = 1; i < 5; i++) {
                if (table.testerPiles(new Carte(carte).getCarte(carte))) {
                    return true;
                };
            }
        }
        return false;
    }
    public boolean controlerReponse() {
        if (!acquerirCartePile() && deckVide && nbCarteJoue < 1) {
            System.out.println("Vous devez jouer encore");
            return false
        }
        if (!acquerirCartePile() && !deckVide && nbCarteJoue < 2) {
            System.out.println("Vous devez jouer encore");
            return false
        }
        if (reponse.matches("FIN")) {
            finTour = true;
        }
        return true;
    }
    public boolean acquerirCartePile() {
        reponse = "";
        while (!reponse.matches("[0-9](1,2)?|FIN")) {
            System.out.println("Veuillez entrer une carte ou FIN :\n");
            Scanner sc = new Scanner(System.in);
            reponse = sc.next(); //C'est cette instruction qui laisse la main à l'utilisateur
        }
        if (reponse.matches("FIN")) {
            return false;
        } else {
            carte = Integer.parseInt(reponse);
            return acquerirPile();
        }
    }
    public boolean acquerirPile() {
        reponse = "";
        while (!reponse.matches("[1-4](1)?")) {
            System.out.println("Veuillez entrer une pile :\n");
            Scanner sc = new Scanner(System.in);
            reponse = sc.next(); //C'est cette instruction qui laisse la main à l'utilisateur
        }
        if (reponse.matches("FIN")) {
            return false;
        } else {
            pileCourante = Integer.parseInt(reponse);
        }
        return true
    }

    public void acquerirNom() {
        System.out.println("Veuillez entrer votre nom ou FIN :\n");
        Scanner sc = new Scanner(System.in);
        nom = sc.next(); //C'est cette instruction qui laisse la main à l'utilisateur
        return nom;
    }
    public void jouerCarte(int valeur) {
        joueurs.get(joueurCourant).jouerCarte(valeur);
        table.carteSurPile(pileCourante,new Carte(valeur).getCarte(valeur));
        nbCarteJoue = nbCarteJoue + 1;
    }
    public void piocher() {
        if (!deckVide) {
            joueurs.get(joueurCourant).getUneMain().genererMain(deck);
        }
        if (deck.isDeckVide()) {
            deckVide = true
        }
    }

}
