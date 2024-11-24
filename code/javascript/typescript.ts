// Variables
let primaryColor: string = "#007bff";
let secondaryColor: string = "#0056b3";
const backgroundColor: string = "#f0f0f0";

// Interfaces
interface Person {
    name: string;
    age: number;
    greet(): void;
}

// Classes
class User implements Person {
    name: string;
    age: number;

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    greet(): void {
        console.log(`Hello, ${this.name}`);
    }
}

// Functions
function showAlert(message: string): void {
    alert(message);
}

// Arrays
let colors: string[] = ["red", "green", "blue"];

// Loops
for (let i = 0; i < colors.length; i++) {
    console.log(colors[i]);
}

// Conditionals
let user: User = new User("John Doe", 30);
if (user.age > 18) {
    console.log(`${user.name} is an adult.`);
} else {
    console.log(`${user.name} is not an adult.`);
}

// Event Listeners
document.getElementById("myButton")?.addEventListener("click", function() {
    showAlert("Button clicked!");
});

// Try-Catch
try {
    // Intentionally cause an error
    nonExistentFunction();
} catch (error) {
    console.error("An error occurred:", error);
}