package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Alley alley;
    private List<Player> players;
    private Map<String, Double> scores;
    private GameDisplay display;

    public Game(Alley alley, List<Player> players, GameDisplay display) {
        this.alley = alley;
        this.players = players;
        this.display = display;
        this.scores = new HashMap<>();
    }

    public Alley getAlley() {
        return alley;
    }

    public void setAlley(Alley alley) {
        this.alley = alley;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Map<String, Double> getScores() {
        return scores;
    }

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }

    public GameDisplay getDisplay() {
        return display;
    }

    public void setDisplay(GameDisplay display) {
        this.display = display;
    }
}
