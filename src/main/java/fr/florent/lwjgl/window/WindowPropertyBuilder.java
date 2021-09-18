package fr.florent.lwjgl.window;

public class WindowPropertyBuilder {

    private WindowProperty property;

    private WindowPropertyBuilder(WindowProperty property) {
        this.property = property;
    }

    public static WindowPropertyBuilder builder() {

        return new WindowPropertyBuilder(new WindowProperty());
    }

    public WindowProperty build() {
        WindowProperty tmp = property;
        property = null;
        return tmp;
    }


    public WindowPropertyBuilder width(int width) {
        property.setWidth(width);
        return this;
    }


    public WindowPropertyBuilder height(int height) {
        property.setHeight(height);
        return this;
    }

    public WindowPropertyBuilder title(String title) {
        property.setTitle(title);
        return this;
    }

    public WindowPropertyBuilder verticalAlign(EnumPosition verticalAlign) {
        property.setVerticalAlign(verticalAlign);
        return this;
    }

    public WindowPropertyBuilder horizontalAlign(EnumPosition horizontalAlign) {
        property.setHorizontalAlign(horizontalAlign);
        return this;
    }


}
