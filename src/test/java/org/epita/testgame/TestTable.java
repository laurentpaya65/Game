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

import static org.assertj.core.api.Assertions.*;

public class TestTable {


    @DisplayName("affichage de la Table")
    @Test
    public void test_generer_uneuneMain() {
        Table table = new Table();
        table.initPiles();

    }

    }
