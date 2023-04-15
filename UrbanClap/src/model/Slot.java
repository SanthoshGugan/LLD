package model;

import java.time.LocalTime;

public class Slot {
    private String id;
    private LocalTime startsAt;
    private LocalTime endsAt;
    private String name;

    public Slot(String id, LocalTime startsAt, LocalTime endsAt, String name) {
        this.id = id;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(LocalTime startsAt) {
        this.startsAt = startsAt;
    }

    public LocalTime getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(LocalTime endsAt) {
        this.endsAt = endsAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
