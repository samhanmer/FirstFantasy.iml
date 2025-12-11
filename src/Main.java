import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
    private Game game;

    @Override
            public void start(Stage primaryStage) {
                primaryStage.setTitle("First Fantasy");

                Game game = new Game(primaryStage);
                game.start();

                primaryStage.setWidth(600);
                primaryStage.setHeight(800);
                primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
