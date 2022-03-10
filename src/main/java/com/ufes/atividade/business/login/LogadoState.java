package com.ufes.atividade.business.login;

import com.ufes.atividade.model.Usuario;

public class LogadoState extends LoginState {
	
	

	public LogadoState() {
		super();
		this.logado = Boolean.TRUE;
	}

	@Override
	public void mudaEstado(Usuario usuario) {
		usuario.setLoginState(new DeslogadoState());
	}

}
