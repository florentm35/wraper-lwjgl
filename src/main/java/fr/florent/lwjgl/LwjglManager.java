package fr.florent.lwjgl;

import fr.florent.lwjgl.exception.LwjglRuntimeException;
import fr.florent.lwjgl.scene.Scene;
import fr.florent.lwjgl.window.Window;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;


/**
 * LWJGL wrapper
 */
public class LwjglManager {


    private static LwjglManager _instance;

    private LwjglManager() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit())
            throw new LwjglRuntimeException("Unable to initialize Lwjgl");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
    }

    public static void init() {
        if (_instance == null) {
            _instance = new LwjglManager();
        } else {
            throw new LwjglRuntimeException("Lwjgl can't be init twice");
        }
    }


    public static void launch(Window window, Scene scene){

        window.showWindow();

        GL.createCapabilities();

        // Set the clear color
        glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

        scene.onInit();
        do {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            // Scene
            scene.update();
            scene.render(window);

            glfwSwapBuffers(window.getHandlerId()); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();

        } while (!window.getEnd().get());

    }


}
