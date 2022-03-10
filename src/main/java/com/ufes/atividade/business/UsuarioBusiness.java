/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.atividade.business;

import com.ufes.atividade.business.status.StatusEnum;
import com.ufes.atividade.dao.UsuarioDAO;
import com.ufes.atividade.model.Usuario;
import com.ufes.atividade.utilidades.GerenciadorDeLog;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UsuarioBusiness {
    private UsuarioDAO dao = UsuarioDAO.getUsuarioDAOInstance();
    
    public void salvar(String login, String senha){
        String tipo = "USER";
                String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                Usuario user = new Usuario(login, senha, StatusEnum.DESAUTORIZADO.getStatus(),tipo , date);
                dao.save(user);
        String mensagem = "USUARIO CRIADO" + user.getLogin();
        GerenciadorDeLog.getInstance().registraInfo(mensagem);
    }
    
    public void aceitarUsuario(int id){
        Usuario user = dao.getId(id);

       dao.updateStatus(user);
       String mensagem = "USUARIO ACEITO " + user.getLogin();
        GerenciadorDeLog.getInstance().registraInfo(mensagem);
    }
    
}
