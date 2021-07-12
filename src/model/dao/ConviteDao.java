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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Convite;

/**
 *
 * @author Dagmar Mpheio
 */
public class ConviteDao {

    private Connection conn;

    public ConviteDao() {
        this.conn = new ConexaoBD().getConnection();
    }

    //adicionar convite
    public void adicionar(Convite c) {
        try {
            String sql = "insert into convites (nome, foto, data, hora, local_actvidade, verificado) values(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getFoto());
            stmt.setString(3, c.getData());
            stmt.setString(4, c.getHora());
            stmt.setString(5, c.getLocalActvidade());
            stmt.setBoolean(6, c.isVerificado());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!".toUpperCase());
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi gravar os dados!\nErro: ".toUpperCase() + ex);
            throw new RuntimeException();
        }
    }

    //listar convites
    public List<Convite> listarDados() {
        List<Convite> convites = new ArrayList<>();
        try {
            PreparedStatement stmt = this.conn.prepareStatement("select * from convites order by nome");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Convite c = new Convite();
                c.setIdConvite(rs.getLong("idConvite"));
                c.setNome(rs.getString("nome"));
                c.setFoto(rs.getString("foto"));
                c.setData(rs.getString("data"));
                c.setHora(rs.getString("hora"));
                c.setLocalActvidade(rs.getString("local_actvidade"));
                c.setVerificado(rs.getBoolean("verificado"));
                convites.add(c);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: ".toUpperCase() + ex);
            throw new RuntimeException();
        }
        return convites;
    }

    //alterar dados dos convites
    public void alterar(Convite c) {
        try {
            String sql = "update convites set nome=?, data=?, hora=?, local_actvidade=? where idConvite=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getData());
            stmt.setString(3, c.getHora());
            stmt.setString(4, c.getLocalActvidade());
            stmt.setLong(5, c.getIdConvite());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!".toUpperCase());
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi alterar os dados!\nErro: ".toUpperCase() + ex);
            throw new RuntimeException();
        }
    }
    

    //apagar dados
    public void apagar(Convite c) {
        try {
            String sql = "delete from convites where idConvite=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, c.getIdConvite());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!".toUpperCase());
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi excluir os dados!\nErro: ".toUpperCase() + ex);
            throw new RuntimeException();
        }
    }
    
    //confirmar convite
    public void confirmarConvite(Convite c) {
        try {
            String sql = "update convites set verificado=? where idConvite=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1, c.isVerificado());
            stmt.setLong(2, c.getIdConvite());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Convite Confirmado!".toUpperCase());
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi alterar os dados!\nErro: ".toUpperCase() + ex);
            throw new RuntimeException();
        }
    }

}
