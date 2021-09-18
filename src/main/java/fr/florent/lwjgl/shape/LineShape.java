package fr.florent.lwjgl.shape;

import fr.florent.lwjgl.utils.Point;
import fr.florent.lwjgl.window.Window;

import static org.lwjgl.opengl.GL11.*;

public class LineShape {

    public LineShape(ColorShape color, Point begin, Point end, int size) {
        this.color = color;
        this.begin = begin;
        this.end = end;
        this.size = size;
    }

    public LineShape(ColorShape color, Point begin, Point end) {
        this(color, begin, end, 1);
    }

    private ColorShape color;

    private Point begin;

    private Point end;

    private int size;

    public void render(Window window) {
        color.render(window);
        glPointSize(size);
        glBegin(GL_LINES);

        glVertex2d(begin.getX(window), begin.getY(window));
        glVertex2d(end.getX(window), end.getY(window));

        glEnd();
    }

    public ColorShape getColor() {
        return color;
    }

    public void setColor(ColorShape color) {
        this.color = color;
    }

    public Point getBegin() {
        return begin;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
