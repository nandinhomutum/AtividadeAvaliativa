/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.business.status;

import com.ufes.atividade.dao.UsuarioDAO;
import com.ufes.atividade.model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class validadorStatus {
    
      private validadorStatus() {
    }
    
    public static validadorStatus getInstance() {
        return validadorStatusHolder.INSTANCE;
    }
    
    private static class validadorStatusHolder {

        private static final validadorStatus INSTANCE = new validadorStatus();
    }
    
    public Boolean valida(String log){
        
        Usuario user = UsuarioDAO.getUsuarioDAOInstance().getLogin(log);
       
        
        if(StatusEnum.AUTORIZADO.getStatus().equals(user.getStatus()))
            return true;
        else 
            return false;
    }
    
}
