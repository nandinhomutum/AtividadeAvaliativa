/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.atividade.model;

import com.ufes.atividade.business.status.DesautorizadoState;
import com.ufes.atividade.business.login.DeslogadoState;
import com.ufes.atividade.business.login.LoginState;
import com.ufes.atividade.business.status.StatusState;

/**
 *
 * @author Administrador
 */
public class Usuario {
    
    private int id;
    private String login;
    private String senha;
    private String tipo;
    private StatusState status;
    private String data;
    private LoginState loginState;

    public Usuario(String login, String senha, StatusState status, String tipo, String data) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.status = status;
        this.data = data;
        this.loginState = new DeslogadoState();
    }

    public Usuario(int id, String login, String senha, String tipo, StatusState status, String data) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.status = status;
        this.data = data;
        this.loginState = new DeslogadoState();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public StatusState getStatus() {
        return status;
    }

    public void setStatus(StatusState status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

	public LoginState getLoginState() {
		return loginState;
	}

	public void setLoginState(LoginState loginState) {
		this.loginState = loginState;
	}
}
