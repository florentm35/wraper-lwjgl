package fr.florent.lwjgl.scene;

import fr.florent.lwjgl.shape.Shape;
import fr.florent.lwjgl.window.Window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Scene {

    private final List<Shape> lstShape =  Collections.synchronizedList(new ArrayList<Shape>());

    public abstract void update();

    public void onInit(){

    }

    public void render(Window window){
        for (Shape shape:lstShape) {
            shape.render(window);
        }
    }

    public void addShape(Shape shape){
        lstShape.add(shape);
    }

    public void removeShape(Shape shape){
        lstShape.remove(shape);
    }

}
