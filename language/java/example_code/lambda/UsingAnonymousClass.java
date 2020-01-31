package language.java.example_code.lambda;

public class UsingAnonymousClass {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("I'm using anonymous class");
            }
        };
        runnable.run();
    }
}