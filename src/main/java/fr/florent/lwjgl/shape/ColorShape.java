package fr.florent.lwjgl.shape;

import fr.florent.lwjgl.window.Window;

import static org.lwjgl.opengl.GL11.glColor4f;

public class ColorShape extends Shape {


    public static final ColorShape RED = new ColorShape(255, 0, 0);
    public static final ColorShape GREEN = new ColorShape(0, 255, 0);
    public static final ColorShape BLUE = new ColorShape(0, 0, 255);

    public static final ColorShape BLACK = new ColorShape(0, 0, 0);
    public static final ColorShape WHITE = new ColorShape(255, 255, 255);

    private final int red;
    private final int green;
    private final int blue;
    private final int alpha;


    public ColorShape(int red, int green, int blue) {
        this(red, green, blue, 0);
    }

    public ColorShape(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    private float getRenderValue(int color) {
        return color / 255.0f;
    }

    public float getRedRenderValue() {
        return getRenderValue(red);
    }

    public float geGreenRenderValue() {
        return getRenderValue(green);
    }

    public float getBlueRenderValue() {
        return getRenderValue(blue);
    }

    public float getAlphaRenderValue() {
        return getRenderValue(alpha);
    }


    @Override
    public void render(Window window) {
        glColor4f(getRedRenderValue(),
                geGreenRenderValue(),
                getBlueRenderValue(),
                getAlphaRenderValue());
    }
}
