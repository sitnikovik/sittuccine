<?php

require_once __DIR__ . '/Human/Human.php';
require_once __DIR__ . '/Human/Woman.php';

use Human\Woman;

/**
 * Run the application
 * 
 * @return void
 * @throws Exception
 */
function run(): void 
{
    $kittyRurk = new Woman('Kitty Rurk', 0);
    $aliceCoul = new Woman('Alice Coul', 20);
    $rileySteele = new Woman('Riley Steele', 25);

    $v = 1;
    for ($i = 0; $i < 10; $i++) {
        $v += 1;
        println("v: $v");
    }

    $women = [
        $kittyRurk,
        $aliceCoul, 
        $rileySteele,
    ];
    foreach ($women as $i => $woman) {
        try {
            if (empty($woman->age)) {
                throw new Exception("{$woman->name} is too young");
            }
            if ($woman->age <= 17) {
                throw new Exception("{$woman->name} is not an adult");
            }
            if ($woman->age >= 80) {
                throw new Exception("{$woman->name} is too old");
            }

            $nameMsg = sprintf("Got woman named {$woman->name} and %d old.", $woman->age);
            println($nameMsg);
            $woman->run();
        } catch (\Throwable $th) {
            println('Exception: ' . $th->getMessage());
        }
    }
}

/**
 * Custom println function to print a message with a new line
 * 
 * @param string $msg
 * @return void
 */
function println(string $msg): void 
{
    echo $msg . "\n";
}

run();