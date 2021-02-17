package main

import (
	"context"
	"fmt"
	"runtime"
)

func main() {
	type favContextKey string

	// Context에서 key에 대한 value를 출력하는 익명 함수 정의
	f := func(ctx context.Context, k favContextKey) {
		if v := ctx.Value(k); v != nil {
			fmt.Println("found value:", v)
			return
		}
		fmt.Println("key not found:", k)
	}

	// key 정의
	k := favContextKey("language")
	// Context 생성
	ctx := context.WithValue(context.Background(), k, "Go")

	// 익명 함수 호출
	f(ctx, k)
	f(ctx, favContextKey("color"))

	fmt.Println(runtime.NumCPU())
}
