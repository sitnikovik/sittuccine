using System;
using System.Collections.Generic;
using System.IO;

// Define constants
const double PI = 3.14159;
const int MAX_BUFFER_SIZE = 1024;

// Enumeration
enum Days { Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday }

// Interface
interface IPerson
{
    string Name { get; set; }
    int Age { get; set; }
    void Greet();
}

// Class definition
class Person : IPerson
{
    public string Name { get; set; }
    public int Age { get; set; }

    public Person(string name, int age)
    {
        Name = name;
        Age = age;
    }

    public void Greet()
    {
        Console.WriteLine($"Hello, {Name}!");
    }
}

// Struct definition
struct Point
{
    public int X { get; set; }
    public int Y { get; set; }

    public Point(int x, int y)
    {
        X = x;
        Y = y;
    }
}

// Delegate
delegate void PrintMessage(string message);

class Program
{
    // Event
    public static event PrintMessage OnPrintMessage;

    static void Main(string[] args)
    {
        // Variable declarations
        int a = 5;
        int b = 10;
        int result;
        char[] buffer = new char[MAX_BUFFER_SIZE];

        // List
        List<int> numbers = new List<int> { 1, 2, 3, 4, 5 };

        // Pointer-like reference
        ref int p = ref a;

        // Conditional statements
        if (a > b)
        {
            Console.WriteLine("a is greater than b");
        }
        else if (a < b)
        {
            Console.WriteLine("a is less than b");
        }
        else
        {
            Console.WriteLine("a is equal to b");
        }

        // Switch statement
        Days today = Days.Wednesday;
        switch (today)
        {
            case Days.Sunday:
            case Days.Saturday:
                Console.WriteLine("It's the weekend!");
                break;
            default:
                Console.WriteLine("It's a weekday.");
                break;
        }

        // Loop statements
        for (int i = 0; i < numbers.Count; i++)
        {
            Console.WriteLine($"numbers[{i}] = {numbers[i]}");
        }

        int j = 0;
        while (j < numbers.Count)
        {
            Console.WriteLine($"numbers[{j}] = {numbers[j]}");
            j++;
        }

        j = 0;
        do
        {
            Console.WriteLine($"numbers[{j}] = {numbers[j]}");
            j++;
        } while (j < numbers.Count);

        // Function calls
        result = Add(a, b);
        Console.WriteLine($"The sum of {a} and {b} is {result}");

        Person person = new Person("John Doe", 30);
        person.Greet();

        // Error handling
        try
        {
            using (StreamReader sr = new StreamReader("test.txt"))
            {
                sr.Read(buffer, 0, MAX_BUFFER_SIZE);
            }
        }
        catch (IOException e)
        {
            HandleError(e.Message);
        }

        // Event handling
        OnPrintMessage += Print;
        OnPrintMessage?.Invoke("Event triggered!");

        // Lambda expression
        Func<int, int, int> multiply = (x, y) => x * y;
        Console.WriteLine($"The product of {a} and {b} is {multiply(a, b)}");
    }

    // Function definitions
    static int Add(int a, int b)
    {
        return a + b;
    }

    static void HandleError(string message)
    {
        Console.Error.WriteLine(message);
    }

    static void Print(string message)
    {
        Console.WriteLine(message);
    }
}