// Variables
var primaryColor = "#007bff";
let secondaryColor = "#0056b3";
const backgroundColor = "#f0f0f0";

// Functions
function showAlert(message) {
    alert(message);
}

// Objects
const person = {
    name: "John Doe",
    age: 30,
    greet: function() {
        console.log("Hello, " + this.name);
    }
};

// Arrays
let colors = ["red", "green", "blue"];

// Loops
for (let i = 0; i < colors.length; i++) {
    console.log(colors[i]);
}

// Conditionals
if (person.age > 18) {
    console.log(person.name + " is an adult.");
} else {
    console.log(person.name + " is not an adult.");
}

// Event Listeners
document.getElementById("myButton").addEventListener("click", function() {
    showAlert("Button clicked!");
});

// Try-Catch
try {
    // Intentionally cause an error
    nonExistentFunction();
} catch (error) {
    console.error("An error occurred:", error);
}