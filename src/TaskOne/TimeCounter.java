package TaskOne;

import java.util.Scanner;

public class TimeCounter {
    private volatile boolean running = false;
    private volatile boolean isAlive = true;
    private volatile int count = 0;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean getRunning() {
        return running;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void countTime() {
        setCount(count + 1);
    }

    Thread threadOne = new Thread(new Runnable() {
        public void run() {
            while (isIsAlive()) {
                if (getRunning()) {
                    countTime();
                    if (getCount() % 5 != 0) {
                        System.out.println("Time from start - " + getCount() + " sec.");
                    }

                }

                try {
                    Thread.sleep(1000L);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    Thread threadTwo = new Thread(new Runnable() {
        @Override
        public void run() {
            while (isIsAlive()) {
                if (getRunning()) {
                    if (getCount() % 5 == 0) {
                        System.out.println("5 sec left");

                    }
                }

                try {
                    Thread.sleep(5000L);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    });


    public void startProgram() {
        System.out.println("Enter commands:\nto start - \"s\"\nto finish - \"f\"\nto exit - \"e\"\nto pause - \"p\"\nto restart - \"r\"");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();

            switch (command) {
                case "e":
                    System.out.println("Exit");
                    System.exit(0);
                    scanner.close();
                    break;

                case "s":
                    System.out.println("Start");
                    setRunning(true);
                    threadOne.start();
                    threadTwo.start();


                    break;
                case "r":
                    System.out.println("Restart");
                    setRunning(true);

                    break;
                case "p":
                    System.out.println("paused");
                    setRunning(false);
                    break;
                //stop
                case "f":
                    System.out.println("stopped");
                    stopThreads();
                    break;

            }
        }
    }

    private void stopThreads() {
        setAlive(false);
    }

}

class Tester {
    public static void main(String[] args) {
        TimeCounter timeCounter = new TimeCounter();
        timeCounter.startProgram();
    }
}
