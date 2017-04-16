package abdi.formulario.mensageria.vo;

import abdi.formulario.entidades.AplicacaoEntidade;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class MensagemAuditoria extends AplicacaoEntidade {

    private static final long serialVersionUID = 1662324250124206359L;
    private String conteudo;

    /**
     * @return the conteudo
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo the conteudo to set
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
