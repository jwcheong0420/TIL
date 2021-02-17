package main

import (
	"fmt"
	"time"
)

func main() {
	tick := time.Tick(time.Second / 10) // 0.1초마다 신호를 보냄
	boom := time.After(time.Second / 2) // 0.5초 뒤에 신호를 보냄

	for {
		select {
		case <-tick:
			fmt.Println("tick!")
		case <-boom:
			fmt.Println("BOOM!")
			return
		default:
			fmt.Println(".")             // tick이랑 boom에 신호가 오지 않을 때 default문 실행
			time.Sleep(time.Second / 20) // 0.05초동안 sleep
		}
	}
}
