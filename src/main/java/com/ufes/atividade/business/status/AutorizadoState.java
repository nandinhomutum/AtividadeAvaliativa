package com.ufes.atividade.business.status;

import com.ufes.atividade.model.Usuario;

public class AutorizadoState extends StatusState {

    public AutorizadoState() {
        this.autorizado = "sim";
    }

    @Override
    public void mudaEstado(Usuario usuario) {
    }
	
	

	

}
