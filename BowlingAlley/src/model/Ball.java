package model;

import enums.Pattern;

public class Ball {
    private String name;
    private Pattern ballPattern;
    private double weight;

    public Ball(String name, Pattern ballPattern, double weight) {
        this.name = name;
        this.ballPattern = ballPattern;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pattern getBallPattern() {
        return ballPattern;
    }

    public void setBallPattern(Pattern ballPattern) {
        this.ballPattern = ballPattern;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
