package main

import (
	"fmt"
	"time"
)

func highOrderFunc(freeVar string) func(string) {
	fmt.Println("고차함수\n***")
	return func(boundedVar string) {
		fmt.Println(boundedVar + " - " + freeVar + "\n***")
	}
}

func main() {
	// 익명함수를 goroutine으로 호출
	go func(s string) {
		fmt.Println(s + "\n***")
	}("익명함수")

	// 클로저를 goroutine으로 호출
	closure := highOrderFunc("포섭한 값")
	go closure("클로저")

	// 3초 대기
	time.Sleep(time.Second * 3)
}
