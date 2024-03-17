package model;

import java.util.List;

public class BallDispatcher {
    private List<Ball> balls;

    public BallDispatcher(List<Ball> balls) {
        this.balls = balls;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }
}
