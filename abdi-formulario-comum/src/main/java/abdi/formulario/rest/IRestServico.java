package abdi.formulario.rest;

import abdi.formulario.excecao.*;
import abdi.formulario.dto.RequisicaoRestDTO;

/**
 * Define o comportamento do lookup de um serviço rest.
 * @author Rogério Alves Rodrigues
 */
public interface IRestServico {

    /**
     * Consome um serviço rest.
     * @param requisicao Requisição do serviço.
     * @param tipoRetorno tipo do retorno a ser convertido.
     * @throws LocalizarObjetoException Erro ao localizar o serviço.
     */
    public Object consumir(RequisicaoRestDTO requisicao, Class< ? > tipoRetorno) throws LocalizarObjetoException;

}
