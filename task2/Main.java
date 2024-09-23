

package Assigment1.task2;

abstract class Shape {
    public abstract double area();
}

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 3);
        Shape circle = new Circle(4);

        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Circle area: " + circle.area());
    }
}