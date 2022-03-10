package com.ufes.atividade.business.login;

import com.ufes.atividade.model.Usuario;

public abstract class LoginState {
	
	protected Boolean logado;

	public Boolean isLogado() {
		return logado;
	}
	
	public abstract void mudaEstado(Usuario usuario);

}
