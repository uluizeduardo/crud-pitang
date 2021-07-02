package gui;

import gui.Utils.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem pesquisar;

    @FXML
    private MenuItem cadastrar;

    @FXML
    public void pesquiserUsuarios(){
        abrirTele("/gui/UsuarioView.fxml");
    }

    @FXML
    public void cadastrarNovoUsuario(){
        System.out.println("Cadastrar novo usuário");
    }

    @FXML


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //função para aobrir uma tela
    public synchronized void abrirTele(String nomeAbsoluto){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
            VBox novoVbox = loader.load();

           Scene novaCena = LoginViewController.getNovaCena();
            VBox vboxPrincipal  = (VBox) ((ScrollPane) novaCena.getRoot()).getContent();

            Node menuPrincipal = vboxPrincipal.getChildren().get(0);
            vboxPrincipal.getChildren().clear();
            vboxPrincipal.getChildren().add(menuPrincipal);
            vboxPrincipal.getChildren().addAll(novoVbox.getChildren());
        }
        catch (IOException ex){
            Alerts.showAlert("IOException", "Erro ao carregar a pagina", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
