// Renderer interface
interface Renderer {
    void renderShape(String shape);
}

// Windows renderer implementation
class WindowsRenderer implements Renderer {
    public void renderShape(String shape) {
        System.out.println("Rendering " + shape + " on Windows.");
    }
}

// Linux renderer implementation
class LinuxRenderer implements Renderer {
    public void renderShape(String shape) {
        System.out.println("Rendering " + shape + " on Linux.");
    }
}

// Abstract shape class
abstract class Shape {
    protected Renderer renderer;

    Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    abstract void draw();
}

// Circle shape
class Circle extends Shape {
    Circle(Renderer renderer) {
        super(renderer);
    }

    void draw() {
        renderer.renderShape("Circle");
    }
}

// Square shape
class Square extends Shape {
    Square(Renderer renderer) {
        super(renderer);
    }

    void draw() {
        renderer.renderShape("Square");
    }
}

// Client code for Bridge pattern
public class MainBridgeTask {
    public static void main(String[] args) {
        Renderer windowsRenderer = new WindowsRenderer();
        Renderer linuxRenderer = new LinuxRenderer();
        Shape circle = new Circle(windowsRenderer);
        Shape square = new Square(linuxRenderer);
        circle.draw(); // Rendering Circle on Windows
        square.draw(); // Rendering Square on Linux
    }
}