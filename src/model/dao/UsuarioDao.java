/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conn.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Usuario;

/**
 *
 * @author Dagmar Mpheio
 */
public class UsuarioDao {

    private Connection conn;

    public UsuarioDao() {
        this.conn = new ConexaoBD().getConnection();
    }

    //login
    public boolean verificarLogin(Usuario u) throws SQLException {
        boolean check = false;
        PreparedStatement stmt = conn.prepareStatement("select * from usuarios where login=? and senha=?");
        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getSenha());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            check = true;

        }
        return check;
    }
}
