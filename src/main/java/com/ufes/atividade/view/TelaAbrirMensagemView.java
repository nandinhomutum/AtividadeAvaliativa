/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ufes.atividade.view;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Administrador
 */
@SuppressWarnings("serial")
public class TelaAbrirMensagemView extends javax.swing.JFrame {

    /**
     * Creates new form TelaAbrirMensagemView
     */
    public TelaAbrirMensagemView() {
        initComponents();
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlRemetente = new javax.swing.JLabel();
        jtTexto = new javax.swing.JLabel();
        jbNaoLido = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Remetente");

        jlRemetente.setText("jLabel3");

        jtTexto.setText("jLabel4");

        jbNaoLido.setText("Marca como Não Lida");

        jbSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbNaoLido)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)
                        .addComponent(jlRemetente)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlRemetente))
                .addGap(26, 26, 26)
                .addComponent(jtTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNaoLido)
                    .addComponent(jbSair))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getJbNaoLido() {
        return jbNaoLido;
    }

    public void setJbNaoLido(JButton jbNaoLido) {
        this.jbNaoLido = jbNaoLido;
    }

    public JButton getJbSair() {
        return jbSair;
    }

    public void setJbSair(JButton jbSair) {
        this.jbSair = jbSair;
    }

    public JLabel getJlRemetente() {
        return jlRemetente;
    }

    public void setJlRemetente(JLabel jlRemetente) {
        this.jlRemetente = jlRemetente;
    }

    public JLabel getJtTexto() {
        return jtTexto;
    }

    public void setJtTexto(JLabel jtTexto) {
        this.jtTexto = jtTexto;
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbNaoLido;
    private javax.swing.JButton jbSair;
    private javax.swing.JLabel jlRemetente;
    private javax.swing.JLabel jtTexto;
    // End of variables declaration//GEN-END:variables
}
