<?php

namespace Human;

/**
 * Represents a human.
 */
abstract class Human
{
    /**
     * Human constructor
     * 
     * @param string $name
     * @param int $age
     */
    public function __construct(
        public readonly string $name,
        public readonly int $age  
    ){}
}
