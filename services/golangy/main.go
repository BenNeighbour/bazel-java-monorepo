package main

import (
	"fmt"
	"github.com/fatih/color"
)

func main() {
	// Create a new color object
	red := color.New(color.FgRed).Add(color.Bold)
	green := color.New(color.FgGreen)

	// Print colored messages
	red.Println("This is an important error message!")
	green.Println("This is a success message!")

	// Use color directly
	color.Blue("Hello, %s!", "world")

	// Use formatted string
	yellow := color.New(color.FgYellow)
	yellow.Printf("Warning: %s\n", "Disk space is low!")

	fmt.Println("Done. But refreshed")
}
