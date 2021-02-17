package main

import (
	"fmt"
	"os"
)

func main() {
	// 잘못된 파일명을 넣음
	openFile("Invalid.txt")

	// recover에 의해 이 문장 실행됨
	println("Done")
}

func openFile(fn string) {
	defer func() {
		if r := recover(); r != nil {
			fmt.Println("OPEN ERROR", r)
		}
	}()

	f, err := os.Open(fn)
	defer f.Close()
	if err != nil {
		panic(err)
	}
}
