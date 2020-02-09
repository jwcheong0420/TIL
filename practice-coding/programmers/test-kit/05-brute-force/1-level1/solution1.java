import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

class Solution {
    class Student implements Comparable<Student> {
        int[] submitted;
        int hits = 0;
        int id;

        Student(int id, int... submitted) {
            this.id = id;
            this.submitted = Objects.requireNonNull(submitted);
        }

        public void correctAnswer(int number, int answer) {
            int submittedAnswer = submitted[number % submitted.length];
            if (submittedAnswer == answer) {
                hits++;
            }
        }

        public int getId() {
            return id;
        }

        public int getHits() {
            return hits;
        }

        @Override
        public int compareTo(Student o) {
            return o.getHits() - this.getHits();
        }
    }

    public int[] solution(int[] answers) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, 1, 2, 3, 4, 5));
        students.add(new Student(2, 2, 1, 2, 3, 2, 4, 2, 5));
        students.add(new Student(3, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        for (int i = 0; i < answers.length; i++) {
            for (Student s : students) {
                s.correctAnswer(i, answers[i]);
            }
        }
        Collections.sort(students);

        ArrayList<Integer> highest = new ArrayList<>();
        highest.add(students.get(0).getId());
        for (int i = 0; i < students.size() - 1; i++) {
            if (students.get(i).compareTo(students.get(i + 1)) == 0) {
                highest.add(students.get(i + 1).getId());
            } else {
                break;
            }
        }
        Collections.sort(highest);

        return highest.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] answers = { 1, 3, 2, 4, 2 };

        int[] answer = sol.solution(answers);
        System.out.println("answer : " + Arrays.toString(answer));
    }
}