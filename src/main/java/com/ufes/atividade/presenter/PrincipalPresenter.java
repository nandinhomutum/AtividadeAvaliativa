/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.atividade.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ufes.atividade.model.Usuario;
import com.ufes.atividade.utilidades.GerenciadorDeLog;
import com.ufes.atividade.view.TelaPrincipalView;

/**
 *
 * @author nandi
 */
public class PrincipalPresenter {

    private TelaPrincipalView view;

    public PrincipalPresenter(Usuario user) {
        configurarTela(user);

     

        view.getMenuAcceptUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                new AceitarUsuarioPresenter(user);

            }
        });
        view.getMenuSendMensagem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                new EnviarMensagemPresenter(user);

                view.dispose();

            }
        });

        view.getMenuLerMensagem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                new ListarMensagemPresenter(user);

            }
        });

        view.getLogMenu().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                abrirLog();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });

        view.getLogMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                abrirLog();
            }
        });

    }

    private void configurarTela(Usuario user) {
        this.view = new TelaPrincipalView();
        this.view.setVisible(true);

        Date data = new Date();
        DateFormat formato = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = formato.format(data);
        view.getJlUsuario().setText(user.getLogin());
        view.getjLTipo().setText(user.getTipo());
        view.getjLHora().setText(formattedDate);
    }

    private void abrirLog() {
        GerenciadorDeLog.getInstance().abrirArquivoDeLog();
    }

}
