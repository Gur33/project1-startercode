module whitman.cs370proj.project3startercode {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens whitman.cs370proj.composer to javafx.fxml;
    exports whitman.cs370proj.composer;
}