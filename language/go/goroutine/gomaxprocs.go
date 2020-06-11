package main

import (
	"runtime"
)

func main() {
	numCPU := runtime.NumCPU()
	defaultGOMAXPROCS := runtime.GOMAXPROCS(0)
	runtime.GOMAXPROCS(2)
	modifiedGOMAXPROCS := runtime.GOMAXPROCS(0)

	println("numCPU :", numCPU)
	println("default GOMAXPROCS :", defaultGOMAXPROCS)
	println("modified GOMAXPROCS :", modifiedGOMAXPROCS)
}
