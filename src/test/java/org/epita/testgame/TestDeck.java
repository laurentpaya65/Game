package org.epita.testgame;

import org.epita.anomalie.ValeurCarteAbsurdeException;
import org.epita.game.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.epita.game.Pile;

import static org.assertj.core.api.Assertions.*;

public class TestDeck {

    @DisplayName("test de la bonne initialisation du Deck")
    @Test
    public void test_init_deck() {
        Deck deck = new Deck();
        deck.initDeck();
        assertThat(deck.getPioche().size()).isEqualTo(Pile.TAILLE_PILE_INITIALE);
    }
    @DisplayName("test que PIOCHER vide le deck")
    @Test
    public void test_piocher_carte() {
        Deck deck   = new Deck();
        deck.initDeck();
        for (int i = Pile.DEBUT_PILE_INITIALE; i < Pile.DEBUT_PILE_INITIALE + Pile.TAILLE_PILE_INITIALE; i++) {
            assertThat(deck.piocher()).isInstanceOf(Carte.class);
        }
        Throwable thrown = catchThrowable(() -> {deck.piocher();});
        assertThat(thrown).isInstanceOf(ValeurCarteAbsurdeException.class);
    }

}
