// package main
 
// import "os"
 
// func main() {
//     // 잘못된 파일명을 넣음
//     openFile("Invalid.txt")
     
//     // openFile() 안에서 panic이 실행되면
//     // 아래 println 문장은 실행 안됨
//     println("Done") 
// }
 
// func openFile(fn string) {
//     f, err := os.Open(fn)
//     if err != nil {
//         panic(err)
//     }
 
//     defer f.Close()
// }