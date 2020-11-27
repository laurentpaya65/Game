package org.epita.testgame;

import org.epita.anomalie.ValeurCarteAbsurdeException;
import org.epita.game.*;
import org.junit.jupiter.api.Test;
import org.epita.game.Pile;

import static org.assertj.core.api.Assertions.*;

public class TestDeck {

    @Test
    public void test_init_deck() {
        Deck deck   = new Deck();

        deck.init();

        for (int i = Pile.DEBUT_PILE_INITIALE; i < Pile.DEBUT_PILE_INITIALE + Pile.TAILLE_PILE_INITIALE; i++) {
            assertThat(deck.piocher()).isInstanceOf(Carte.class);
        }

        Throwable thrown = catchThrowable(() -> {deck.piocher();});
        assertThat(thrown).isInstanceOf(ValeurCarteAbsurdeException.class);

        deck.init();
    }
    @Test
    public void test_melanger_deck() {
        Deck deck   = new Deck();

        deck.init();

        for (int i = 0; i < 3; i++) {
            assertThat(deck.piocher()).isInstanceOf(Carte.class);
//            System.out.println(deck.piocher());
        }

        deck.init();
    }
}
