package fr.florent.lwjgl.shape;

import fr.florent.lwjgl.utils.Point;
import fr.florent.lwjgl.window.Window;

import static org.lwjgl.opengl.GL11.*;


public class PointShape extends Shape {

    private ColorShape color;
    private Point point;
    private int size;

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

    public ColorShape getColor() {
        return color;
    }

    public void setColor(ColorShape color) {
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
