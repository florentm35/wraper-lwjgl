package fr.florent.lwjgl.shape;

import fr.florent.lwjgl.utils.Point;
import fr.florent.lwjgl.window.Window;

import static org.lwjgl.opengl.GL11.*;

public class TriangleShape extends Shape {

    private ColorShape color;
    private Point point1;
    private Point point2;
    private Point point3;

    public TriangleShape(ColorShape color, Point point1, Point point2, Point point3) {
        this.color = color;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public void render(Window window) {


        color.render(window);

        glLineWidth(0.25f);

        glBegin(GL_TRIANGLE_FAN);


        glVertex2d(point1.getX(window), point1.getY(window));
        glVertex2d(point2.getX(window), point2.getY(window));
        glVertex2d(point3.getX(window), point3.getY(window));


        glEnd();
    }
}
