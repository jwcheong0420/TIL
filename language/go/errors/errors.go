package main

import "os"

func main() {
	f, err := os.Open("tmp.txt")
	if err != nil {
		panic(err)
	}
	defer f.Close()
}
