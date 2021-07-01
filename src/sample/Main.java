package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    private static Scene cenaPrincipal;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/LoginView.fxml"));
            Parent parent = loader.load();


            cenaPrincipal = new Scene(parent);
            primaryStage.setScene(cenaPrincipal);
            primaryStage.initStyle(StageStyle.UNIFIED);
            primaryStage.setTitle("Pitang");
            primaryStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Scene getCenaPrincipal(){
        return cenaPrincipal;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
