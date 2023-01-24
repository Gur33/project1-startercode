package whitman.cs370proj.composer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Main.fxml")));
        } catch (IOException e) {
            System.out.println("Unable to load file \"Main.fxml\".\n" + e);
            System.exit(0);
        }
        primaryStage.setOnCloseRequest(event -> {
            primaryStage.close();
            System.exit(0);
        });
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Scale Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}