package model;

public class Alley {
    private PinFormation pinFormation;
    private BallDispatcher ballDispatcher;

    public Alley(PinFormation pinFormation, BallDispatcher ballDispatcher) {
        this.pinFormation = pinFormation;
        this.ballDispatcher = ballDispatcher;
    }

    public PinFormation getPinFormation() {
        return pinFormation;
    }

    public void setPinFormation(PinFormation pinFormation) {
        this.pinFormation = pinFormation;
    }

    public BallDispatcher getBallDispatcher() {
        return ballDispatcher;
    }

    public void setBallDispatcher(BallDispatcher ballDispatcher) {
        this.ballDispatcher = ballDispatcher;
    }
}
