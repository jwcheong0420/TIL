# A Tour of Go
https://go-tour-kr.appspot.com/

## 4. 패키지(Packages)
* 디렉토리 경로의 마지막 이름을 사용함
    * ex) "path/filepath"를 사용한다면 패키지명은 filepath


## 5. 임포트(Imports)
* 여러 개의 package를 소괄호로 감싸서 표현
    ```go
    import (
        "fmt"
        "math"
    )
    ```
* import 문장을 여러 번 사용할 수도 있음
    ```go
    import "fmt"
    import "math"
    ```

## 6. 익스포트(Exported names)
* 첫 문자가 대문자로 시작하면, 그 패키지를 import한 곳에서 접근할 수 있는 exported name이 됨
    * ex) Foo와 FOO는 외부에서 참조 가능, foo는 불가능
    ```go
    func main() {
        // fmt.Println(math.pi)    // cannot refer to unexported name math.pi
        fmt.Println(math.Pi)
    }
    ```

## 7~8. 함수
* 매개변수의 타입은 변수명 뒤에 명시
    ```go
    func add(x int, y int) int {
        return x + y
    }
    ```
* 두 개 이상의 매개변수가 같은 타입(type)일 때, 같은 타입을 취하는 마지막 매개변수에만 타입을 명시하고 나머지 생략 가능
    ```go
    func add(x, y int) int {
        return x + y
    }
    ```
## 9. 여러 개의 결과(Multiple results)
* 하나의 함수는 여러 개의 결과를 리턴 가능
    ```go
    package main

    import "fmt"

    func swap(x, y string) (string, string) {
        return y, x
    }

    func main() {
        a, b := swap("hello", "world")
        fmt.Println(a, b)
    }
    ```

## 10. 이름이 정해진 결과(Named results)
* 반환값에 이름을 부여하면 변수처럼 사용할 수 있음
    * 결과에 이름을 붙히면, 반환값을 지정하지 않은 return으로 현재 값을 알아서 잘 반환
    ```go
    package main

    import "fmt"

    func split(sum int) (x, y int) {
        x = sum * 4 / 9
        y = sum - x
        return
    }

    func main() {
        fmt.Println(split(17))
    }
    ```

## 11. 변수(Variables)
* var {변수 이름} {변수 타입}
    ```go
    var x, y, z int
    var c, python, java bool
    ```

## 12. 변수의 초기화
* 변수를 선언하면 zero 값으로 초기화됨
    * int는 0, bool은 false, string은 empty string으로
* 변수 선언과 동시에 초기화 가능
    ```go
    var x, y, z int = 1, 2, 3
    ```
    * 이 경우, 타입을 생략할 수 있음
        ```go
        var c, python, java = true, false, "no!"
        ```

## 13. 변수의 짧은 선언
* 함수 안에서는 :=을 사용하여 var와 type을 생략 가능
    ```go
    package main

    import "fmt"

    // hello := "hello" // syntax error: non-declaration statement outside function body

    func main() {
        var x, y, z int = 1, 2, 3
        c, python, java := true, false, "no!"
        // var test int := 1    // syntax error: unexpected :=, expecting =

        fmt.Println(x, y, z, c, python, java)
    }
    ```
    * 함수 밖에서는 := 선언을 사용할 수 없음
    * var가 사용되면 := 선언을 사용할 수 없음

## 14. 상수(Constants)
* const 키워드 사용
    ```go
    const Pi float64 = 3.14
    ```
* type 생략 가능
    ```go
    const Pi = 3.14
    ```

## 15. 숫자형 상수(Numeric)