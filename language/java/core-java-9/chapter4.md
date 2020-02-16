## 4장 상속과 리플렉션

### abstract
* **상속을 강제**하기 위한 규제
    * 부모 클래스에는 method의 시그니처만 정의, method의 실제 동작 방법은 상속 받은 하위 클래스의 책임으로 위임
* abtract method가 하나라도 존재하는 class는 abtract class
    * abstract method가 아닌 method도 abstract class에 존재할 수 있음
* 장점 : 코드의 중복 방지, 유지보수의 편의성