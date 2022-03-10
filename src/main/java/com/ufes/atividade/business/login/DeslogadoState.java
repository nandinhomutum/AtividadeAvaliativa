package com.ufes.atividade.business.login;

import com.ufes.atividade.model.Usuario;

public class DeslogadoState extends LoginState {
	
	

	public DeslogadoState() {
		super();
		this.logado = Boolean.FALSE;
	}

	@Override
	public void mudaEstado(Usuario usuario) {
		usuario.setLoginState(new LogadoState());
	}

}
