package com.ufes.atividade.business.status;

import com.ufes.atividade.business.status.AutorizadoState;
import com.ufes.atividade.business.status.DesautorizadoState;
import com.ufes.atividade.business.status.StatusState;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public enum StatusEnum {
    
    AUTORIZADO("sim"),
    DESAUTORIZADO("nao");
    private StatusState status;
    private String chave;
    
   StatusEnum( String chave){
        
      
      this.chave = chave;
      if("sim".equals(chave)){
          this.status = new AutorizadoState();
      } else if("nao".equals(chave)){
          this.status = new DesautorizadoState();
      }
        
    }
    public static StatusEnum getByChave(String chave){
      if("sim".equals(chave)){
          
          return AUTORIZADO;
      } else if("nao".equals(chave)){
          return DESAUTORIZADO;
      } else {
          return DESAUTORIZADO;
      }  
      
    }
    public StatusState getStatus() {
        return status;
    }

    public void setStatus(StatusState status) {
        this.status = status;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
    
}
