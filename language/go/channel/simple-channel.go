package main

func main() {
	// channel 생성
	c := make(chan int)

	// 수신루틴이 없어서 데드락
	c <- 1
	<-c // 위에서 기다리고 있어서 얘는 실행도 안 됨(주석처리해도 데드락)
}
