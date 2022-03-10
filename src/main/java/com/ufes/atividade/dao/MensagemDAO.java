/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ufes.atividade.model.Mensagem;
import com.ufes.atividade.presenter.PrincipalPresenter;
import com.ufes.atividade.utilidades.DisparadorDeAvisos;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MensagemDAO implements DAOInterface<Mensagem>{
    
    private static MensagemDAO INSTANCE;
    Connection conn = Conexao.getInstance().connect();
    

    public MensagemDAO() {
    }
    
    public static MensagemDAO getMensagemDAOInstance() {

        if (INSTANCE == null) {
            INSTANCE = new MensagemDAO();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }

    @SuppressWarnings("static-access")
	@Override
    public Mensagem getId(int id){
         try {
        String sql = "SELECT * FROM mensagem WHERE idMensagem = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if(!rs.next())
             new JOptionPane().showMessageDialog(new JFrame(),"Mensagem Inválida!","Aviso",JOptionPane.WARNING_MESSAGE);
        
        rs = stmt.executeQuery(); 
        Mensagem msg = new Mensagem(rs.getInt("idMensagem"),
                rs.getString("texto"),
                rs.getInt("idDestinatario"),
                rs.getInt("idRementente"),
                rs.getString("status"));
                
        return msg;
        } catch (SQLException ex) {
            DisparadorDeAvisos.getInstance().disparaErro(ex.getMessage());
                   return null; 
                }
        
    }

    @Override
    public void save(Mensagem msg) {
         try {
             String sql = "INSERT INTO mensagem (texto, status, idDestinatario, idRementente) VALUES (?,?,?,?)";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt = conn.prepareStatement(sql);
          stmt.setString(1, msg.getTexto());
          stmt.setString(2, msg.getStatus());
          stmt.setInt(3, msg.getDestinatario());
          stmt.setInt(4, msg.getRementente());
          stmt.execute(); 
        } catch (SQLException ex) {
            DisparadorDeAvisos.getInstance().disparaErro(ex.getMessage());
                }
    }

    @Override
    public void update(Mensagem obj){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Mensagem> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Mensagem> getAllDestinatario(int id) { 
        try {
        ArrayList<Mensagem> msg = new ArrayList<Mensagem>();
        String sql = "SELECT * FROM mensagem where idDestinatario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
       
       while(rs.next()){
           Mensagem mensagem = new Mensagem(rs.getInt("idMensagem"),
                rs.getString("texto"),
                rs.getInt("idDestinatario"),
                rs.getInt("idRementente"),
                rs.getString("status"));
           msg.add(mensagem);
           
       }
       
       return msg;
       } catch (SQLException ex) {
           DisparadorDeAvisos.getInstance().disparaErro(ex.getMessage());
                   return null; 
                }
    }
    
    public void mudarStatus(Mensagem msg, String stat){
        try{
        int id = msg.getId();
        String sql = "UPDATE mensagem SET status = ? WHERE idMensagem = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, stat);
        stmt.setInt(2,id);
        stmt.executeUpdate();
        } catch (SQLException ex) {
                  DisparadorDeAvisos.getInstance().disparaErro(ex.getMessage());
                }
    }
    
    
}
