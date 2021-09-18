package fr.florent.lwjgl.event;

import fr.florent.lwjgl.keyboard.EnumKey;
import fr.florent.lwjgl.keyboard.EnumKeyAction;
import fr.florent.lwjgl.window.Window;

public interface IKeyActionEvent {

    void onAction(Window window, EnumKey key, EnumKeyAction action);

}
