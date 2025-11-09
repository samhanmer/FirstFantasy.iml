import java.util.Random;
import java.util.Scanner;

public class LockpickMinigame {
    private Random rand = new Random();
    private Scanner scnr;

    public boolean play(Scanner in, Inventory inventory, String lockpickName, String playerClass, String difficulty) {


        if (playerClass.equalsIgnoreCase("thief") && inventory.getQuantity("Lockpick") > 0) {  //Thief will always succeed picking locks as long as they have at least 1 pick.
            System.out.println("[THIEF]: You masterfully pick the lock with little effort.");
            return true;
        } else if (playerClass.equalsIgnoreCase("barbarian")) { //Barbarians will always defeat the chest
            System.out.println("[BARBARIAN]: You raise your greataxe and smash it into the chest, shattering it open!");
            System.out.println("[BARBARIAN]: No one can lock anything in this chest anymore.");
            return true;
        }

        //Determines how challenging the lock will be
        int maxNumber;
        switch (difficulty.toLowerCase()) {
            case "easy":
                maxNumber = 20;
                break;
            case "medium":
                maxNumber = 50;
                break;
            case "hard":
            default:
                maxNumber = 100;
                break;
        }

        int code = rand.nextInt(maxNumber) + 1;
        int lockpicks = inventory.getQuantity(lockpickName);

        if (lockpicks <= 0) {
            System.out.println("You're out of lockpicks.");
            return false;
        }

        System.out.println("You start to use your lockpick...");
        System.out.println("Difficulty: " + difficulty.toUpperCase() + " (" + maxNumber + " possible numbers)");
        System.out.println("You have " + lockpicks + " lockpick" + (lockpicks > 1 ? "s." : "."));

        // --- Lockpick guessing loop ---
        for (int i = 0; i < lockpicks; i++) {
            System.out.print("Enter your guess (1-" + maxNumber + "): ");
            int guess = in.nextInt();

            if (guess == code) {
                System.out.println("The lock clicks- you're in.");
                return true;
            } else if (guess < code) {
                System.out.println("Too low...");
            } else {
                System.out.println("Too high.");
            }

            if (i == lockpicks - 1) {
                System.out.println("You're out of lockpicks!");
                inventory.addItem(lockpickName, -lockpicks); // remove all lockpicks used
            }
        }

        return false;
    }
}


