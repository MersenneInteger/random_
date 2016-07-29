package main
import "fmt"
func main(){

var n, temp int
list := [10] int {5,7,33,8,2,74,17,6,1,11}
fmt.Print("Enter a number n, in between 1-10 to find ")
fmt.Println("the nth smallest number on the list")

for _, value := range list {
    fmt.Printf("%d ",value)
    }
fmt.Println()

fmt.Scanf("%d", &n)

for  i:=0; i < len(list); i++ {
    for j:=0; j <len(list);j++ {
    	if list[i] < list[j] {
	   temp = list[i]
	   list[i] = list[j]
	   list[j] = temp
	   }
	  }
	 }
fmt.Printf("%d smallest number is %d\n", n, list[n-1])

}