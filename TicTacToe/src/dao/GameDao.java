package dao.impl;

import model.Board;
import model.Player;

public interface GameDao {

    void addBoard(Board board);

    void addPlayer(Player player);

    void getPlayer(String name);
}
