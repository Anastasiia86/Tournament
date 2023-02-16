package ru.netology.manager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

public class GameTest {

    @Test
    public void shouldFirstBeLessThanSecond() {
        Game game = new Game();
        Player player1 = new Player(1, "Diana", 100);
        Player player2 = new Player(2, "Anna", 102);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Diana", "Anna");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFirstBeMoreThanSecond() {
        Game game = new Game();
        Player player1 = new Player(3, "Nikita", 110);
        Player player2 = new Player(2, "Anna", 102);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Nikita", "Anna");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldEqualPlayers() {
        Game game = new Game();
        Player player1 = new Player(3, "Nikita", 110);
        Player player2 = new Player(4, "Petr", 110);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Nikita", "Petr");

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
        Player player1 = new Player(3, "Nikita", 110);
        Player player2 = new Player(4, "Anna", 110);


        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Nikita", "Diana"));
    }

    @Test
    public void shouldThrow2() {
        Game game = new Game();
        Player player1 = new Player(3, "Marina", 110);
        Player player2 = new Player(4, "Anna", 110);


        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Nikita", "Anna"));
    }
}
