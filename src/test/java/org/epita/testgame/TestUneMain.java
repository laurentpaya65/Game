package org.epita.testgame;

import org.epita.anomalie.UnavailableCardException;
import org.epita.anomalie.ValeurCarteAbsurdeException;
import org.epita.game.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.epita.game.Pile;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TestUneMain {

    @RepeatedTest(3)
    public void test_generer_uneuneMain() {
        Deck deck = new Deck();
        UneMain uneMain = new UneMain();

        deck.init();
        uneMain.genererMain(deck);

        assertThat(uneMain.getMain().size()).isEqualTo(4);

        deck.init();
    }
    @Test
    public void test_rechercher_Carte() {
        Deck deck = new Deck();
        UneMain uneMain = new UneMain();

        deck.init();
        Carte carte = deck.piocher();
        uneMain.genererMain(deck);

        assertThat(uneMain.rechercherCarte(2)).isTrue();

        Throwable thrown = catchThrowable(() -> {uneMain.rechercherCarte(carte.getValeur());});
        assertThat(thrown).isInstanceOf(UnavailableCardException.class);

        deck.init();
    }
    @ParameterizedTest
    @ValueSource(ints = {2,3,4,7})
    public void test_remove_Carte(int valeur) {
        Deck deck = new Deck();
        UneMain uneMain = new UneMain();

        deck.init();
        uneMain.genererMain(deck);

        if (uneMain.rechercherCarte(valeur)) {
            System.out.println(uneMain.jouerCarte(valeur));
        }

        Throwable thrown = catchThrowable(() -> {uneMain.rechercherCarte(valeur);});
        assertThat(thrown).isInstanceOf(UnavailableCardException.class);

        deck.init();
    }

}
