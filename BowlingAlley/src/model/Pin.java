package model;

import enums.Color;
import enums.PinStatus;

public class Pin {
    private Color color;
    private PinStatus pinStatus;

    public Pin(Color color, PinStatus pinStatus) {
        this.color = color;
        this.pinStatus = pinStatus;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PinStatus getPinStatus() {
        return pinStatus;
    }

    public void setPinStatus(PinStatus pinStatus) {
        this.pinStatus = pinStatus;
    }
}
