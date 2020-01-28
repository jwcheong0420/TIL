## 2장 객체 지향 프로그래밍

### 객체 지향 언어 특징
* 추상화 : 객체의 공통적인 특징(속성 & 기능)을 뽑아내는 것
* 캡슐화 : 데이터 구조와 데이터를 다루는 방법을 결합시켜 묶는 것. 데이터를 은닉하고 데이터를 접근하는 기능을 노출시키지 않는 것을 뜻하기도 함.
* 상속 : 하나의 클래스가 다른 클래스에게 특징(데이터와 함수)을 물려주는 것.
* 다형성 : 오버로딩과 오버라이딩. 동일한 이름의 함수가 다른 일을 하도록 하는 것.
    * 오버로딩
        * 중복 정의
        * 하나의 클래스에서 동일한 이름의 함수가 여러 개 존재할 수 있음
        * 매개변수가 달라야 함(리턴 타입은 무관)
    * 오버라이딩
        * 슈퍼 클래스를 상속받은 서브 클래스가 슈퍼 클래스의 메소드를 재정의하는 것
* 더 살펴볼 링크
    * https://sesok808.tistory.com/31
    * https://brunch.co.kr/@kd4/4

### method signature
* method 이름 + 매개 변수
* 오버로딩된 함수를 signature를 통해 구분함
* 더 살펴볼 링크
    * https://wanna-b.tistory.com/75

### 값을 사용한 호출
* method의 매개변수로 객체를 넘겨주면, 해당 method는 객체 참조의 사본을 얻음
```java
public class EvilManager {
    private Random generator;
    public void giveRandomRaise(Employee e) {
        double percentage = 10 * generator.nextGaussian();
        e.raiseSalary(percentage);  // 매개변수로 넘어온 fred를 method 내의 e로 복사. 참조를 복사하므로 같은 인스턴스를 바라보고 있음. 따라서 fred의 salary가 변경됨.
    }
    public void replceWithZombie(Employee e) {
        e = new Employee("", 0);    // 매개변수로 넘어온 fred가 method 내에서 새로운 객체 변경되었음. fred에는 영향을 미치지 않음.
    }
    public static void main(String[] args) {
        Employee fred = new Employee("fred", 100);
        EvilManager boss = new EvilManager();
        boss.giveRandomRaise(fred);
        boss.replceWithZombie(fred);
    }
}
```

### 초기화 블록
```java
public class Employee {
    private String name = "";
    private int id;
    private double salary;
    {
        // 초기화 블록
        Random generator = new Random();
        id = 1+ generator.nextInt(1_000_000);
    }

    public Employee(String name, double salary) {
    }
}
```
* 인스턴스 변수 초기화, 초기화 블록은 클래스 선언에 나타난 순서대로 실행
* 보통 초기화 로직이 길어지면 helper method를 만들고 생성자에서 helper method를 호출함

### 정적 초기화 블록
```java
public class CreditCardForm {
    private static final ArrayList<Integer> expirationYear = new ArrayList<>();
    static {
        int year = LocalDate().now().getYear();
        for (int i = year; i <= year + 20; i++) {
            expirationYear.add(i);
        }
    }
}
```

### final
* final 제어자를 변경 가능한 객체를 가리키는 참조에 사용하면 참조가 변하지 않을 뿐, 객체의 내용을 변경하는 것은 문제 없음
```java
public class Person {
    private final ArrayList<Person> friends = new ArrayList<>();
    // friends에 element를 추가하는 것은 괜찮음
}
```

### factory method
* [effective java item1 참고](../effective-java/item1-static-factory-method/)

### jar
* class file을 아카이브화하여 JAR파일을 만드는 유틸리티
* 보통 라이브러리를 묶을 때 사용

### 중첩 클래스(nested class)
* static nested class
    * static이 붙은 중첩 클래스
    * public인 경우 외부에서 static nested class 객체 생성 가능
* inner class
    * static이 붙지 않은 중첩 클래스
    * 내부 클래스의 method는 외부 클래스(outer class)의 인스턴스 변수에 접근 가능
    * {OuterClass}.this로 외부 클래스 참조를 나타냄. 명시적으로 하는 것이므로, 생략해도 잘 참조함.
        ```java
        public class Network {
            public class Member {
                public void deactive() {
                    Network.this.members.remove(this);  // members.remove(this)라고 써도 됨
                }
            }
        }
        ```