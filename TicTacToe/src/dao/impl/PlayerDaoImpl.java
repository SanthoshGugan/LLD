package dao.impl;

import dao.PlayerDao;
import exceptions.PlayerAlreadyExists;
import exceptions.PlayerNotFound;
import model.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerDaoImpl implements PlayerDao {

    private static PlayerDaoImpl playerDaoImpl;

    private Map<String, Player> players;

    private PlayerDaoImpl() {
        players = new HashMap<>();
    }
    public static PlayerDaoImpl getInstance() {
        if (playerDaoImpl == null) {
            playerDaoImpl = new PlayerDaoImpl();
        }
        return playerDaoImpl;
    }

    @Override
    public void add(final Player player) {
        String name = player.getName();
        if(players.containsKey(name)) {
            throw new PlayerAlreadyExists(name);
        }

        players.put(player.getName(), player);
    }

    @Override
    public Player get(final String name) {
        if (players.containsKey(name)) {
            return players.get(name);
        }
        throw new PlayerNotFound(name);
    }

}
