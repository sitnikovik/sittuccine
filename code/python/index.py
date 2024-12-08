import os
import sys
import math
import random
import asyncio
from typing import List, Dict, Tuple, Union, Optional

# Constants
PI = 3.14159
MAX_BUFFER_SIZE = 1024

# Enumerations (using Enum)
from enum import Enum

class Days(Enum):
    SUNDAY = 0
    MONDAY = 1
    TUESDAY = 2
    WEDNESDAY = 3
    THURSDAY = 4
    FRIDAY = 5
    SATURDAY = 6

# Classes and Inheritance
class Person:
    """
    ### A class to represent a person.
    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
    """
    def __init__(self, name: str, age: int):
        self.name = name
        self.age = age

    def get_name(self) -> str:
        return self.name

    def get_age(self) -> int:
        return self.age

    def greet(self) -> None:
        print(f"Hello, {self.name}!")

class Employee(Person):
    """
    ### A class to represent an employee.

    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
    """
    def __init__(self, name: str, age: int, position: str, salary: float):
        super().__init__(name, age)
        self.position = position
        self.salary = salary

    def work(self) -> None:
        print(f"{self.name} is working as a {self.position}.")

    def get_salary(self) -> float:
        return self.salary

    def set_salary(self, new_salary: float) -> None:
        if new_salary < 0:
            raise ValueError("Salary cannot be negative")
        self.salary = new_salary

# Functions
def add(a: int, b: int) -> int:
    return a + b

def handle_error(message: str) -> None:
    print(f"Error: {message}")

# Generator function
def generate_numbers(max: int):
    for i in range(max):
        yield i

# Asynchronous function
async def async_function():
    await asyncio.sleep(1)
    print("Async function finished")

# Main function
def main():
    # Variable declarations
    a, b = 5, 10
    result = 0
    buffer = ""

    # List
    numbers = [1, 2, 3, 4, 5]

    # Dictionary
    days = {
        Days.SUNDAY: "Sunday",
        Days.MONDAY: "Monday",
        Days.TUESDAY: "Tuesday",
        Days.WEDNESDAY: "Wednesday",
        Days.THURSDAY: "Thursday",
        Days.FRIDAY: "Friday",
        Days.SATURDAY: "Saturday",
    }

    # Conditional statements
    if a > b:
        print("a is greater than b")
    elif a < b:
        print("a is less than b")
    else:
        print("a is equal to b")

    # Switch statement (using match-case in Python 3.10+)
    today = Days.WEDNESDAY
    match today:
        case Days.SUNDAY | Days.SATURDAY:
            print("It's the weekend!")
        case _:
            print("It's a weekday.")

    # Loop statements
    for i in range(len(numbers)):
        print(f"numbers[{i}] = {numbers[i]}")

    for i, num in enumerate(numbers):
        print(f"numbers[{i}] = {num}")

    # Function calls
    result = add(a, b)
    print(f"The sum of {a} and {b} is {result}")

    person = Person("John Doe", 30)
    person.greet()

    employee = Employee("Jane Smith", 28, "Developer", 75000)
    employee.greet()
    employee.work()

    try:
        employee.set_salary(-5000)
    except ValueError as e:
        handle_error(message=str(e))

    # Using generators
    for number in generate_numbers(5):
        print(f"Generated number: {number}")

    # Using async function
    asyncio.run(async_function())

if __name__ == "__main__":
    main()