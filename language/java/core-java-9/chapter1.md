## 1장 기본 프로그래밍 구조

### 자바 컴파일 및 실행
* 자바 컴파일
    * javac(java compiler)를 통해 .java -> .class(byte code, 반기계어 - 하드웨어가 읽을 수 없음)
* 자바 실행
    * java로 .class 실행 시, JVM에 있는 class loader에 의해 .class가 로드됨
    * 실행 엔진(Interpreter와 JIT compiler)에 의해 기계어로 해석되어 메모리(Runtime Data Area)에 로드됨
* 더 살펴볼 링크
    * 컴파일, 실행, GC까지
        * https://aljjabaegi.tistory.com/387

### JShell
* Java 9부터 지원되는 대화형 프롬프트
* REPL(Read-Evaluate-Print Loop)을 제공
    * 입력하면 바로 평가하고 결과를 즉시 표시
* 간단한 구문을 테스트하기에 적합

### Big Number
* BigInteger, BigDecimal
* 무한한 크기의 정수 혹은 부동소수점 숫자를 다루기 위한 class
* 사칙연산 기호(+, -, *, /)를 사용할 수 없고 method를 사용해야 함

### CharSequence
* char 값의 sequence를 표현하기 위한 interface
* implementing class : String, StringBuffer, StringBuilder 등
* 더 살펴볼 링크
    * http://dudmy.net/android/2017/09/15/difference-char-string/

### Wrapper Class
* primitive type은 generic class로 사용할 수 없으므로 wrapper class를 사용해야 함
* 산술연산을 위한 class가 아니므로 instance에 저장된 값을 변경할 수 없음
* boxing
    * boxing : primitive -> wrapper class
    ```java
    Integer number1 = new Integer(42);
    ```
    * unboxing : wrapper -> primitive class
    ```java
    int number2 = number1.intValue();
    ```
    * Java 5이후부터는 auto boxing/unboxing 지원
    ```java
    Integer number3 = 30;   // auto boxing
    int number4 = number3;  // auto unboxing
    ```

### Arrays와 Collections
* Arrays : primitive type(String은 예외)의 배열을 다루기 위한 다양한 알고리즘이 static method로 구현되어 있는 class
    * ex. Arrays.sort(), Arrays.copyOf(), Arrays.fill(), Arrays.deepToString()
* Collections : Collection을 다루기 위한 다양한 알고리즘이 static method로 구현되어 있는 class
    * Collection : 컨테이너. 값을 담는 그릇. 내부 저장소로 배열을 사용하지만, 배열의 크기와 같은 부분은 개발자가 고려하지 않고 동적으로 처리됨. 대신 접근은 method를 통해서만!
    * ex. Collections.sort(), Collections.reverse(), Collections.shuffle()
* 더 살펴볼 링크
    * https://niceman114.tistory.com/61
    * https://www.opentutorials.org/course/1223/6446
    * https://yahwang.github.io/posts/61