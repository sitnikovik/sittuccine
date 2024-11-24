package main

import (
	"fmt"
	"log"
	"sync"
	"time"
)

// Constants
const (
	MinWorkingAge = 16
	MaxWorkingAge = 65
)

// Human represents a person with a name and age
type Human struct {
	Name string
	Age  int
}

// Work simulates a human working
func (h Human) Work() error {
	if h.Age < MinWorkingAge {
		return fmt.Errorf("%s is %d years old and can't work", h.Name, h.Age)
	}
	if h.Age > MaxWorkingAge {
		return fmt.Errorf("%s is %d years old and should be retired", h.Name, h.Age)
	}
	fmt.Printf("%s is working.\n", h.Name)
	return nil
}

// generateNumbers sends numbers to a channel
func generateNumbers(max int) <-chan int {
	ch := make(chan int)
	go func() {
		for i := 0; i < max; i++ {
			ch <- i
		}
		close(ch)
	}()
	return ch
}

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
	oldMan := Human{Name: "Old Man", Age: 70}

	humans := []Human{johnDoe, rileySteele, kittyRurk, oldMan}
	var wg sync.WaitGroup
	wg.Add(1)

	go func(wg *sync.WaitGroup) {
		defer func() {
			if r := recover(); r != nil {
				log.Println("panic recovered:", r)
			}
		}()
		defer wg.Done()

		for _, h := range humans {
			if err := h.Work(); err != nil {
				log.Println("Error:", err)
				continue
			}
		}
	}(&wg)

	// Using channels
	ch := generateNumbers(5)
	for num := range ch {
		fmt.Printf("Generated number: %d\n", num)
		if num == 3 {
			break
		}
	}

	wg.Wait()
	fmt.Println("Main function finished")
}
