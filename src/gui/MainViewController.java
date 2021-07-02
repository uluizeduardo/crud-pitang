package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem pesquisar;

    @FXML
    private MenuItem cadastrar;

    @FXML
    public void pesquiserUsuarios(){
        System.out.println("pesquisar usuários");
    }

    @FXML
    public void cadastrarNovoUsuario(){
        System.out.println("Cadastrar novo usuário");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
