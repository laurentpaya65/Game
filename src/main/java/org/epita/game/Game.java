package org.epita.game;

import org.epita.anomalie.NotAValidPileException;
import org.epita.anomalie.NotAValidPlayException;
import org.epita.anomalie.UnavailableCardException;

import java.util.*;

public class Game {
    private Deck deck = new Deck();
    private List<Player> joueurs = new LinkedList<>();
    private Table table = new Table();
    private int joueurCourant = 0;
    private boolean deckVide = false;
    private int carte;
    private int pileCourante;
    private String nom = "";
    private String reponse = "";
    private boolean demandeFinTour = false;
    private boolean finTour = false;
    private boolean finPartie = false;
    private int nbCarteJoue =0;
    private UneMain mainJoueur = new UneMain();

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

    public boolean finPartie() {
        return finPartie;
    }
    public boolean finTour() {
        return finTour;
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
                try {
                    jouerCarte(carte);
                } catch (NotAValidPlayException e) {
                    System.out.println("carte jouée invalide");;
                } catch (NotAValidPileException e) {
                    System.out.println("carte sur Pile invalide");;
                } catch (UnavailableCardException e ) {
                    System.out.println("carte non présente en main, rejouez");
                }
            }
        }
    }
    public void initierJeu() {
        table.initPiles();
        deck.initDeck();
        while (!nom.matches("FIN") ) {
            acquerirNom();
            if (!nom.matches("FIN")) {
                joueurs.add(new Player(nom, deck));
            }
        }
    }
    public boolean controlerJoueurPeutJouer() {
        Map<Integer,Carte> cartesMain = new HashMap<>(joueurs.get(joueurCourant).getUneMain().getMain());
        for (Map.Entry<Integer,Carte> uneCarte : cartesMain.entrySet()) {
            for (int i = 1; i < 5; i++) {
                if (table.testerPiles(uneCarte.getValue())) {
                    return true;
                };
            }
        }
        return false;
    }
    public boolean controlerReponse() {
        if (!acquerirCartePile() && deckVide && nbCarteJoue < 1) {
            System.out.println("Vous devez jouer encore une carte");
            return false;
        }
        if (!acquerirCartePile() && !deckVide && nbCarteJoue < 2) {
            System.out.println("Vous devez jouer encore une carte");
            return false;
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
        return true;
    }

    public void acquerirNom() {
        System.out.println("Veuillez entrer votre nom ou FIN :\n");
        Scanner sc = new Scanner(System.in);
        nom = sc.next(); //C'est cette instruction qui laisse la main à l'utilisateur
    }
    public void jouerCarte(int valeur) throws NotAValidPlayException , NotAValidPileException , UnavailableCardException {
        joueurs.get(joueurCourant).jouerCarte(valeur);
        table.carteSurPile(pileCourante,new Carte(valeur).getCarte());
        nbCarteJoue = nbCarteJoue + 1;
        finTour = true;
    }
    public void piocher() {
        if (!deckVide) {
            joueurs.get(joueurCourant).getUneMain().genererMain(deck);
        }
        if (deck.isDeckVide()) {
            deckVide = true;
        }
    }

}
