package org.epita.game;

public class main {
    public static void main(String[] args) {
        Game jeu = new Game();

        jeu.initierJeu();

        while (!jeu.finPartie()) {
            while (!jeu.finTour()) {
                jeu.tourJoueur();
            }
            if (!jeu.finPartie()) {
                jeu.passerJoueurSuivant();
            }
        }
    }
}

