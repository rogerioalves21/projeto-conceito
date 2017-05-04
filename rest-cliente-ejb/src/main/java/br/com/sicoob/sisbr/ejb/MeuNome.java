package br.com.sicoob.sisbr.ejb;

import java.io.Serializable;

public class MeuNome extends ReqRestDTO {
  
  public static final long serialVersionUID = 1L; 
  
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
