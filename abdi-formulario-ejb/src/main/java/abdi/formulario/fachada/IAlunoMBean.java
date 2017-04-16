/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdi.formulario.fachada;

import abdi.entidades.Aluno;
import abdi.formulario.dto.CriteriosConsultaDTO;
import abdi.formulario.excecao.AplicacaoException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Remote
public interface IAlunoMBean extends IAplicacaoMBean {
    
    List<Aluno> listar();

    void incluir(Aluno aluno) throws AplicacaoException;
    
     List<Aluno> procurar(CriteriosConsultaDTO criterios);
}
