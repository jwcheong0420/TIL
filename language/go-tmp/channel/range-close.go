package main

import (
	"fmt"
	"runtime"
)

func main() {
	ch := make(chan int, 2)
	ch <- 1
	ch <- 2
	close(ch)

	// range문으로 간단히 표현
	for i := range ch {
		fmt.Println(i)
	}

	maxProcs := runtime.GOMAXPROCS(0)
	fmt.Println(maxProcs)

}
