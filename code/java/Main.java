import Human.Woman;

public class Main {
    
    /**
     * Main method to start the application.
     *
     * @param String[] args Command line arguments
     */
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Woman kittyRurk = new Woman("Kitty Rurk", 0);
        Woman aliceCoul = new Woman("Alice Coul", 20);
        Woman rileySteele = new Woman("Riley Steele", 25);

        int v = 1;
        for (int i = 0; i < 10; i++) {
            v += 1;
            println("v: " + v);
        }

        Woman[] women = {kittyRurk, aliceCoul, rileySteele};
        for (Woman woman : women) {
            try {
                if (woman.age == 0) {
                    throw new Exception(woman.name + " is too young");
                }
                if (woman.age <= 17) {
                    throw new Exception(woman.name + " is not an adult");
                }
                if (woman.age >= 80) {
                    throw new Exception(woman.name + " is too old");
                }

                String nameMsg = String.format("Got woman named %s and %d old.", woman.name, woman.age);
                println(nameMsg);
            } catch (Exception e) {
                println(e.getMessage());
            }
        }
    }

    public static void println(String msg) {
        System.out.println(msg);
    }
}