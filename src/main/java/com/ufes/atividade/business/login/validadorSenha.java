
package com.ufes.atividade.business.login;

import java.sql.SQLException;

import com.ufes.atividade.dao.UsuarioDAO;
import com.ufes.atividade.model.Usuario;


public class validadorSenha {
    
    
    private validadorSenha() {
    }
    
    public static validadorSenha getInstance() {
        return validadorSenhaHolder.INSTANCE;
    }
    
    private static class validadorSenhaHolder {

        private static final validadorSenha INSTANCE = new validadorSenha();
    }
    
    public Boolean valida(String log, String senha){
        
        Usuario user = UsuarioDAO.getUsuarioDAOInstance().getLogin(log);
        
        System.out.println(user.getSenha());
        System.out.println(senha);
        if(senha.equals(user.getSenha()) && !user.getLoginState().isLogado())
        	user.getLoginState().mudaEstado(user);
        
        return user.getLoginState().isLogado();
    }
}


