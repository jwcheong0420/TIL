# Chapter2. 변수
## 1. 변수(Variable)
### 1.1 변수란?
* 단 하나의 값을 저장할 수 있는 메모리 상의 공간
### 1.3 Naming Convention
* 필수 규칙
  * 대소문자 구분, 길이 제한 없음
  * 예약어 사용 금지
  * 숫자로 시작 금지
  * 특수문자는 _와 $만 사용 가능
* 권장 규칙
  * 변수는 camelCase, 클래스는 PascalCase
  * 상수는 SCREAMING_SNAKE_CASE
## 2. 변수의 타입
### 2.1 Primitive type
* 실제 값을 저장
* 종류와 크기
  * boolean - 1 byte, 논리형
    * default 값은 false
  * char - ***2 byte***, 문자형
    * 자바에서 유니코드(2 byte 문자체계) 사용
    * 모든 데이터는 숫자(유니코드 정수값)로 저장됨
    * 문자열 만드는 법
      * 문자열 + any type -> 문자열
      * any type + 문자열 -> 문자열
  * byte - 1 byte, 정수형
  * short - 2 byte, 정수형
  * int - 4 byte, 정수형
    * JVM 피연산자 스택(operand stack)을 4 byte단위로 저장하므로 byte, short의 값을 계산할 때 변환됨
  * long - 8 byte, 정수형
    * 리터럴에 l, L을 붙이지 않으면 int로 간주
  * float - 4 byte, 실수형
    * 리터럴에 f, F를 붙이지 않으면 double로 간주
  * double - 8 byte, 실수형
### 2.2 Reference type
* 객체의 주소를 저장
* Primitive 8가지 제외 나머지 타입
## 3. 형변환
### 3.1 형변환(casting)이란?
* 변수 또는 리터럴의 타입을 다른 타입으로 변환하는 것
### 3.2 형변환 방법
* 기본형 -> 기본형, 참조형 -> 참조형
  * JDK1.5부터 기본형 -> 참조형 가능
* 큰 자료형 -> 작은 자료형 변환 시 값 손실이 있을 수 있으니 명시적 형변환 필요
* 자동 형변환 가능
  * byte -> short -> int -> long -> float -> double
  * char -> int
