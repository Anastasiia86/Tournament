package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameManagerTest {
    GameManager manager = new GameManager();
    Player playerOne = new Player(1, "Коля-победитель", 100);
    Player playerTwo = new Player(2, "Павел", 90);
    Player playerThree = new Player(3, "Игорь", 90);

    @BeforeEach
    void setup() {
        manager.register(playerOne);
        manager.register(playerTwo);
        manager.register(playerThree);
    }

    @Test
    void shouldFirstPlayerWin() {
        assertEquals(1, manager.round("Коля-победитель", "Павел"));
    }

    @Test
    void shouldSecondPlayerWin() {
        assertEquals(2, manager.round("Игорь", "Коля-победитель"));
    }

    @Test
    void shouldDraw() {
        assertEquals(0, manager.round("Игорь", "Павел"));
    }

    @Test
    void shouldThrowNotRegisteredExceptionOne() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("Коля-победитель", "Максим");
        });
    }

    @Test
    void shouldThrowNotRegisteredExceptionTwo() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("Максим", "Коля-победитель");
        });
    }
}