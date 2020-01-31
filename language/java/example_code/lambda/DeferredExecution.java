package language.java.example_code.lambda;

public class DeferredExecution {
    public static void main(String[] args) {
        repeat(10, () -> System.out.println("Hello, world!"));  // 정의는 여기에서 하지만
    }

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();   // 실행은 여기에서 한다
        }
    }
}