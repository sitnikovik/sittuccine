<?php

/**
 * Constants
 */
const PI = 3.14159;
const MAX_BUFFER_SIZE = 1024;

/**
 * Enumerations
 */
enum Days {
    case SUNDAY;
    case MONDAY;
    case TUESDAY;
    case WEDNESDAY;
    case THURSDAY;
    case FRIDAY;
    case SATURDAY;
}

/**
 * Attribute for marking a method as deprecated
 */
#[Attribute]
class Deprecated {
    public function __construct(
        public string $message
    ) {}
}

/**
 * Interface for a person
 * @link https://www.php.net/manual/en/language.oop5.interfaces.php
 */
interface IPerson {
    /**
     * Get the name of the person
     *
     * @return string
     */
    public function getName(): string;

    /**
     * Get the age of the person
     *
     * @return int
     */
    public function getAge(): int;

    /**
     * Greet the person
     *
     * @return void
     */
    public function greet(): void;
}

/**
 * Abstract class representing a person
 */
abstract class AbstractPerson implements IPerson {
    protected readonly string $name;
    protected readonly int $age;

    /**
     * Constructor
     *
     * @param string $name
     * @param int $age
     */
    public function __construct(string $name, int $age) {
        $this->name = $name;
        $this->age = $age;
    }

    /**
     * Get the name of the person
     *
     * @return string
     */
    public function getName(): string {
        return $this->name;
    }

    /**
     * Get the age of the person
     *
     * @return int
     */
    public function getAge(): int {
        return $this->age;
    }

    /**
     * Greet the person
     *
     * @return void
     */
    abstract public function greet(): void;
}

/**
 * Final class representing a person
 */
final class Person extends AbstractPerson {
    /**
     * Greet the person
     *
     * @return void
     */
    #[Deprecated("Use the new greet method instead")]
    public function greet(): void {
        echo "Hello, {$this->name}!\n";
    }
}

/**
 * Add two numbers
 *
 * @param int $a
 * @param int $b
 * @return int
 */
function add(int $a, int $b): int {
    return $a + $b;
}

/**
 * Handle an error
 *
 * @param string $message
 * @return void
 */
function handleError(string $message): void {
    echo "Error: {$message}\n";
}

/**
 * Generator function to yield numbers
 *
 * @param int $max
 * @return Generator
 */
function generateNumbers(int $max): Generator {
    for ($i = 0; $i < $max; $i++) {
        yield $i;
    }
}

/**
 * Main script
 *
 * @return void
 */
function main(): void {
    // Variable declarations
    $a = 5;
    $b = 10;
    $result = 0;
    $buffer = '';

    // Array
    $numbers = [1, 2, 3, 4, 5];

    // Conditional statements
    if ($a > $b) {
        echo "a is greater than b\n";
    } elseif ($a < $b) {
        echo "a is less than b\n";
    } else {
        echo "a is equal to b\n";
    }

    // Switch statement
    $today = Days::WEDNESDAY;
    switch ($today) {
        case Days::SUNDAY:
        case Days::SATURDAY:
            echo "It's the weekend!\n";
            break;
        default:
            echo "It's a weekday.\n";
            break;
    }

    // Loop statements
    for ($i = 0; $i < count($numbers); $i++) {
        echo "numbers[{$i}] = {$numbers[$i]}\n";
    }

    $i = 0;
    while ($i < count($numbers)) {
        echo "numbers[{$i}] = {$numbers[$i]}\n";
        $i++;
    }

    $i = 0;
    do {
        echo "numbers[{$i}] = {$numbers[$i]}\n";
        $i++;
    } while ($i < count($numbers));

    // Function calls
    $result = add($a, $b);
    echo "The sum of {$a} and {$b} is {$result}\n";

    $person = new Person("John Doe", 30);
    $person->greet();

    // Error handling
    try {
        if (false) { // Simulate an error
            throw new Exception("Simulated error");
        }
    } catch (Exception $e) {
        handleError($e->getMessage());
    }

    // Using generators
    foreach (generateNumbers(5) as $number) {
        echo "Generated number: $number\n";
    }

    // Using fibers
    $fiber = new Fiber(function (): void {
        echo "Fiber started\n";
        Fiber::suspend();
        echo "Fiber resumed\n";
    });

    echo "Starting fiber\n";
    $fiber->start();
    echo "Resuming fiber\n";
    $fiber->resume();
}

main();