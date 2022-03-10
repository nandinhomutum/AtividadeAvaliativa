package com.ufes.atividade.utilidades;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManipuladorDeArquivoDeLog {
	
	private ManipuladorDeArquivoDeLog() {
    }
    
    public static ManipuladorDeArquivoDeLog getInstance() {
        return ManipuladorDeArquivoDeLogHolder.INSTANCE;
    }
    
    private static class ManipuladorDeArquivoDeLogHolder {

        private static final ManipuladorDeArquivoDeLog INSTANCE = new ManipuladorDeArquivoDeLog();
    }
    
    public void registra(String entrada) {
    	byte data[] = entrada.getBytes();
        Path p = Paths.get("assets/log.txt");

        try (OutputStream out = new BufferedOutputStream(
          Files.newOutputStream(p, CREATE, APPEND))) {
          out.write(data, 0, data.length);
        } catch (IOException e) {
          String msg = "Erro ao Registrar Log: \n"
        		  + e.getMessage();
          DisparadorDeAvisos.getInstance().disparaErro(msg);
          System.out.println(msg);
        }
    }

}
