package main

func main() {
	maxOutStanding := 3
	sem := make(chan int, maxOutStanding)

	queue := make(chan int)
	go func() {
		for i := 0; i < 5; i++ {
			queue <- i
		}
		close(queue)
	}()

	for {
		if req, ok := <-queue; ok {
			sem <- 1
			go func(req int) {
				println("process -", req)
				<-sem
			}(req)
		} else {
			<-sem
			break
		}
	}
}
