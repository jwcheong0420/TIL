// package main

// import "fmt"

// func A() {
// 	func() {
// 		if r := recover(); r != nil {
// 			fmt.Println("Panic occurred -", r)
// 		}
// 	}()
// }

// func main() {
// 	defer A()

// 	panic("Panic!")
// }

