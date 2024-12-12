package Assigment1.task5;

// Класс Button зависит от интерфейса Switchable
public class Button {
    private Switchable device;

    public Button(Switchable device) {
        this.device = device;
    }

    public void press() {
        device.turnOn();
    }
}
