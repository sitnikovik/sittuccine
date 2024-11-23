<?php

namespace Human;

require_once __DIR__ . '/Human.php';
require_once __DIR__ . '/../Doer/Runner.php';

use Doer\Runner;

/**
 * Represents a woman
 */
class Woman extends Human implements Runner
{
    /**
     * Begins to run.
     * 
     * @return void
     */
    public function run(): void
    {
        println("{$this->name} is running...");
    }
}