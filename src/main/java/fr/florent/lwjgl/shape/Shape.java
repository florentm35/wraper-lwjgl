package fr.florent.lwjgl.shape;

import fr.florent.lwjgl.window.Window;

import java.util.Objects;
import java.util.UUID;

public abstract class Shape {

    private UUID id = UUID.randomUUID();

    public abstract void render(Window window);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return id.equals(shape.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
