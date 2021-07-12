/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dagmar Mpheio
 */
public class ConexaoBD {

    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

    public Connection getConnection() {
        try {
            return conn = DriverManager.getConnection("jdbc:mysql://localhost/db_convites", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no ExecutaSQL: " + e);
            throw new RuntimeException();
        }
    }

    //metodo para execucaoSQL
    public void executaSQL(String sql) {
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nao foi executar a consulta\nErro: ".toUpperCase() + ex);
        }

    }

    // fechar conexao
    public void closeConection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Conexão fechada".toUpperCase() + ex);
        }
    }

    public static void main(String[] args) {
        Connection conn = new ConexaoBD().getConnection();
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "Conexão Efectuda com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com a base de dados!");
        }
    }
}
