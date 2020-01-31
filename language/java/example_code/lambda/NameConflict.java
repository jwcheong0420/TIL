package language.java.example_code.lambda;

import java.util.Comparator;

public class NameConflict {
    public void main(String[] args) {
        // int first = 0;
        Comparator<String> comp = (first, second) -> first.length() - second.length();
    }
}