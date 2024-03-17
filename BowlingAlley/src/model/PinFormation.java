package model;

import java.util.ArrayList;
import java.util.List;

public class PinFormation {
    private List<List<Pin>> pins;

    public PinFormation() {
        this.pins = new ArrayList<>();
    }

    public List<List<Pin>> getPins() {
        return pins;
    }

    public void setPins(List<List<Pin>> pins) {
        this.pins = pins;
    }
}
