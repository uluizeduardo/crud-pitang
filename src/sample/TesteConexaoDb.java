package sample;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexaoDb {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs =null;
        try{
            conn = DB.abrirConexaoDb();

            st = conn.createStatement();
            rs = st.executeQuery("select * from usuario");

            while (rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Nome"));
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}