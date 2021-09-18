package fr.florent.lwjgl.window;

import fr.florent.lwjgl.event.IKeyActionEvent;
import fr.florent.lwjgl.exception.LwjglRuntimeException;
import fr.florent.lwjgl.keyboard.EnumKey;
import fr.florent.lwjgl.keyboard.EnumKeyAction;
import fr.florent.lwjgl.utils.Pair;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {

    private final long handlerId;

    private WindowProperty property;

    private Map<Pair<EnumKey, EnumKeyAction>, List<IKeyActionEvent>> eventCache;

    private AtomicBoolean end = new AtomicBoolean(false);

    /**
     * Create Windows and show it
     *
     * @param property The properties of windows
     * @return {@link Window} Windows wrapped instance
     */
    public Window(WindowProperty property) {

        if (property == null) {
            throw new LwjglRuntimeException("Property cannot be null");
        }

        this.property = property;

        handlerId = glfwCreateWindow(property.getWidth(),
                property.getHeight(),
                property.getTitle(),
                NULL,
                NULL);

        glfwSetKeyCallback(handlerId, (window, keyValue, scancode, actionValue, mods) -> {

            EnumKey key = EnumKey.valueOf(keyValue);
            EnumKeyAction action = EnumKeyAction.valueOf(actionValue);

            List<IKeyActionEvent> lstEventToPlay = eventCache.entrySet().stream()
                    .filter(e -> {
                        return e.getKey().matchWithNull(key, action);
                    })
                    .map(Map.Entry::getValue)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());

            for (IKeyActionEvent event : lstEventToPlay) {
                event.onAction(this, key, action);
            }

        });


        // Get the thread stack and push a new frame
        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(handlerId, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // TODO wrappe position and add property position
            // Center the window
            glfwSetWindowPos(
                    handlerId,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(handlerId);
        // Enable v-sync
        glfwSwapInterval(1);

    }

    public void showWindow() {
        glfwShowWindow(handlerId);
    }


    public void closeWindow() {
        glfwSetWindowShouldClose(handlerId, true);
        glfwFreeCallbacks(handlerId);
        glfwDestroyWindow(handlerId);

        getEnd().set(true);
    }


    public void addKeyboardEvent(IKeyActionEvent event, EnumKey key, EnumKeyAction keyAction) {

        if (eventCache == null) {
            eventCache = new ConcurrentHashMap<>();
        }

        var pairKeyAction = Pair.of(key, keyAction);
        if (!eventCache.containsKey(pairKeyAction)) {
            eventCache.put(pairKeyAction, Collections.synchronizedList(new ArrayList<>()));
        }
        eventCache.get(pairKeyAction).add(event);

    }


    public long getHandlerId() {
        return handlerId;
    }

    public WindowProperty getProperty() {
        return property;
    }

    public AtomicBoolean getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Window{" +
                "handlerId=" + handlerId +
                ", property=" + property +
                ", eventCache=" + eventCache +
                '}';
    }
}
