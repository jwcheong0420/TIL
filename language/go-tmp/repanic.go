// package main

// import "fmt"

// func main() {
// 	defer func() {
// 		fmt.Println(recover())
// 	}()
// 	defer panic("depth2 - 2")
// 	defer panic("depth2 - 1")

// 	panic("depth1 - 1")
// }

