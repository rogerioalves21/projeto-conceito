package br.com.sicoob.sisbr.resource;

import br.com.sicoob.sisbr.ReqRestDTO;

public class MeuNome extends ReqRestDTO {
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
