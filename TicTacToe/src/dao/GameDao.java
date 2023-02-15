package dao;

import model.Board;
import model.Player;

public interface GameDao {

    void addBoard(Board board);

    void addPlayer(Player player);

    Player getPlayer(String name);
}
