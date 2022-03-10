/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.presenter;

import com.ufes.atividade.dao.MensagemDAO;
import com.ufes.atividade.dao.UsuarioDAO;
import com.ufes.atividade.model.Mensagem;
import com.ufes.atividade.model.Usuario;
import com.ufes.atividade.view.TelaExibirMensagensView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ListarMensagemPresenter {

    private TelaExibirMensagensView view;

    public ListarMensagemPresenter(Usuario user) {
        configurarTela(user);

    }

    private void configurarTela(Usuario user) {
        this.view = new TelaExibirMensagensView();
        preencherTabela(user.getId());
        this.view.setVisible(true);

        view.getJbSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.dispose();
            }
        });

        view.getJbNaoLidas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                buscarNaoLidas(user.getId());

            }
        });

        view.getJbLerMensagem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Mensagem msg = pegarMensagem();
                new LerMensagemPresenter(msg);

            }
        });

    }

    private void preencherTabela(int id) {
        DefaultTableModel tabela = (DefaultTableModel) view.getJtMensagens().getModel();

        List<Mensagem> listaMensagem = MensagemDAO.getMensagemDAOInstance().getAllDestinatario(id);
        for (Mensagem msg : listaMensagem) {
            Usuario user = UsuarioDAO.getUsuarioDAOInstance().getId(msg.getDestinatario());
            tabela.addRow(new Object[]{msg.getId(),
                msg.getTexto(),
                msg.getStatus(),
                user.getLogin()
            });

        }
        view.getJtMensagens().setModel(tabela);
    }

    public Mensagem pegarMensagem() {
        //DefaultTableModel tabela = (DefaultTableModel) view.getTbFuncionarios().getModel();
        int linha = view.getJtMensagens().getSelectedRow();

        int id = new Integer(view.getJtMensagens().getValueAt(linha, 0).toString());
        return MensagemDAO.getMensagemDAOInstance().getId(id);
    }

    private void buscarNaoLidas(int id) {
        ((DefaultTableModel) view.getJtMensagens().getModel()).setRowCount(0);
        String status = "Nao Lida";
        DefaultTableModel tabela = (DefaultTableModel) view.getJtMensagens().getModel();

        List<Mensagem> listaMensagem = MensagemDAO.getMensagemDAOInstance().getAllDestinatario(id);
        for (Mensagem msg : listaMensagem) {
            if (status.equals(msg.getStatus())) {
                Usuario user = UsuarioDAO.getUsuarioDAOInstance().getId(msg.getDestinatario());
                tabela.addRow(new Object[]{msg.getId(),
                    msg.getTexto(),
                    msg.getStatus(),
                    user.getLogin()
                });
            }
        }
        view.getJtMensagens().setModel(tabela);
    }

}
