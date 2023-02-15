package dao.impl;

import dao.GameDao;
import dao.PlayerDao;
import exceptions.PlayerNotFound;
import model.Board;
import model.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameDaoImpl implements GameDao {

    private static GameDaoImpl gameDaoImpl;

    private Board board;
    List<Player> players;

    private GameDaoImpl() {

    }

    public static GameDaoImpl getInstance() {
        if (gameDaoImpl == null) {
            gameDaoImpl = new GameDaoImpl();
        }
        return gameDaoImpl;
    }

    @Override
    public void addBoard(final Board board) {
        this.board = board;
    }

    @Override
    public void addPlayer(final Player player) {
        this.players.add(player);
    }

    @Override
    public Player getPlayer(String name) {
        return players.stream().filter(player -> player.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new PlayerNotFound(name));
    }
}
