package dao;

import model.Board;
import model.Player;

import java.util.List;

public interface PlayerDao {

    void add(Player player);

    Player get(String name);

}
