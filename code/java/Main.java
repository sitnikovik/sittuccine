import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.io.*;

// Constants
final class Constants {
    public static final double PI = 3.14159;
    public static final int MAX_BUFFER_SIZE = 1024;
}

// Enumerations
enum Days {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

// Interface
interface IPerson {
    String getName();
    int getAge();
    void greet();
}

// Abstract class
abstract class AbstractPerson implements IPerson {
    protected final String name;
    protected final int age;

    public AbstractPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void greet();
}

// Final class
final class Person extends AbstractPerson {
    public Person(String name, int age) {
        super(name, age);
    }

    public void greet() {
        System.out.println("Hello, " + name + "!");
    }
}

/**
 * Class representing an employee extending the Person class.
 */
class Employee extends Person {
    private String position;
    private double salary;

    /**
     * Constructor for the Employee class.
     * 
     * @param name     the name of the employee
     * @param age      the age of the employee
     * @param position the position of the employee
     * @param salary   the salary of the employee
     */
    public Employee(String name, int age, String position, double salary) {
        super(name, age);
        this.position = position;
        this.salary = salary;
    }

    /**
     * Gets the position of the employee.
     * 
     * @return the position of the employee
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the position of the employee.
     * 
     * @param position the new position of the employee
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets the salary of the employee.
     * 
     * @return the salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     * 
     * @param salary the new salary of the employee
     * @throws IllegalArgumentException if the salary is negative
     */
    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    @Override
    public void greet() {
        System.out.println("Hello, " + name + "! You are a " + position + ".");
    }
}


@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

/**
 * Main class containing the main method.
 * 
 * @version 1.0
 * @since 1.0
 */
public class Main {
    // Method with multiple return values using an array
    public static int[] addAndMultiply(int a, int b) {
        return new int[]{a + b, a * b};
    }

    // Generator method using Stream
    public static Stream<Integer> generateNumbers(int max) {
        return Stream.iterate(0, n -> n + 1).limit(max);
    }

    // Asynchronous method using CompletableFuture
    public static CompletableFuture<Void> asyncFunction() {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Async function finished");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    // Main method
    public static void main(String[] args) {
        // Variable declarations
        int a = 5;
        int b = 10;
        int result;
        char[] buffer = new char[Constants.MAX_BUFFER_SIZE];

        // Array
        int[] numbers = {1, 2, 3, 4, 5};

        // List
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);

        // Map
        Map<Days, String> days = new EnumMap<>(Days.class);
        days.put(Days.SUNDAY, "Sunday");
        days.put(Days.MONDAY, "Monday");
        days.put(Days.TUESDAY, "Tuesday");
        days.put(Days.WEDNESDAY, "Wednesday");
        days.put(Days.THURSDAY, "Thursday");
        days.put(Days.FRIDAY, "Friday");
        days.put(Days.SATURDAY, "Saturday");

        // Conditional statements
        if (a > b) {
            System.out.println("a is greater than b");
        } else if (a < b) {
            System.out.println("a is less than b");
        } else {
            System.out.println("a is equal to b");
        }

        // Switch statement
        Days today = Days.WEDNESDAY;
        switch (today) {
            case SUNDAY:
            case SATURDAY:
                System.out.println("It's the weekend!");
                break;
            default:
                System.out.println("It's a weekday.");
                break;
        }

        // Loop statements
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("numbers[%d] = %d%n", i, numbers[i]);
        }

        for (int num : numberList) {
            System.out.printf("numberList contains: %d%n", num);
        }

        // Function calls
        int[] results = addAndMultiply(a, b);
        System.out.printf("The sum of %d and %d is %d%n", a, b, results[0]);
        System.out.printf("The product of %d and %d is %d%n", a, b, results[1]);

        Person person = new Person("John Doe", 30);
        person.greet();

        Employee employee = new Employee("Jane Smith", 28, "Developer", 75000);
        employee.greet();
        employee.work();

        try {
            employee.setSalary(-5000);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Using functional interface
        MathOperation addition = (x, y) -> x + y;
        System.out.printf("Addition result: %d%n", addition.operate(a, b));

        // Using generator method
        generateNumbers(5).forEach(num -> System.out.printf("Generated number: %d%n", num));

        // Using asynchronous method
        asyncFunction().join();

        // File I/O
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            int charsRead = reader.read(buffer);
            System.out.printf("Read %d characters from file%n", charsRead);
        } catch (IOException e) {
            System.err.println("File I/O error: " + e.getMessage());
        }

        System.out.println("Main function finished");
    }
}