package com.softserve.bookworm.model;

public abstract class AbstractEntity {
    public static final int NO_ELEMENT = -1;
    private int id = NO_ELEMENT;

    public AbstractEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}
