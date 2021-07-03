package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entidades.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioListController implements Initializable {

    @FXML
    private TableView<Usuario> tabelaDeUsuario;

    @FXML
    private TableColumn<Usuario, Integer> colunaId;

    @FXML
    private TableColumn<Usuario, String> colunaNome;

    @FXML
    private TableColumn<Usuario, String> colunaEmail;

    @FXML
    private TableColumn<Usuario, String> colunaTelefone;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IniciarDadosDaTabela();
    }

    public void IniciarDadosDaTabela(){
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
    }
}
