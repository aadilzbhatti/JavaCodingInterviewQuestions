package interviewing.algorithms.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    private Philosopher[] philosophers;
    private Chopstick[] chopsticks;

    public DiningPhilosophers(int numPhilosophers) {
        philosophers = new Philosopher[numPhilosophers];
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(i);
        }

        chopsticks = new Chopstick[numPhilosophers];
        for (int i = 0; i < philosophers.length; i++) {
            chopsticks[i] = new Chopstick(i);
        }
    }

    public void runSimulation() {

    }

    private boolean grabLeftChopstick(int philNumber) {
        return false;
    }

    private static int getLeftChopstick(int philNumber) {
        return philNumber;
    }

    private static int getRightChopstick(int philNumber, int numPhilosophers) {
        if (philNumber == 0) {
            return numPhilosophers - 1;
        }
        return philNumber - 1;
    }

    private static class Philosopher {
        int number;
        boolean hasEaten = false;

        public Philosopher(int number) {
            this.number = number;
        }

        public boolean hasPhilosopherEaten() {
            return hasEaten;
        }

        public void startEating() {
            hasEaten = true;
        }
    }

    private static class Chopstick {
        ReentrantLock lock;
        int number;

        public Chopstick(int number) {
            this.number = number;
            lock = new ReentrantLock();
        }
    }
}
