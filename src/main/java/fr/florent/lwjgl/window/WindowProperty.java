package fr.florent.lwjgl.window;

public class WindowProperty {



    /**
     * Width of the window
     */
    private int width;

    /**
     * Height of the window
     */
    private int height;

    /**
     * Title of window
     */
    private String title;

    /**
     * Window vertical alignment
     */
    private EnumPosition verticalAlign;

    /**
     * Window horizontal alignement
     */
    private EnumPosition horizontalAlign;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public EnumPosition getVerticalAlign() {
        return verticalAlign;
    }

    public EnumPosition getHorizontalAlign() {
        return horizontalAlign;
    }


    void setWidth(int width) {
        this.width = width;
    }

    void setHeight(int height) {
        this.height = height;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setVerticalAlign(EnumPosition verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    void setHorizontalAlign(EnumPosition horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }


    @Override
    public String toString() {
        return "WindowProperty{" +
                "width=" + width +
                ", height=" + height +
                ", title='" + title + '\'' +
                ", verticalAlign=" + verticalAlign +
                ", horizontalAlign=" + horizontalAlign +
                '}';
    }
}
