/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.presenter;

import com.ufes.atividade.dao.MensagemDAO;
import com.ufes.atividade.dao.UsuarioDAO;
import com.ufes.atividade.model.Mensagem;
import com.ufes.atividade.model.Usuario;
import com.ufes.atividade.view.TelaAbrirMensagemView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LerMensagemPresenter {

    private TelaAbrirMensagemView view;

    public LerMensagemPresenter(Mensagem msg) {

        configurarTela(msg);

        String status = "Lida";
        MensagemDAO.getMensagemDAOInstance().mudarStatus(msg, status);

        view.getJbSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int id = msg.getDestinatario();

                Usuario user = UsuarioDAO.getUsuarioDAOInstance().getId(id);
                new PrincipalPresenter(user);
                view.dispose();

            }

        });

        view.getJbNaoLido().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String status = "Nao Lida";
                MensagemDAO.getMensagemDAOInstance().mudarStatus(msg, status);

                int id = msg.getDestinatario();

                Usuario user = UsuarioDAO.getUsuarioDAOInstance().getId(id);
                new PrincipalPresenter(user);
                view.dispose();

            }

        });
    }

    private void configurarTela(Mensagem msg) {
        this.view = new TelaAbrirMensagemView();
        this.view.setVisible(true);
        preencherTela(msg);

    }

    private void preencherTela(Mensagem msg) {

        int id = msg.getRementente();
        Usuario user = UsuarioDAO.getUsuarioDAOInstance().getId(id);
        view.getJlRemetente().setText(user.getLogin());
        view.getJtTexto().setText(msg.getTexto());

    }

}
