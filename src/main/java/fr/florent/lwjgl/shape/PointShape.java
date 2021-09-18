package fr.florent.lwjgl.shape;

import fr.florent.lwjgl.utils.Point;
import fr.florent.lwjgl.window.Window;

import static org.lwjgl.opengl.GL11.*;


public class PointShape extends Shape {

    private final ColorShape color;
    private final Point point;
    private final int size;

    public PointShape(ColorShape color, Point point, int size) {
        this.color = color;
        this.point = point;
        this.size = size;
    }

    public PointShape(ColorShape color, Point point) {
        this(color, point, 1);
    }

    @Override
    public void render(Window window) {

        color.render(window);
        glPointSize(size);
        glBegin(GL_POINTS);

        glVertex2d(point.getX(window), point.getY(window));

        glEnd();

    }
}
