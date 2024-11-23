<?php 

namespace Doer;

/**
 * Represents an object that can run.
 */
interface Runner
{
    /**
     * Begins to run.
     * 
     * @return void
     */
    public function run(): void;
}