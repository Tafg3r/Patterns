package Assigment1.Assigment3;

import java.util.HashMap;
import java.util.Map;


interface FlyweightShape {
    void draw();
}


class FlyweightCircle implements FlyweightShape {
    private String color; // Внутреннее свойство
    private int x, y, radius; // Внешние свойства

    public FlyweightCircle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing FlyweightCircle [Color: " + color + ", x: " + x + ", y: " + y + ", radius: " + radius + "]");
    }
}


class FlyweightShapeFactory {
    private static final Map<String, FlyweightShape> circleMap = new HashMap<>();

    public static FlyweightShape getCircle(String color) {
        FlyweightCircle circle = (FlyweightCircle) circleMap.get(color);
        if (circle == null) {
            circle = new FlyweightCircle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }
        return circle;
    }
}


public class MainFlyweightTask {
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            FlyweightCircle circle = (FlyweightCircle) FlyweightShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}