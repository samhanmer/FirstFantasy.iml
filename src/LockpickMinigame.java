import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class LockpickMinigame {
    private Random rand = new Random();
    private int lockpicks;

    public void pickMinigame(Stage stage, Character player, String difficulty) {

        Inventory inventory = player.getInventory();
        lockpicks = inventory.getQuantity("Lockpick");
        String playerClass = player.getPlayerClass().getClass().getSimpleName();

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));

        Label description = new Label("You approach a locked chest.");
        Label resultLabel = new Label();


        if (playerClass.equalsIgnoreCase("thief") && inventory.getQuantity("Lockpick") > 0) {
            resultLabel.setText("[THIEF]: You masterfully pick the lock.");
            vbox.getChildren().addAll(description, resultLabel);
            stage.setScene(new Scene(vbox));
            return;
        }
     if (playerClass.equalsIgnoreCase("barbarian")) {
        resultLabel.setText(" [BARBARIAN]: You smash the chest open! No one can lock anything inside it anymore.");
        vbox.getChildren().addAll(description, resultLabel);
        stage.setScene(new Scene(vbox));
        return;
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

        if (lockpicks <= 0) {
            resultLabel.setText("You're out of lockpicks.");
            vbox.getChildren().addAll(description, resultLabel);
            stage.setScene(new Scene(vbox));
            return;
        }
        //GUI menu for minigame
        Label difficultyLabel = new Label("Difficulty: " + difficulty.toUpperCase() + " (Guess 1–" + maxNumber + ")");
        Label attemptsLabel = new Label("You have " + lockpicks + " attempts.");

        TextField guessField = new TextField();
        guessField.setPromptText("Enter your guess");

        Button guessButton = new Button("Try Lockpick");

        guessButton.setOnAction(e -> {
            int guess = Integer.parseInt(guessField.getText());
            lockpicks--;
            // --- Lockpick guessing loop ---
            if (guess == code) {
                resultLabel.setText("The lock clicks open — success!");
                return;
            } else if (guess < code) {
                resultLabel.setText("Too low...");
            } else {
                resultLabel.setText("Too high...");
            }

            attemptsLabel.setText("Lockpicks remaining: " + lockpicks);

            if (lockpicks <= 0) {
                resultLabel.setText("You're out of lockpicks! The chest remains locked.");
                inventory.addItem("Lockpick", -inventory.getQuantity("Lockpick"));
                guessButton.setDisable(true);
                return;
            }
        });
        vbox.getChildren().addAll(description, difficultyLabel, attemptsLabel, guessField, guessButton, resultLabel);
        stage.setScene(new Scene(vbox));
    }
}


