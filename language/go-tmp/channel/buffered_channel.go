package main

func main() {
	ch := make(chan int, 1)

	//수신자가 없더라도 보낼 수 있다.
	ch <- 1
	<-ch

	ch <- 1 // buffer를 다시 채웠다
	ch <- 1 // buffer가 찼으니까 송신자가 block되어서 데드락
	<-ch    // 여기까지 못온다
}
