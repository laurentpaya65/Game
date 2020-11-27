package org.epita.testgame;

import org.epita.anomalie.ValeurCarteAbsurdeException;
import org.epita.game.Carte;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestCarte {

    @Test
    public void test_carte() {
        assertThat(new Carte(10)).hasToString("[10]");
        assertThat(new Carte(02)).hasToString("[02]");

        Throwable thrown = catchThrowable(() -> {new Carte(99);});
        assertThat(thrown).isInstanceOf(ValeurCarteAbsurdeException.class);
    }
}
