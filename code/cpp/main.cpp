#include <iostream>
#include <string>
#include <vector>
#include <stdexcept>

// Define constants
#define PI 3.14159
#define MAX_BUFFER_SIZE 1024

// Enumeration
enum Days { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY };

// Base class definition
class Person {
public:
    Person(std::string name, int age) : name(name), age(age) {}

    virtual void greet() const {
        std::cout << "Hello, " << name << "!" << std::endl;
    }

    virtual ~Person() = default;

protected:
    std::string name;
    int age;
};

// Derived class definition
class Employee : public Person {
private:
    std::string position;
    double salary;

public:
    Employee(std::string name, int age, std::string position, double salary)
        : Person(name, age), position(position), salary(salary) {}

    void work() const {
        std::cout << name << " is working as a " << position << "." << std::endl;
    }

    void greet() const override {
        std::cout << "Hello, " << name << "! You are a " << position << "." << std::endl;
    }

    double getSalary() const {
        return salary;
    }

    void setSalary(double newSalary) {
        if (newSalary < 0) {
            throw std::invalid_argument("Salary cannot be negative");
        }
        salary = newSalary;
    }
};

// Function prototypes
void greet(const Person& person);
int add(int a, int b);
void handle_error(const std::string& message);

int main() {
    // Variable declarations
    int a = 5;
    int b = 10;
    int result;
    char buffer[MAX_BUFFER_SIZE];

    // Vector
    std::vector<int> numbers = {1, 2, 3, 4, 5};

    // Pointer
    int* p = &a;

    // Conditional statements
    if (a > b) {
        std::cout << "a is greater than b" << std::endl;
    } else if (a < b) {
        std::cout << "a is less than b" << std::endl;
    } else {
        std::cout << "a is equal to b" << std::endl;
    }

    // Switch statement
    Days today = WEDNESDAY;
    switch (today) {
        case SUNDAY:
        case SATURDAY:
            std::cout << "It's the weekend!" << std::endl;
            break;
        default:
            std::cout << "It's a weekday." << std::endl;
            break;
    }

    // Loop statements
    for (int i = 0; i < numbers.size(); i++) {
        std::cout << "numbers[" << i << "] = " << numbers[i] << std::endl;
    }

    int j = 0;
    while (j < numbers.size()) {
        std::cout << "numbers[" << j << "] = " << numbers[j] << std::endl;
        j++;
    }

    j = 0;
    do {
        std::cout << "numbers[" << j << "] = " << numbers[j] << std::endl;
        j++;
    } while (j < numbers.size());

    // Function calls
    result = add(a, b);
    std::cout << "The sum of " << a << " and " << b << " is " << result << std::endl;

    Person person("John Doe", 30);
    person.greet();

    Employee employee("Jane Smith", 28, "Developer", 75000);
    employee.greet();
    employee.work();

    try {
        employee.setSalary(-5000);
    } catch (const std::invalid_argument& e) {
        handle_error(e.what());
    }

    return 0;
}

// Function definitions
void greet(const Person& person) {
    person.greet();
}

int add(int a, int b) {
    return a + b;
}

void handle_error(const std::string& message) {
    std::cerr << message << std::endl;
}