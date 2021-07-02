package gui;

import db.DB;
import gui.Utils.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtSenha;

    @FXML
    private Label lblErrors;

    @FXML
    private Button btnEntrar;

    //Método que leva para a proxima tela do sistema ao clicar no Botão entrar
    @FXML
    public void clickBotaoEntrar(MouseEvent event){

        if (event.getSource() == btnEntrar){
            //login
            if(login().equals("Sucesso")){
                try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TelaPrincipal.fxml"));
                ScrollPane scrollPane = loader.load();

                scrollPane.setFitToWidth(true);
                scrollPane.setFitToWidth(true);

                Scene novaCena = new Scene(scrollPane);
                stage.setScene(novaCena);
                stage.show();

                }catch (IOException ex){
                    System.err.println(ex.getMessage());
                }
            }
        }

    }
    //Conexão com DB
    Connection conn = DB.abrirConexaoDb();

    //Metodo para realizar o login
    public String login(){

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String status = "Sucesso";
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        if (email.isEmpty() || senha.isEmpty()){
            Alerts.showAlert("Atenção!", null, "Informe os valores", Alert.AlertType.WARNING);
            status = "Error";
        }else{
            //query
            String sql = "SELECT * FROM usuario WHERE email = ? and senha = ?";

            try{
                statement = conn.prepareStatement(sql);
                statement.setString(1, email);
                statement.setString(2, senha);

                resultSet = statement.executeQuery();
                if (!resultSet.next()){
                    setLblError(Color.WHITE, "Usuário ou senha inválidos");
                    status = "Error";
                }
            }
            catch (SQLException ex){
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        return status;
    }

    //método auxiliar para setar erros na tela de login
    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO
        if (conn == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Erro do servidor: verificar");
        }
    }
}
