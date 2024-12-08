#include <stdio.h>
#include <stdlib.h>
#include <setjmp.h>
#include <string.h>

// Define constants
#define PI 3.14159
#define MAX_BUFFER_SIZE 1024

// Enumeration
enum Days { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY };

// Structure
struct Person {
    char name[50];
    int age;
};

// Function prototypes
void greet(struct Person person);
int add(int a, int b);
void handle_error(const char *message);

// Error handling macros
jmp_buf buf;

#define TRY if (setjmp(buf) == 0)
#define CATCH else
#define THROW longjmp(buf, 1)

int main() {
    // Variable declarations
    int a = 5;
    int b = 10;
    int result;
    char buffer[MAX_BUFFER_SIZE];

    // Array
    int numbers[5] = {1, 2, 3, 4, 5};

    // Conditional statements
    if (a > b) {
        printf("a is greater than b\n");
    } else if (a < b) {
        printf("a is less than b\n");
    } else {
        printf("a is equal to b\n");
    }

    // Switch statement
    enum Days today = WEDNESDAY;
    switch (today) {
        case SUNDAY:
        case SATURDAY:
            printf("It's the weekend!\n");
            break;
        default:
            printf("It's a weekday.\n");
            break;
    }

    // Loop statements
    for (int i = 0; i < 5; i++) {
        printf("numbers[%d] = %d\n", i, numbers[i]);
    }

    int i = 0;
    while (i < 5) {
        printf("numbers[%d] = %d\n", i, numbers[i]);
        i++;
    }

    i = 0;
    do {
        printf("numbers[%d] = %d\n", i, numbers[i]);
        i++;
    } while (i < 5);

    // Function calls
    result = add(a, b);
    printf("The sum of %d and %d is %d\n", a, b, result);

    struct Person person;
    strcpy(person.name, "John Doe");
    person.age = 30;
    greet(person);

    // Error handling using TRY-CATCH
    TRY {
        if (fgets(buffer, MAX_BUFFER_SIZE, stdin) == NULL) {
            THROW;
        }
    }
    CATCH {
        handle_error("Error reading input");
    }

    return 0;
}

// Function definitions
void greet(struct Person person) {
    printf("Hello, %s! You are %d years old.\n", person.name, person.age);
}

int add(int a, int b) {
    return a + b;
}

void handle_error(const char *message) {
    fprintf(stderr, "%s\n", message);
    exit(EXIT_FAILURE);
}