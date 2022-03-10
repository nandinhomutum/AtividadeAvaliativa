/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.ufes.atividade.dao.MensagemDAO;
import com.ufes.atividade.dao.UsuarioDAO;
import com.ufes.atividade.model.Mensagem;
import com.ufes.atividade.model.Usuario;
import com.ufes.atividade.utilidades.ManipuladorComboBox;
import com.ufes.atividade.view.TelaEnviarMensagemView;

public class EnviarMensagemPresenter {

    private TelaEnviarMensagemView view;

    public EnviarMensagemPresenter(Usuario user) {
        configurarTela();

        view.getJbEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                enviarMensagem(user);

            }
        ;
        });
           view.getJbSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                new PrincipalPresenter(user);
                view.dispose();

            }

        });

    }

    private void enviarMensagem(Usuario user) {

        String texto = view.getJtMensagem().getText();
        int remetente = user.getId();
        String status = "Nao Lida";

        if (view.getJcbDestinatario().getSelectedItem().toString().equals("Todos")) {
            ArrayList<String> usuarios = new ArrayList<>();
            List<Usuario> listaUsuario = UsuarioDAO.getUsuarioDAOInstance().getAll();
            listaUsuario.forEach(usuario -> {
                Mensagem msg = new Mensagem(texto, remetente, usuario.getId(), status);

                gravarMensagem(msg);

            });

        } else {
            String destinatario = view.getJcbDestinatario().getSelectedItem().toString();
            Usuario destinataioPego = UsuarioDAO.getUsuarioDAOInstance().getLogin(destinatario);
            Mensagem msg = new Mensagem(texto, remetente, destinataioPego.getId(), status);
            gravarMensagem(msg);

        }

    }

    private void configurarTela() {

        this.view = new TelaEnviarMensagemView();
        this.view.setVisible(true);
        preencherComboBox();
    }

    private void preencherComboBox() {
        ArrayList<String> usuarios = new ArrayList<>();
        List<Usuario> listaUsuario = UsuarioDAO.getUsuarioDAOInstance().getAll();
        usuarios.add("Todos");
        listaUsuario.forEach(user -> {
            usuarios.add(user.getLogin());
        });
        ManipuladorComboBox.getInstance().PreencherComboBox(usuarios, view.getJcbDestinatario());
    }

    private void gravarMensagem(Mensagem msg) {
        MensagemDAO.getMensagemDAOInstance().save(msg);
    }

}
