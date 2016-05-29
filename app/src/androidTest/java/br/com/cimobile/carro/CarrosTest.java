package br.com.cimobile.carro;

import android.content.Context;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

import br.com.cimobile.carro.domain.Carro;
import br.com.cimobile.carro.service.CarroService;

/**
 * Created by saturnino on 29/05/2016.
 */
public class CarrosTest extends TestCase{
    Context mContext;

    Context getContext() {
        return mContext;
    }

    public void testCarros() throws IOException {
        Context context = getContext();
        List<Carro> carros = CarroService.getCarros(context, Carro.TIPO_ESPORTIVOS);
        assertNotNull(carros);
        assertTrue(carros.size() > 0);
        Carro c1 = carros.get(0);
        assertEquals("Ferrari FF", c1.nome);
    }

}
