package com.ufes.atividade.business.status;

import com.ufes.atividade.model.Usuario;

public abstract class StatusState {
	
	protected String autorizado;

	public String isAutorizado() {
		return autorizado;
	}
	
	public abstract void mudaEstado(Usuario usuario);

}
