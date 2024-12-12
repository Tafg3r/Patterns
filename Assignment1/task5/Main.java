package Assigment1.task5;


public class Main {
    public static void main(String[] args) {
        Switchable light = new Light();
        Button button = new Button(light);

        button.press();
    }
}
