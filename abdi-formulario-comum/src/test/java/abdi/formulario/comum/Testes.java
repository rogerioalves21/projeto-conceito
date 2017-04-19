package abdi.formulario.comum;

import org.junit.Assert;
import org.junit.Test;

import abdi.formulario.dto.CriteriosConsultaDTO;

public class Testes {

    @Test
    public void devePopularDados() {
        CriteriosConsultaDTO criterios = new CriteriosConsultaDTO();
        criterios.getDados().put("codigo", 1);
        Assert.assertEquals(1, criterios.getDados().get("codigo"));
    }

}