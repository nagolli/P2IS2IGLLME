/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P4;

import org.junit.Test;
import static org.junit.Assert.*;
import P4.*;

/**
 *
 * @author Ignacio
 */
public class HistoricoContenedoresTest
{

    //@Test 
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSumarContenedor()
    {
        /*
        HistoricoContenedores h = new HistoricoContenedores();
        if (h.numeroContenedores() != 0) {
            fail("el test falla");
        }
        h.sumarContenedor(new Contenedor2(1,1));
        if (h.numeroContenedores() != 1) {
            fail("el test falla");
        }
        for(int i=0;i<101;i++)
        {
            h.sumarContenedor(new Contenedor2(1,1));
        }
        //No previene la insercion de contendedores una vez alcanzado el limite
        if (h.numeroContenedores() > 100) {
            fail("el test falla, exceso de contenedores");
        }
        */
        HistoricoContenedores h = new HistoricoContenedores();
        for(int i=0;i<101;i++)
        {
            h.sumarContenedor(new Contenedor2(1,1));
        }
        
    }

    @Test
    public void testContenedorMasGrande()
    {
        HistoricoContenedores h = new HistoricoContenedores();
        Contenedor2 cR;
        Contenedor2 c1 = new Contenedor2(100,100);
        Contenedor2 c2 = new Contenedor2(10,10);
        Contenedor2 c3 = new Contenedor2(100,10);
        h.sumarContenedor(c1);
        h.sumarContenedor(c2);
        h.sumarContenedor(c3);
        cR=h.contenedorMasGrande();
        if (cR!=c1) {
            fail("el test falla");
        }
    }

    @Test
    public void testSumarPaquete()
    {
        HistoricoContenedores h = new HistoricoContenedores();
        Contenedor2 c1 = new Contenedor2(10,10);
        Contenedor2 c2 = new Contenedor2(10,10);
        h.sumarPaquete(new Paquete(1,1));
        //No previene sumar un paquete cuando no hay contenedores
        h.sumarContenedor(c1);
        //Muestra error al añadir cualquier paquete a un contenedor
        h.sumarPaquete(new Paquete(1,1));
        h.sumarContenedor(c2);
        h.sumarPaquete(new Paquete(1,1));
        h.sumarPaquete(new Paquete(1,1));
        
        if (c1.contarPaquetes()!=1) {
            fail("el test falla");
        }
        if (c2.contarPaquetes()!=2) {
            fail("el test falla");
        }
    }
}
