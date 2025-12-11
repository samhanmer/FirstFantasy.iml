import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;



public class Game {
    private Character player;
    private Stage stage;
    private DialogGui dialogGui;
    private Dialog dialog;

    public Game(Stage stage) {
        this.stage = stage;
        this.dialogGui = new DialogGui(stage);
        this.dialog = new Dialog(dialogGui, this);
    }


    public void start() {   //Coordinates the scenes
        createCharacter();
    }

    private void createCharacter() {  //Gathers information of the player character
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));

        Label headerLabel = new Label("Player Identification");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your character's name");

        TextField proSubjField = new TextField();
        proSubjField.setPromptText("Enter your Subjective pronoun (he/she/they)");

        TextField proObjField = new TextField();
        proObjField.setPromptText("Enter your Objective pronoun (him/her/them)");

        TextField proPossAdjField = new TextField();
        proPossAdjField.setPromptText("Enter your Possessive Adjective (his/her/their)");

        TextField ageField = new TextField();
        ageField.setPromptText("Enter your Age");

        Button submitButton = new Button("Create Character");

        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String proSubj = proSubjField.getText();
            String proObj = proObjField.getText();
            String proPossAdj = proPossAdjField.getText();
            String ageString = ageField.getText();
            int age = Integer.parseInt(ageString);


            player = new Character(name, proSubj, proObj, proPossAdj, age);
            chooseClass();
        });

        vbox.getChildren().addAll(headerLabel, nameField, proSubjField, proObjField, proPossAdjField, ageField, submitButton);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
    }

    private void chooseClass() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));

        Label label = new Label("Choose your class:");
        Button barBtn = new Button("Barbarian");
        Button temBtn = new Button("Templar");
        Button wizBtn = new Button("Wizard");
        Button alcBtn = new Button("Alchemist");
        Button thiBtn = new Button("Thief");
        Button ranBtn = new Button("Ranger");

        barBtn.setOnAction(e -> setPlayerClass(new Barbarian()));
        temBtn.setOnAction(e -> setPlayerClass(new Templar()));
        wizBtn.setOnAction(e -> setPlayerClass(new Wizard()));
        alcBtn.setOnAction(e -> setPlayerClass(new Alchemist()));
        thiBtn.setOnAction(e -> setPlayerClass(new Thief()));
        ranBtn.setOnAction(e -> setPlayerClass(new Ranger()));

        vbox.getChildren().addAll(label, barBtn, temBtn, wizBtn, alcBtn, thiBtn, ranBtn);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);

    }

    private void setPlayerClass(Job job) {
        player.setPlayerClass(job);
        player.getPlayerClass().printOriginStory(player, dialogGui, dialog);
        player.getPlayerClass().giveStarterEquipment(player.getInventory());
    }

    public void lockpickMinigame(String difficulty) {
        LockpickMinigame ui = new LockpickMinigame();
        ui.pickMinigame(stage, player, difficulty);
    }
}