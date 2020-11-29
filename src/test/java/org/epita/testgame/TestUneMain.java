package org.epita.testgame;

import org.epita.anomalie.UnavailableCardException;
import org.epita.anomalie.ValeurCarteAbsurdeException;
import org.epita.game.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.epita.game.Pile;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class TestUneMain {

    @DisplayName("rechercher une carte dans la Main")
    @Test
    public void test_rechercher_Carte() {
        Deck deck = new Deck();
        deck.initDeck();
        UneMain uneMain = new UneMain();
        uneMain.genererMain(deck);
        Map<Integer,Carte> carteMain = uneMain.getMain();
        for (Map.Entry<Integer,Carte> carte : carteMain.entrySet()){
            assertThat(uneMain.rechercherCarte(carte.getValue())).isTrue();
//            Throwable thrown = catchThrowable(() -> {uneMain.rechercherCarte(carte.getKey());});
//            assertThat(thrown).isNotInstanceOf(UnavailableCardException.class);
        }
    }
    @Test
    public void test_remove_Carte() {
        Deck deck = new Deck();
        UneMain uneMain = new UneMain();
        deck.initDeck();
        uneMain.genererMain(deck);
        Map<Integer,Carte> carteMain = new HashMap<>(uneMain.getMain());
        for (Map.Entry<Integer,Carte> carte : carteMain.entrySet()) {
//            System.out.println(carte);
            uneMain.enleverCarte(carte.getValue());
        }
        for (Map.Entry<Integer,Carte> carte : carteMain.entrySet()) {
//            System.out.println(carte);
            Throwable thrown = catchThrowable(() -> {uneMain.rechercherCarte(carte.getValue());});
            assertThat(thrown).isInstanceOf(UnavailableCardException.class);
        }
    }

}
