package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/LoginView.fxml"));
            Parent parent = loader.load();

            Scene cenaPrincipal = new Scene(parent);
            primaryStage.setScene(cenaPrincipal);
            primaryStage.setTitle("Tela de Login - Pitang");
            primaryStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
