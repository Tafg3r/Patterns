package Assigment1.Assigment4;

import java.util.ArrayList;
import java.util.List;

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        System.out.println("Setting state to " + state);
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        System.out.println("Saving state to memento: " + state);
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("Restoring state from memento: " + state);
    }
}

class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

public class MementoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State1");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State2");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State3");

        System.out.println("Current state: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("First saved state: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Second saved state: " + originator.getState());
    }
}