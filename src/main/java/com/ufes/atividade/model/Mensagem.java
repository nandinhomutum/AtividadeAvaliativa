/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.model;

/**
 *
 * @author Administrador
 */
public class Mensagem {
    
    private int id;
    private String texto;
    private int rementente;
    private int destinatario;
    private String status;

    public Mensagem(String texto, int rementente, int destinatario, String status) {
        this.texto = texto;
        this.rementente = rementente;
        this.destinatario = destinatario;
        this.status = status;
    }

    public Mensagem(int id, String texto, int rementente, int destinatario, String status) {
        this.id = id;
        this.texto = texto;
        this.rementente = rementente;
        this.destinatario = destinatario;
        this.status = status;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getRementente() {
        return rementente;
    }

    public void setRementente(int rementente) {
        this.rementente = rementente;
    }

    public int getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(int destinatario) {
        this.destinatario = destinatario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
