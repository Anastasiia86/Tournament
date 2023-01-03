package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameManager {
    private Map<String, Player> players = new HashMap<>();

    public void register(String name, Player player) {
        players.put(name, player);
    }

    public int round(String playerName1, String playerName2) {
        Player playerOne = players.get(playerName1.toLowerCase());
        Player playerTwo = players.get(playerName2.toLowerCase());
        if (playerOne == null) {
            throw new NotRegisteredException("Первый игрок не зарегистрирован для участия в турнире!");
        } else if (playerTwo == null) {
            throw new NotRegisteredException("Второй игрок не зарегистрирован для участия в турнире!");
        }
        if (playerOne.getStrength() > playerTwo.getStrength()) {
            return 1;
        } else if (playerOne.getStrength() < playerTwo.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}