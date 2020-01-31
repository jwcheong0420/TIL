package language.java.example_code.lambda;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("I implemented Runnable");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
    }
}