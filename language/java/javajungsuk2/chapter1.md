# Chapter1. Java를 시작하기 전에
## 1. Java
### 1.1 자바란?
* Sun 마이크로시스템즈에서 개발하여 1996년에 공식 발표된 객체지향 프로그래밍 언어
* OS에 독립적
* 클래스 라이브러리(Java API)가 잘 되어 있음
### 1.2 자바의 역사
* 제임스 고슬링을 포함한 Sun의 엔지니어들이 가전제품에 넣을 S/W를 만드는 것을 목적으로 Oak 언어 개발
  * C++의 장점을 취하고 단점을 보완한 새로운 언어
* 인터넷이 등장하여 Oak를 인터넷에 적합하도록 바꾸면서 Java로 변경
  * Java로 개발한 브라우저 Hot java를 발표하고 그 다음 해(1996년 1월)에 Java 정식 버전 발표
* 서버 프로그래밍을 위한 서블릿(Servlet)과 JSP(Java Server Pages) 위주로 사용
  * 애플릿(Applet)은 flash와 같은 멀티미디어 플러그인이 생기면서 사용 안 하게 됨
### 1.3 자바 언어의 특징
#### 1. OS에 독립적
* Write once, run anywhre
* 자바가상머신(JVM)
  * 일종의 에뮬레이터
  * Java App <-> JVM <-> OS
  * Java는 OS에 독립적이지만 JVM은 OS에 종속적임
#### 2. 객체지향언어
* 상속, 캡슐화, 다형성이 잘 적용된 언어
#### 3. 배우기 쉬움
* 연산자 & 기본 from C++
* 객체지향 from small talk
  * 재사용성 & 유지보수 용이성
#### 4. 자동 메모리 관리(Garbage Collection)
#### 5. 네트워크와 분산처리 지원
* 네트워크 프로그래밍 라이브러리가 잘 되어 있음
#### 6. 멀티쓰레드 지원
* OS마다 멀티쓰레드 구현 & 처리 방법이 다르지만, Java는 OS와 관계없이 관련 라이브러리로 구현이 쉬움
* 쓰레드 스케줄링은 자바 인터프리터 담당
#### 7. 동적 로딩(Dynamic Loading) 지원
* 필요한 시점에 클래스를 로딩
* 일부 클래스가 변경되어도 전체 app을 컴파일하지 않아도 됨

### 1.4 JVM(Java Virtual Machine)
* Java app <-> JVM <-> OS <-> H/W
  * 실행 시 해석(interpret)되기 때문에 속도가 느림
  * JIT 컴파일러 & 향상된 최적화 기술 도입으로 개선
    * JIT 컴파일러 : byte code(컴파일된 자바 코드) -> H/W 기계어 변환
* Java는 OS에 독립적이지만 JVM은 OS에 종속적임

## 3. 자바로 프로그램 작성하기
### 3.1 Hello.java
* Java app을 실행하는 과정
  * Hello.java 작성
  * javac.exe(자바 컴파일러) 실행하여 class파일 생성
  * java.exe(자바 인터프리터)로 class파일 실행
* 하나의 java app에는 main을 포함한 class가 반드시 있어야 함
  * main은 java.exe에 의해 호출되는 java app의 진입점
  * 애플릿이나 서블릿은 main이 없어도 됨, 유사한 역할을 하는 다른 메소드가 있음
* 소스파일의 이름은 public class의 이름과 일치해야 함
  * 하나의 소스 파일에 public class는 하나
  * public class가 하나도 없으면 아무 class의 이름으로 소스 파일을 만들 수 있음
* .class는 class마다 하나씩 만들어짐
### 3.3 자바 프로그램의 실행 과정
* 필요한 .class 로딩
* .class 검사(파일 형식 등)
* java.exe의 인자로 넘어온 class에서 main을 호출
  * main 종료 시 프로그램 종료, 자원 반환
  * 멀티쓰레드 사용하는 app은 main이 종료되어도 다른 쓰레드가 실행 중이면 프로그램 종료되지 않음
