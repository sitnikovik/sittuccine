package main

import (
	"fmt"
)

// Hack to implement the Worker interface
var _ Worker = &Human{}

type Worker interface {
	// Work makes the worker work.
	Work()
}

// Human is a struct representing a human.
type Human struct {
	// Name is the name of the human
	Name string `json:"name" db:"name"`
	// Age is the age of the human
	Age int `json:"age" db:"age"`
}

// Work makes the human work.
func (h *Human) Work() {
	if h == nil {
		return
	}

	fmt.Println(h.Name + "\u00a0is\u00a0working...")
}
