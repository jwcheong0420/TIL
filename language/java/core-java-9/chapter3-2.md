## 3장 인터페이스와 람다 표현식(2)

### Nominal / Structural / Duck Typing
* 명목적 타입 지정(Nominal Typing)
    * 이름으로 타입을 구분
    * Java, C++, Swift 등의 정적 언어들이 사용
* 구조적 타입 지정(Structural Typing)
    * 구조(멤버)로 타입을 구분
    * TypeScript, Ocaml과 같은 언어들이 사용
* Duck Typing
    * 어떤 새가 오리처럼 행동하면, 그 새를 오리라고 부를 것이다
    * 형태를 판별하지 않고, 원하는 동작을 할 수 있는지 여부를 검사
    * JavaScript, Python과 같은 동적 언어들이 사용

### Method 참조와 생성자 참조 (Java 8)
#### Method 참조
* format
    ```java
    String::compareToIgnoreCase         // Class::instanceMethod
    Objects::isNull                     // Class::staticMethod
    System.out::println                 // object::instanceMethod
    ```
* lambda보다 간결함
    ```java
    Arrays.sort(strings, (x, y) -> x.compareToIgnoreCase(y))
    Arrays.sort(strings, String::compareToIgnoreCase)

    list.removeIf(x -> Objects.isNull(x))
    list.removeIf(Objects::isNull)

    list.forEach(x -> System.out.println(x))
    list.forEach(System.out::println)

    x -> this.equals(x)
    this::equals    // this도 사용 가능
    ```
#### 생성자 참조
```java
List<String> names = { "Jenny", "Tom" };
Stream<Employee> stream = names.stream().map(Employee::new);
// Object[] buttons = stream.toArray();
Employee[] buttons = stream.toArray(Employee[]::new);
```

### 지역 클래스(Local Class)와 익명 클래스(Anonymous class)
#### 지역 클래스
* method안에 정의한 class
    * [내부 클래스(Inner Class)](chapter2.md#중첩-클래스(nested-class))는 class안에 정의한 class임 주의!
* 접근 제어자나 static 제어자를 붙일 수 없음
    * method 바깥에서는 접근 불가능
* 장점
    * 클래스 이름이 method의 유효 범위 안으로 숨음
    * (람다 표현식의 변수처럼)지역 클래스의 method 안에서 자신을 감싸는 유효 범위에 속한 변수에 접근할 수 있음
#### 익명 클래스
* [익명 클래스 예시 with Comparator](../../../practice_coding/programmers/test_kit/hash/play_list/Solution1.java)
* 람다 표현식이 생기기 전까지는, Runnable / Comparator / Functional object를 만드는 가장 간결한 문법이었음
* 람다 표현식이 생긴 후부터는 method를 2개 이상 제공해야할 때만 익명 클래스가 필요함
    ```java
    public static IntSequence randomInt(int low, int high) {
        return new IntSequence() {
            public int next() { return low + generator.nextInt(high - low + 1); }
            public boolean hasNext() { return true; }
        }
    }
    ```