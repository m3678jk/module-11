package TaskOne;

import java.util.Scanner;

public class TimeCounter extends Thread {
    private volatile boolean running = false;
    private volatile boolean isAlive = true;
    private volatile int count = 0 ;
    public void setRunning(boolean running) {
        this.running = running;
    }

    public synchronized void countTime(){
        count ++;
    }

    public synchronized void print(){
        if (count % 5==0){
            System.out.println("5 sec is left");
        } else {
            System.out.println("Time from start - "+ count + " sec.");
        }
    }
    public  void isFiveSec(){
        new Thread(() ->{
           if (count%5 ==0) {
               print();
           }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    @Override
    public void run() {
        while (isAlive) {
            if (running) {
                countTime();
                print();

            }
// it works always
            try {
                Thread.sleep(1000L);
                if (count%5==0){
                    isFiveSec();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    public void startProgram(){
        System.out.println("Enter commands:\nto start - \"s\"\nto finish - \"f\"\nto exit - \"e\"\nto pause - \"p\"\nto restart - \"r\"");

        Scanner scanner = new Scanner(System.in);
        while(true) {
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
                    start();
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
                    stopThread();
                    break;

            }
        }
    }

    private void stopThread() {
        isAlive = false;
    }

}

class Tester {
    public static void main(String[] args) {
        TimeCounter timeCounter = new TimeCounter();
        timeCounter.startProgram();
    }
}
