package org.epita.testgame;

import org.epita.game.Deck;
import org.epita.game.Game;
import org.epita.game.Player;
import org.epita.game.UneMain;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestPlayer {

    @Test
    public void test_creer_joueur() {
        Deck deck = new Deck();
        deck.initDeck();
        UneMain mainJoueur = new UneMain();
        mainJoueur.genererMain(deck);
        Player joueur = new Player("Laurent",mainJoueur);
        assertThat(joueur.getNom()).isEqualTo("Laurent");
    }
}

