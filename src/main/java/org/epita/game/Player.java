package org.epita.game;

import java.util.Scanner;

public class Player {
    String nom;

     public void acquerirNom() {
        System.out.println("Veuillez entrer votre nom :\n");
        Scanner sc = new Scanner(System.in);
        nom = sc.next(); //C'est cette instruction qui laisse la main à l'utilisateur
    }

    @Override
    public String toString() {
        return nom;
    }

    public String getNom() {
        return nom;
    }
}
