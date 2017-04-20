package abdi.formulario.delegate;

import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IMensagemMBean;
import abdi.formulario.locator.EscolaServiceLocator;
import abdi.formulario.locator.Locator;
import abdi.formulario.log.AplicacaoLogger;
import abdi.formulario.mensageria.vo.MensagemAuditoria;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

/**
 * Acesso aos servicos de auditoria ejb.
 *
 * @author Rogerio.Rodrigues
 */
public class AuditoriaDelegate extends AplicacaoDelegate implements IAplicacaoDelegate<IMensagemMBean> {

    @Inject
    @Locator
    private EscolaServiceLocator locator;

    /**
     * Metodo responsavel por listar as mensagens de auditoria.
     * @return Lista de mensagens.
     */
    public List<MensagemAuditoria> listar() {
        try {
            return IMensagemMBean.class.cast(locator.localizarAuditoriaBean()).listar();
        } catch (LocalizarObjetoException excecao) {
            AplicacaoLogger.getLogger(AuditoriaDelegate.class).error("Erro ao obter as mensagens.", excecao);
            throw new RuntimeException(excecao);
        }
    }

}
