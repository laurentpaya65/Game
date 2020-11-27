package org.epita.testgame;

import org.epita.game.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestPlayer {

    @Test
    public void test_aquerir_nom() {
        Player joueur = new Player();
        joueur.acquerirNom();
        assertThat(joueur.getNom()).isEqualTo("Laurent");

    }
}

