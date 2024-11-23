package main

import (
	"fmt"
	"log"
	"sync"
	"time"
)

// main is the entry point of the program
func main() {
	for i := 0; i < 3; i++ {
		log.Println(fmt.Sprint(i + 1))
		time.Sleep(1 * time.Second)
	}

	var helloString string = "Hello, World!\n"
	log.Print(helloString)

	johnDoe := Human{Name: "John Doe", Age: 42}
	rileySteele := Human{Name: "Riley Steele", Age: 30}
	kittyRurk := Human{Name: "Kitty Rurk", Age: 15}

	humans := []Human{johnDoe, rileySteele, kittyRurk}
	var wg sync.WaitGroup
	wg.Add(1)
	go func() {
		defer func() {
			if r := recover(); r != nil {
				log.Println("panic recovered:", r)
			}
		}()
		defer wg.Done()

		for _, h := range humans {
			if age := h.Age; age <= 15 {
				panic(fmt.Sprintf(
					"%s is\u00a0%d\u00a0old and can't\u00a0work\n",
					h.Name, age,
				))
			}

			h.Work()
		}
	}()
	wg.Wait()
}
