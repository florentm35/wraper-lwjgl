package fr.florent.lwjgl.shape;

import fr.florent.lwjgl.utils.LwjglSizeConverter;
import fr.florent.lwjgl.utils.Point;
import fr.florent.lwjgl.window.Window;

import java.util.Locale;

import static org.lwjgl.opengl.GL11.*;

public class CircleShape extends Shape {

    public CircleShape(ColorShape color, Point center, int radius) {
        this.color = color;
        this.center = center;
        this.radius = radius;
    }

    public CircleShape(ColorShape color, Point center, int radius, int precision) {
        this.color = color;
        this.center = center;
        this.radius = radius;
        this.precision = precision;
    }

    private ColorShape color;
    private Point center;
    private int radius;

    private int precision = 360;


    @Override
    public void render(Window window) {

        Locale.setDefault(Locale.ENGLISH);

        color.render(window);
        glBegin(GL_TRIANGLE_FAN);

        double x = center.getX(window);
        double y = center.getY(window);

        glVertex2d(x, y);
        for (double i = 0.0; i <= 360; i += 360f / precision) {
            double xAbsolute = LwjglSizeConverter.convertLengthToLwjgl(radius, window.getProperty().getWidth())
                    * Math.cos(Math.PI * i / 180);
            double yAbsolute = LwjglSizeConverter.convertLengthToLwjgl(radius, window.getProperty().getHeight())
                    * Math.sin(Math.PI * i / 180);

            glVertex2d(xAbsolute + x, yAbsolute + y);
        }

        glEnd();

    }


    public ColorShape getColor() {
        return color;
    }

    public void setColor(ColorShape color) {
        this.color = color;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }
}
