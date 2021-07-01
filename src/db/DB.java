package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
    private static Connection conect = null;

    //Métetodo para conectar ao Banco de Dados
    public static Connection abrirConexaoDb(){
        if (conect == null){
            try {
                Properties props = CarregarPropriedades();
                String url = props.getProperty("dburl");
                conect = DriverManager.getConnection(url, props);
            }
            catch (SQLException ex){
                throw new DbException(ex.getMessage());
            }
        }
        return conect;
    }

    //Método auxiliar para carregar as propriedades que estão no documento db.propriedades
    public static Properties CarregarPropriedades(){
        try(FileInputStream fs = new FileInputStream("db.propriedades")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException ex){
            throw new DbException(ex.getMessage());
        }
    }

    //Método para fechar a conexão com o Banco de Dados
    public static void fecharaConexaoDb(){
        if (conect != null){
            try {
                conect.close();
            } catch (SQLException ex){
                throw new DbException(ex.getMessage());
            }
        }
    }

    public static void fecharStatment(Statement st){
        if (st != null){
            try{
                st.close();
            }catch (SQLException ex){
                throw new DbException(ex.getMessage());
            }
        }
    }
}
