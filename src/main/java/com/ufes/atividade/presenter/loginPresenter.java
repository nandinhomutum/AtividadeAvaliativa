/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ufes.atividade.business.status.validadorStatus;
import com.ufes.atividade.business.login.validadorSenha;
import com.ufes.atividade.dao.UsuarioDAO;
import com.ufes.atividade.utilidades.GerenciadorDeLog;
import com.ufes.atividade.view.TelaLoginView;

/**
 *
 * @author Administrador
 */
public class loginPresenter {

    private TelaLoginView view;

    public loginPresenter() {
        configurarTela();

        view.getJbLogar().addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            @Override
            public void actionPerformed(ActionEvent ae) {

                String login = view.getJtLogin().getText();
                char[] senha = view.getJtSenha().getPassword();
                String senhapassada = String.valueOf(senha);

                if (validadorSenha.getInstance().valida(login, senhapassada)) {
                    if (validadorStatus.getInstance().valida(login)) {
                        GerenciadorDeLog.getInstance().registraInfo("Usuario " + login + " fez login");
                        new PrincipalPresenter(UsuarioDAO.getUsuarioDAOInstance().getLogin(view.getJtLogin().getText()));
                        view.dispose();
                    } else {
                        new JOptionPane().showMessageDialog(new JFrame(), "Aguarde enquanto algum administrador aceite sua solicitação!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    new JOptionPane().showMessageDialog(new JFrame(), "Senha Inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        view.getJbCriar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CriarUsuarioPresenter();
            }

        });

    }

    private void configurarTela() {

        this.view = new TelaLoginView();
        this.view.setVisible(true);
    }

}
