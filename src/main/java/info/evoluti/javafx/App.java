package info.evoluti.javafx;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage initStage) throws IOException {
        try {
            Parent root = loadFXML("splash");

            Stage stage = new Stage();
            stage.setTitle("Splash");
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(event -> {
                stage.close();
                showMainStage();
            });

            delay.play();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    private void showMainStage() {
        try {
            Parent root = loadFXML("main");

            Stage stage = new Stage();
            stage.setTitle("Main");
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root, 600, 400));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}