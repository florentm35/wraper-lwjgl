# wraper-lwjgl

This is a wrapper of [LWJGL3](https://github.com/LWJGL/lwjgl3) for simply usage

## How to build

Juste run ```mvn install```

## How to use

Add depedence to maven project 
```xml
<dependency>
    <groupId>fr.florent</groupId>
    <artifactId>wrapper-lwjgl</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

In your main add
```java
public static void main(String[] args) {
    // Init Lwjgl
    LwjglManager.init(); 
    
    // Create a windows
    Window window = new Window(WindowPropertyBuilder.builder() 
            .width(1800)
            .height(1000)
            .title("Test")
            .build());

    // Add exit on Escape key up
    window.addKeyboardEvent((w, k, a) -> { 
                w.closeWindow();
            },
            EnumKey.ESCAPE,
            EnumKeyAction.KEYUP);

    // Launch your scene
    LwjglManager.launch(window, new MainScene());

}
 ```

Finaly create you scene
```java
public class MainScene extends Scene {

    @Override
    public void onInit() {
        // Call before launch
    }
    
    @Override
    public void update() {

        // Update shape here

    }
}
```
