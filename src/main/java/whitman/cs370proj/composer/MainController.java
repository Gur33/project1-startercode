package whitman.cs370proj.composer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class MainController {

    private final MidiPlayer player = new MidiPlayer(8, 60);

    @FXML
    private Button playButton;
    @FXML
    private Button stopButton;
    @FXML
    private MenuItem exitMenuItem;

    @FXML
    public void handlePlay() {
        TextInputDialog dialog = new TextInputDialog("60");
        dialog.setTitle("Starting note");
        dialog.setHeaderText("Give me a starting note (0-115):");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            int startNote = Integer.parseInt(result.get());
            if (player.isRunning()) {
                player.stop();
            }
            player.clear();
            addChromaticScale(startNote);
            player.play();
        }
    }

    @FXML
    public void handleStop() {
        player.stop();
    }

    @FXML
    public void handleExit() {
        System.exit(0);
    }

    private void addChromaticScale(int startNote) {
        int[] delta = {0, 2, 4, 5, 7, 9, 11, 12};
        int startTick = 0;

        // Upward scale
        for (int i = 0; i < 8; i++) {
            player.addNote(startNote + delta[i], 100, startTick,
                    1, 0, 0);
            startTick += 2;
        }

        // Pause between upward and downward scales
        startTick += 2;

        // Downward scale
        for (int i = 7; i >= 0; i--) {
            player.addNote(startNote + delta[i], 100, startTick,
                    1, 0, 0);
            startTick += 2;
        }
    }
}