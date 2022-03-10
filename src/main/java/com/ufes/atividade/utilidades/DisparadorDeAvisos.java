package com.ufes.atividade.utilidades;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DisparadorDeAvisos {
	
	private DisparadorDeAvisos() {
    }
    
    public static DisparadorDeAvisos getInstance() {
        return DisparadorDeAvisosHolder.INSTANCE;
    }
    
    private static class DisparadorDeAvisosHolder {

        private static final DisparadorDeAvisos INSTANCE = new DisparadorDeAvisos();
    }
    
    @SuppressWarnings("static-access")
	public void disparaErro(String menssagem) {
    	new JOptionPane().showMessageDialog(new JFrame(),menssagem,"Erro",JOptionPane.ERROR_MESSAGE);
    }
    
    @SuppressWarnings("static-access")
	public void disparaAviso(String menssagem) {
    	new JOptionPane().showMessageDialog(new JFrame(),menssagem,"Aviso",JOptionPane.WARNING_MESSAGE);
    }
    
    @SuppressWarnings("static-access")
	public void disparaInfo(String menssagem) {
    	new JOptionPane().showMessageDialog(new JFrame(),menssagem,"Aviso",JOptionPane.INFORMATION_MESSAGE);
    }
}
