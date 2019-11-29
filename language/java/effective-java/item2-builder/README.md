# 생성자에 매개변수가 많다면 빌더를 고려하라

## 점층적 생성자 패턴(Telescoping Constructor Pattern)
* 확장하기 어렵다

## 자바빈즈 패턴(JavaBeans Pattern)
* 객체를 완전히 생성하기 전까지 일관성(Consistency)가 깨진다
* Immutable 클래스로 만들 수 없다

## 빌더 패턴(Builder Pattern)
* 클라이언트는 필수 매개변수로 생성자를 호출해서 Builder 객체를 얻고, Builder 클래스의 setter들로 선택 매개변수를 설정하여 build()로 원하는 객체를 리턴받음
* 점층적 생성자 패턴과 자바빈즈 패턴의 장점만을 취함
* 계층적으로 설계된 클래스에 적용하면 좋음
