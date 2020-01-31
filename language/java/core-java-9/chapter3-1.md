## 3장 인터페이스와 람다 표현식(1)

### interface
* 하위 클래스에게 method가 반드시 존재하도록 강제하기 위한 규제
    * 서로가 **동일한 method를 만들도록** 규약을 만들어서, 공동으로 작업할 때 충돌을 방지하기 위함
* 선언 시 interface 키워드를 사용하며, 하위 클래스가 이를 구현할 때는 implements 키워드를 사용함
#### 규칙
* 인터페이스의 멤버는 반드시 public
    * 따라서 접근 제어자 생략 시 default가 아니라 public
    * [추가된 규칙](#추가된-규칙) 참고
* 캐스트
    * 서브 타입을 슈퍼 타입으로 변환하는 것은 언제나 가능함
        * T 타입의 모든 값을 변환 없이 S 타입의 변수에 할당할 수 있다면 S 타입은 T 타입(서브 타입)의 슈퍼 타입이다
    * 반대로, 슈퍼 타입을 서브 타입으로 변환하려면 캐스트를 사용해야 함
* instanceof 연산자
    ```java
    if (sequence instanceof DigitSequence) {
        DigitSequence digits = (DigitSequence) sequence;
    }
    ```
    * sequence가 DigitSequence를 슈퍼 타입으로 둔 클래스의 인스턴스일 때 true
        * 자동 형변환이 가능할 때 true
    * null에 안전함
        * sequence가 null인 경우 false
* 하나의 클래스가 여러 개의 인터페이스를 구현할 수 있음
    ```java
    interface I1 {
        public void a();
    }

    interface I2 {
        public void b();
    }

    class C1 implements I1, I2 {
        public void a(){}
        public void b(){}
    }
    ```
* 인터페이스도 상속 가능
    ```java
    interface I3 {
        public void c();
    }

    interface I4 extends I3 {
        public void d();
    }

    class C2 implements I4 {
        public void c(){}
        public void d(){}
    }
    ```
* interface에 정의한 변수는 모두 public static final
    ```java
    public interface I1 {
        int A = 1;
        int B = 2;
    }
    public class C1 implements I1 {
        public static void main(){
            int withoutQualifier = I1.A;    // {인터페이스 이름}.{변수 이름}으로 참조 가능
            int withQualifier = B;      // 한정어(qualifier)를 생략하고 {변수 이름}으로만으로도 참조 가능
        }
    }
    ```
    * 보통은 enum을 사용함
#### 추가된 규칙
* static method(Java 8)
    * 추가된 배경
        * 예전에는 보통 static method를 동반 클래스(companion class)에 두었음
            * ex) Collection/Collections, Path/Paths
    * 호출 시 {Interface명}.{method 명}으로 호출
    * 간단한 기능을 갖는 유틸리티성 interface를 만들 수 있음
    * factory method에 잘 맞음
        * 호출자는 factory method가 어떤 class의 인스턴스를 return하는 지 신경쓰지 않아도 됨
        ```java
        public interface IntSequence {
            static IntSequenct digitsOf(int n) {
                return new DigitSequence(n);
            }
        }
        public class Test {
            public static void main(String[] args) {
                IntSequence digits = IntSequence.digitsOf(1000);    
            }
        }
        ```
* default method(Java 8)
    * 추가된 배경
        * interface에는 기능을 구현할 수 없음  
        -> interface를 구현하는 class들은 같은 기능이어도 중복으로 구현하거나,  
        interface가 변경되면 이를 구현한 class들이 해당 method를 구현하는 등의 문제가 생김  
        -> default 키워드로 기본 기능을 구현할 수 있도록 개선
        * 예전에는 interface의 method를 구현하여 동반 클래스(companion class)에 두었음
            * ex) Collection/AbstractCollection, WindowsListener/WindowsAdapter
    * interface에 default 키워드로 method를 선언하면 기능을 구현할 수 있음
        ```java
        public interface I1 {
            public void a();
            default void b(){}
        }
        
        public class C1 implements I1 {
            @Override
            public void a(){}
        }

        public class C1Test {
            public static void main(String[] args){
                I1 i1 = new C1();
                i1.b();
            }
        }
        ```
    * 주의) 구현/상속 시 method 충돌 상황
        * 여러 interface에서 같은 시그니처의 method를 갖고 있고, 그 중 **하나라도 default method**로 구현되어있을 경우 compiler가 에러를 발생시킴
            * 구현하는 class에서 반드시 override를 해줘야하고, 슈퍼타입의 method를 부르고자하면 override 시 {슈퍼타입}.super.{method}로 호출하면 됨
        * 여러 interface에서 같은 시그니처의 method를 갖고 있고, 모두 public method인 경우는 충돌 발생하지 않음
            * 구현 class에 method를 구현하거나, class를 abstract로 선언
        * 슈퍼클래스 A로부터 상속받고 인터페이스 B를 구현하는 클래스 C가 있고, A와 B에 같은 시그니처의 method가 있을 경우, **A의 method만 인정하고 B의 method는 무시함**
* private method(Java 9)
    * 동일 interface 내의 다른 method의 helper method를 만들 수 있음
#### 인터페이스의 예
* Comparable
    * [연습 코드](../../../practice_coding/programmers/test_kit/hash/play_list/Solution2.java)
* Comparator
    * [연습 코드](../../../practice_coding/programmers/test_kit/hash/play_list/Solution1.java)
* Runnable
* 사용자 인터페이스 콜백