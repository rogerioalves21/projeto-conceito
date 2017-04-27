package abdi.formulario.fachada;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import abdi.formulario.cdi.LogInterceptor;
import abdi.formulario.dao.AlunoDao;
import abdi.formulario.dao.AlunoDaoImpl;
import abdi.formulario.dao.DaoFactory;

public class AlunoMBeanTest {

    private AlunoMBean pojo;

    @Before
    public void setUp() {
      this.pojo = new AlunoMBean();
    }

    @Test
    public final void deveDizerOla() throws Exception {
        Assert.assertEquals("Ola Rogerio", pojo.ola("Rogerio"));
    }
    
}
