package main

import (
	"fmt"
	"time"
)

func say(s string) {
	fmt.Println(s)
}

func main() {
	// 함수를 동기적으로 실행
	say("Sync")

	// 함수를 비동기적으로 실행
	go say("Async1")
	go say("Async2")
	go say("Async3")

	// 3초 대기
	time.Sleep(time.Second * 3)
}
