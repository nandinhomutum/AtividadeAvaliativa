/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.atividade.view;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author nandi
 */
@SuppressWarnings("serial")
public class TelaPrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalView
     */
    public TelaPrincipalView() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jlUsuario = new javax.swing.JLabel();
        jLTipo = new javax.swing.JLabel();
        jLHora = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAcceptUser = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuLerMensagem = new javax.swing.JMenuItem();
        menuSendMensagem = new javax.swing.JMenuItem();
        logMenu = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de gestão de pessoas");

        jlUsuario.setText("jLabel1");

        jLTipo.setText("jLabel1");

        jLHora.setText("jLabel1");

        jDesktopPane1.setLayer(jlUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLTipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLHora, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlUsuario)
                .addGap(191, 191, 191)
                .addComponent(jLTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(jLHora, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(363, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlUsuario)
                    .addComponent(jLTipo)
                    .addComponent(jLHora))
                .addContainerGap())
        );

        jMenu1.setText("Usuarios");

        menuAcceptUser.setText("Aceitar Usuario");
        menuAcceptUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcceptUserActionPerformed(evt);
            }
        });
        jMenu1.add(menuAcceptUser);

        jMenuBar2.add(jMenu1);

        jMenu2.setText("Mensagens");

        menuLerMensagem.setText("Ler Mensagens");
        jMenu2.add(menuLerMensagem);

        menuSendMensagem.setText("Enviar Mensagem");
        menuSendMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSendMensagemActionPerformed(evt);
            }
        });
        jMenu2.add(menuSendMensagem);

        jMenuBar2.add(jMenu2);

        logMenu.setText("Log");
        jMenuBar2.add(logMenu);

        jMenuSair.setText("Sair");
        jMenuBar2.add(jMenuSair);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSendMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSendMensagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSendMensagemActionPerformed

    private void menuAcceptUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcceptUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAcceptUserActionPerformed

    public JLabel getjLHora() {
        return jLHora;
    }

    public void setjLHora(JLabel jLHora) {
        this.jLHora = jLHora;
    }

    public JLabel getjLTipo() {
        return jLTipo;
    }

    public void setjLTipo(JLabel jLTipo) {
        this.jLTipo = jLTipo;
    }

    public JLabel getJlUsuario() {
        return jlUsuario;
    }

    public void setJlUsuario(JLabel jlUsuario) {
        this.jlUsuario = jlUsuario;
    }

    public JMenuItem getMenuAcceptUser() {
        return menuAcceptUser;
    }

    public void setMenuAcceptUser(JMenuItem menuAcceptUser) {
        this.menuAcceptUser = menuAcceptUser;
    }


    public JMenuItem getMenuLerMensagem() {
        return menuLerMensagem;
    }

    public void setMenuLerMensagem(JMenuItem menuLerMensagem) {
        this.menuLerMensagem = menuLerMensagem;
    }

    public JMenuItem getMenuSendMensagem() {
        return menuSendMensagem;
    }

    public void setMenuSendMensagem(JMenuItem menuSendMensagem) {
        this.menuSendMensagem = menuSendMensagem;
    }

    public JMenu getjMenuSair() {
        return jMenuSair;
    }

    public void setjMenuSair(JMenu jMenuSair) {
        this.jMenuSair = jMenuSair;
    }

    public JMenu getLogMenu() {
        return logMenu;
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLTipo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JMenu logMenu;
    private javax.swing.JMenuItem menuAcceptUser;
    private javax.swing.JMenuItem menuLerMensagem;
    private javax.swing.JMenuItem menuSendMensagem;
    // End of variables declaration//GEN-END:variables
}
