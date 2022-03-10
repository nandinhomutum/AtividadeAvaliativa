package com.ufes.atividade.business.status;

import com.ufes.atividade.model.Usuario;

public class DesautorizadoState extends StatusState {

    public DesautorizadoState() {
        this.autorizado = "nao";
    }

    @Override
    public void mudaEstado(Usuario usuario) {
        
    }
	
	

	

}
