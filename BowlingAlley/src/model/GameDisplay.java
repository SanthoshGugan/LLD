package model;

import java.util.HashMap;
import java.util.Map;

public class GameDisplay {
    private Map<String, Double> scores;

    public GameDisplay(Map<String, Double> scores) {
        this.scores = scores;
    }

    public GameDisplay() {
        this.scores = new HashMap<>();
    }

    public Map<String, Double> getScores() {
        return scores;
    }

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }
}
