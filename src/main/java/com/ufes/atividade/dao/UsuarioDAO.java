/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.dao;

import com.ufes.atividade.business.status.StatusEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ufes.atividade.model.Usuario;
import com.ufes.atividade.utilidades.GerenciadorDeLog;

public class UsuarioDAO implements DAOInterface<Usuario> {

    private static UsuarioDAO INSTANCE;
    Connection conn = Conexao.getInstance().connect();

    public UsuarioDAO() {
    }

    public static UsuarioDAO getUsuarioDAOInstance() {

        if (INSTANCE == null) {
            INSTANCE = new UsuarioDAO();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }

    @SuppressWarnings("static-access")
    @Override
    public Usuario getId(int id) {
        try {
            String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                new JOptionPane().showMessageDialog(new JFrame(), "Usuario Inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

            rs = stmt.executeQuery();
            Usuario usuarioSelecionado = new Usuario(rs.getInt("idUsuario"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("tipo"),
                    StatusEnum.getByChave(rs.getString("status")).getStatus(),
                    rs.getString("data"));
            return usuarioSelecionado;
        } catch (SQLException ex) {
            GerenciadorDeLog.getInstance().registraAviso(ex.getMessage());
            return null;
        }
    }

    @SuppressWarnings("static-access")
    @Override
    public void save(Usuario user) {
        try {
            String sql = "SELECT COUNT(*) AS EXISTE FROM USUARIO WHERE login = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getLogin());
            ResultSet rs = stmt.executeQuery();
            if (0 != rs.getInt("EXISTE")) {
                new JOptionPane().showMessageDialog(new JFrame(), "Já Existe um Usuário Cadastrado com este nome!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                sql = "INSERT INTO usuario (login, senha, tipo, status, data) VALUES (?,?,?,?,?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, user.getLogin());
                stmt.setString(2, user.getSenha());
                stmt.setString(3, user.getTipo());
                stmt.setString(4, user.getStatus().isAutorizado());
                stmt.setString(5, user.getData());
                stmt.execute();
            }
        } catch (SQLException ex) {
            GerenciadorDeLog.getInstance().registraAviso(ex.getMessage());

        }
    }

    @Override
    public void update(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateStatus(Usuario user) {
        try {
            int id = user.getId();
            String sql = "UPDATE usuario SET status = 'LIBERADO' WHERE idUsuario = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            GerenciadorDeLog.getInstance().registraAviso(ex.getMessage());

        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> getAll() {
        try {
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIO");
            while (rs.next()) {
                Usuario usu = new Usuario(rs.getInt("idUsuario"), rs.getString("login"), rs.getString("senha"), rs.getString("tipo"), StatusEnum.getByChave(rs.getString("status")).getStatus(), rs.getString("data"));
                usuarios.add(usu);

            }

            return usuarios;
        } catch (SQLException ex) {
            GerenciadorDeLog.getInstance().registraAviso(ex.getMessage());
            return null;
        }
    }

    @SuppressWarnings("static-access")
    public Usuario getLogin(String log) {
        try {
            String sql = "SELECT * FROM usuario WHERE login = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, log);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                new JOptionPane().showMessageDialog(new JFrame(), "Funcionario Inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

            rs = stmt.executeQuery();
            Usuario usuarioSelecionado = new Usuario(rs.getInt("idUsuario"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("tipo"),
                    StatusEnum.getByChave(rs.getString("status")).getStatus(),
                    rs.getString("data"));
            return usuarioSelecionado;
        } catch (SQLException ex) {
            GerenciadorDeLog.getInstance().registraAviso(ex.getMessage());
            return null;
        }
    }

}
