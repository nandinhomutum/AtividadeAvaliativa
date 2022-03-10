package com.ufes.atividade.presenter;

import com.ufes.atividade.business.UsuarioBusiness;
import com.ufes.atividade.business.status.StatusEnum;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.ufes.atividade.dao.UsuarioDAO;
import com.ufes.atividade.model.Usuario;
import com.ufes.atividade.view.TelaAceitarUsuarioView;

public class AceitarUsuarioPresenter {

    private TelaAceitarUsuarioView view;
    private UsuarioBusiness business;

    public AceitarUsuarioPresenter(Usuario user) {
        this.business = new UsuarioBusiness();
        configurarTela(user);

       

    }

    private void configurarTela(Usuario user) {
        this.view = new TelaAceitarUsuarioView();
        preencherTabela();
        
        
         view.getJbSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                sair(user);
            }
        });

        view.getJbAceitar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                AceitarUsuario();

            }

        });
        view.setVisible(true);
    }

    private void AceitarUsuario() {
        int linha = view.getJtbUsuarios().getSelectedRow();
        int id = ((int) view.getJtbUsuarios().getValueAt(linha, 0));
        business.aceitarUsuario(id);
    }

    private void sair(Usuario user) {
        new PrincipalPresenter(user);
        view.dispose();
    }

    private void preencherTabela() {
        DefaultTableModel tabela = (DefaultTableModel) view.getJtbUsuarios().getModel();
        String status = "BLOQUEADO";

        List<Usuario> listaUsuario = UsuarioDAO.getUsuarioDAOInstance().getAll();
        for (Usuario usuario : listaUsuario) {
            if (StatusEnum.DESAUTORIZADO.getStatus().equals(usuario.getStatus())) {
                tabela.addRow(new Object[]{usuario.getId(),
                    usuario.getLogin(),
                    usuario.getStatus().isAutorizado(),
                    usuario.getData()
                });
            }

        }
        view.getJtbUsuarios().setModel(tabela);
    }

}
