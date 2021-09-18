package fr.florent.lwjgl.utils;

import fr.florent.lwjgl.window.Window;


public class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private double getValue(int value, int size) {
        return (double) value / size;
    }

    public double getX(Window window) {
        return getValue(x, window.getProperty().getWidth() / 2);
    }

    public double getY(Window window) {
        return getValue(y, window.getProperty().getHeight() / 2);
    }
}
