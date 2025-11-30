import java.util.Scanner;


public class Game {
    private Character player;
    private Scanner scnr = new Scanner(System.in);
    private Dialog dialog;


    public void start() {   //Coordinates the scenes
        dialog = new Dialog(scnr); //Scnr lives here, and is used in other files when needed
        createCharacter();
        chooseClass();
        dialog.guildHall(player);
        lockpickMinigame("easy");
        dialog.guildPrologue(player);
        dialog.firstQuest(player);
        scnr.close();
    }
    public void createCharacter() {  //Gathers information of the player character
        System.out.print("Enter your character's name: ");
        String name = scnr.nextLine();                      // e.g. Sam

        System.out.print("Choose a pronoun subject (he/she/they): ");
        String proSubj = scnr.next().toLowerCase();         // e.g., he / she / they

        System.out.print("Choose a pronoun object (him/her/them): ");
        String proObj = scnr.next().toLowerCase();          // e.g., him / her / them

        System.out.print("Choose a possessive adjective (his/her/their): ");
        String proPossAdj = scnr.next().toLowerCase();      // e.g., his / her / their

        System.out.print("Enter your character's age: ");
        int age = scnr.nextInt();                           //e.g. 55

        player = new Character(name, proSubj, proObj, proPossAdj, age);
    }

    private void chooseClass() {
        System.out.println("Choose your class: Barbarian, Templar, Wizard, Alchemist, Thief or Ranger");
        String choice = scnr.next().toLowerCase();

        switch (choice) {
            case "barbarian": player.setPlayerClass(new Barbarian()); break;
            case "templar": player.setPlayerClass(new Templar()); break;
            case "wizard": player.setPlayerClass(new Wizard()); break;
            case "alchemist": player.setPlayerClass(new Alchemist()); break;
            case "thief": player.setPlayerClass(new Thief()); break;
            case "ranger": player.setPlayerClass(new Ranger()); break;
            default: System.out.println("Error, ensure correct spelling."); chooseClass(); return;
        }
        player.getPlayerClass().printOriginStory(player);
        player.getPlayerClass().giveStarterEquipment(player.getInventory());

    }

    private void lockpickMinigame(String difficulty) {
        LockpickMinigame mini = new LockpickMinigame();

        String playerClass = player.getPlayerClass().getClass().getSimpleName();
        Inventory inv = player.getInventory();

        System.out.println("\nYou approach a locked chest.");

        boolean success = mini.play(scnr, inv, "Lockpick", playerClass, difficulty);

        if (success) {
            System.out.println("There's nothing inside!");
        } else {
            System.out.println("The chest remains locked.");
        }
    } //helper for LockpickMinigame. Will rework eventually
}
