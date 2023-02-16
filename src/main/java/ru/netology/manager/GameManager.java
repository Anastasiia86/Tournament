package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

public class GameTest {

    @Test
    public void shouldFirstBeLessThanSecond() {
        Game game = new Game();
        Player player1 = new Player(1, "Milana", 100);
        Player player2 = new Player(2, "Diego", 102);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Milana", "Diego");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFirstBeMoreThanSecond() {
        Game game = new Game();
        Player player1 = new Player(3, "Natalia", 110);
        Player player2 = new Player(2, "Diego", 102);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Natalia", "Diego");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldEqualPlayers() {
        Game game = new Game();
        Player player1 = new Player(3, "Natalia", 110);
        Player player2 = new Player(4, "Pedro", 110);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Natalia", "Pedro");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldGetId() {
        Game game = new Game();
        Player player1 = new Player(3, "Natalia", 110);
        game.register(player1);


        int expected = 3;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrow1() {
        Game game = new Game();
        Player player1 = new Player(3, "Natalia", 110);
        Player player2 = new Player(4, "Diego", 110);


        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Natalia", "Milana"));
    }

    @Test
    public void shouldThrow2() {
        Game game = new Game();
        Player player1 = new Player(3, "Mika", 110);
        Player player2 = new Player(4, "Diego", 110);


        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Natalia", "Diego"));
    }
}