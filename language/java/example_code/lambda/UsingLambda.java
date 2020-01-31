package language.java.example_code.lambda;

public class UsingLambda {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("I'm using lambda");
        runnable.run();
    }
}