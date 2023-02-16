package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player playerOne = null;
        Player playerTwo = null;

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                playerOne = player;
            }
            if (player.getName().equals(playerName2)) {
                playerTwo = player;
            }
        }

        if (playerOne == null) {
            throw new NotRegisteredException("Первый игрок не зарегистрирован для участия в турнире!");

        } else if (playerTwo == null) {
            throw new NotRegisteredException("Второй игрок не зарегистрирован для участия в турнире!");
        }

        if (playerOne.getStrength() > playerTwo.getStrength()) {
            return 1;
        } else if (playerOne.getStrength() < playerTwo.getStrength()) {
            return 2;
        }
        return 0;
    }

}