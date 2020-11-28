package org.epita.testgame;

import org.epita.anomalie.NotAValidPlayException;
import org.epita.anomalie.ValeurCarteAbsurdeException;
import org.epita.game.Carte;
import org.epita.game.Pile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TestPile {

    @Test
    public void test_init_pile() {
        Pile pileA = new Pile();
        Pile pileD = new Pile();
        pileA.initPile('A');
        pileD.initPile('D');
        assertThat(pileA.carteSurPile().toString()).isEqualTo("[01]");
        assertThat(pileD.carteSurPile().toString()).isEqualTo("[08]");
    }
    @DisplayName("ajout carte correct pile ascendante")
    @Test
    public void test_ajouter_carte_pileA() {
        Pile pile = new Pile();
        pile.initPile('A');
        Carte carte1 = new Carte(2);
        Carte carte2 = new Carte(12);
        Carte carte3 = new Carte(2);
        pile.ajouterCarteSurPile(carte1);
        pile.ajouterCarteSurPile(carte2);
        pile.ajouterCarteSurPile(carte3);
    }
    @DisplayName("ajout carte correct pile descendante")
    @Test
    public void test_ajouter_carte_pileD() {
        Pile pile = new Pile();
        pile.initPile('D');
        Carte carte1 = new Carte(2);
        Carte carte2 = new Carte(12);
        Carte carte3 = new Carte(9);
        pile.ajouterCarteSurPile(carte1);
        pile.ajouterCarteSurPile(carte2);
        pile.ajouterCarteSurPile(carte3);
    }
    @DisplayName("ajout carte ERREUR pile ascendante")
    @Test
    public void test_ajouter_carte_pileA_erreur() {
        Pile pile = new Pile();
        pile.initPile('A');
        Carte carte1 = new Carte(10);
        Carte carte2 = new Carte(9);
        pile.ajouterCarteSurPile(carte1);
        Throwable thrown = catchThrowable(() -> {pile.ajouterCarteSurPile(carte2);});
        assertThat(thrown).isInstanceOf(NotAValidPlayException.class);
    }
    @DisplayName("ajout carte ERREUR pile descendante")
    @Test
    public void test_ajouter_carte_pileD_erreur() {
        Pile pile = new Pile();
        pile.initPile('D');
        Carte carte1 = new Carte(5);
        Carte carte2 = new Carte(9);
        pile.ajouterCarteSurPile(carte1);
        Throwable thrown = catchThrowable(() -> {pile.ajouterCarteSurPile(carte2);});
        assertThat(thrown).isInstanceOf(NotAValidPlayException.class);
    }
}
