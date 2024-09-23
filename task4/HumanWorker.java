package Assigment1.task4;

import Assigment1.task4.Workable;

public class HumanWorker implements Workable, Eatable {
    public void work() {
        System.out.println("Human is working.");
    }
    public void eat() {
        System.out.println("Human is eating.");
    }
}
