package com.ufes.atividade.utilidades;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerenciadorDeLog {
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	private GerenciadorDeLog() {
    }
    
    public static GerenciadorDeLog getInstance() {
        return RegistradorDeLogHolder.INSTANCE;
    }
    
    private static class RegistradorDeLogHolder {

        private static final GerenciadorDeLog INSTANCE = new GerenciadorDeLog();
    }
    
    public void abrirArquivoDeLog() {
		try {
			File log = new File("assets/log.txt");
			Desktop.getDesktop().edit(log);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
    
    public void registraInfo(String mensagem) {
    	String mensagemLog = "\n [" + LocalDateTime.now().format(formatter) + "] [INFO] " + mensagem; 
    	ManipuladorDeArquivoDeLog.getInstance().registra(mensagemLog);
    }
    
    public void registraAviso(String mensagem) {
    	String mensagemLog = "\n [" + LocalDateTime.now().format(formatter) + "] [AVISO] " + mensagem; 
    	ManipuladorDeArquivoDeLog.getInstance().registra(mensagemLog);
    }
    
    public void registraErro(String mensagem) {
    	String mensagemLog = "\n [" + LocalDateTime.now().format(formatter) + "] [ERRO] " + mensagem; 
    	ManipuladorDeArquivoDeLog.getInstance().registra(mensagemLog);
    }
}
