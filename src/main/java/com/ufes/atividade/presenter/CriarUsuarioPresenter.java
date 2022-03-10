/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.presenter;

import com.ufes.atividade.business.UsuarioBusiness;
import com.ufes.atividade.business.status.StatusEnum;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ufes.atividade.dao.UsuarioDAO;
import com.ufes.atividade.model.Usuario;
import com.ufes.atividade.view.TelaCriarLoginView;

public class CriarUsuarioPresenter {

    private TelaCriarLoginView view;
    private UsuarioBusiness business;

    public CriarUsuarioPresenter() {
        this.business = new UsuarioBusiness();
        configurarTela();
        
        
        
        

    }

    private void configurarTela() {
        this.view = new TelaCriarLoginView();
        this.view.setVisible(true);

        view.getJbCadastrar().addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent ae) {

                String login = view.getJtLogin().getText();
                String senha = view.getJtSenha().getText().toString();
                business.salvar(login, senha);
                new loginPresenter();
                view.dispose();
            }

        });

    }

}
