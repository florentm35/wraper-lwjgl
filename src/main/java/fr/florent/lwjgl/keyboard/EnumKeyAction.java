package fr.florent.lwjgl.keyboard;

import fr.florent.lwjgl.exception.LwjglRuntimeException;
import org.lwjgl.glfw.GLFW;

public enum EnumKeyAction {

    KEYUP(GLFW.GLFW_RELEASE), KEYDOWN(GLFW.GLFW_PRESS), KEYREPEAT(GLFW.GLFW_REPEAT);

    EnumKeyAction(int keyValue) {
        this.keyValue = keyValue;
    }

    private final int keyValue;

    public static EnumKeyAction valueOf(int lwjqlKeyValue) {

        for (EnumKeyAction key : EnumKeyAction.values()) {
            if (key.keyValue == lwjqlKeyValue) {
                return key;
            }
        }

        throw new LwjglRuntimeException(String.format("Action %d can't be found", lwjqlKeyValue));
    }

    public int getKeyValue() {
        return keyValue;
    }
}
