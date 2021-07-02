package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    private static Scene telaLogin;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/LoginView.fxml"));
            Parent parent = loader.load();


            telaLogin = new Scene(parent);
            primaryStage.setScene(telaLogin);
            primaryStage.initStyle(StageStyle.UNIFIED);
            primaryStage.setTitle("Pitang");
            primaryStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Scene getTelaLogin(){
        return telaLogin;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
