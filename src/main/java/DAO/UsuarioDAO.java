/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author danilo.asilv10
 */
public class UsuarioDAO {
    
    public List<Usuario> read() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_usuarios");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setTipo(rs.getString("tipo"));
                usuarios.add(u);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return usuarios;
    }

    public void create(Usuario u) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_usuarios(nome, login, senha, tipo) VALUES (?,?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTipo());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

    public void update(Usuario u) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_usuarios SET nome = ?, login = ?, senha = ?, tipo = ? WHERE id = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTipo());
            stmt.setInt(5, u.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

    public void delete(Usuario u) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbl_usuarios WHERE id = ?");
            stmt.setInt(1, u.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario removido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover: " + e);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }
    
}
