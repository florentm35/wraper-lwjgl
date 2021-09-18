package fr.florent.lwjgl.utils;

import fr.florent.lwjgl.window.Window;


public class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public double getX(Window window) {
        return LwjglSizeConverter.convertPositionToLwjgl(x, window.getProperty().getWidth());
    }

    public double getY(Window window) {
        return LwjglSizeConverter.convertPositionToLwjgl(y, window.getProperty().getHeight());
    }
}
