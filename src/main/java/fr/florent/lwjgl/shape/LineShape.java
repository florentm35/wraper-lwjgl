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

    private final ColorShape color;

    private final Point begin;

    private final Point end;

    private final int size;

    public void render(Window window) {
        color.render(window);
        glPointSize(size);
        glBegin(GL_LINES);

        glVertex2d(begin.getX(window), begin.getY(window));
        glVertex2d(end.getX(window), end.getY(window));

        glEnd();
    }

}
