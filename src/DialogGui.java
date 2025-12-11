import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DialogGui {
    private Stage stage;
    private TextArea textArea;
    private VBox buttonBox;
    private Scene scene;

    public DialogGui(Stage stage) {
        this.stage = stage;

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);

        buttonBox = new VBox(10);
        buttonBox.setPadding(new Insets(10));

        VBox vbox = new VBox(10, textArea, buttonBox);
        scene = new Scene(vbox);

    }
    public Stage getStage() {
        return stage;
    }

    public void print(String text) {
        textArea.appendText((text + "\n"));
    }
    public void clear() {
        buttonBox.getChildren().clear();
    }
    public void addChoice(String text, Runnable action) {
        Button btn = new Button(text);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setOnAction(e -> action.run());
        buttonBox.getChildren().add(btn);
    }
    public void show() {
        stage.setScene(scene);
        stage.show();
    }
}
