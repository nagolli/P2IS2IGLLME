/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P4;

import static java.lang.Math.random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ignacio
 */
public class Contenedor2Test
{

    @Test
    public void testSumarPaquete()
    {
        int size;
        Contenedor2 c = new Contenedor2(1000, 1000);
        Paquete p = new Paquete(10, 4);
        size = c.vecPaquetes.size();
        c.sumarPaquete(p);
        if (size + 1 != c.vecPaquetes.size()) {
            fail("el test falla");
        }
        int aux = (int) (random() % 10);
        for (int i = 0; i < aux; i++) {
            c.sumarPaquete(p);
        }
        if (size + 1 + aux != c.vecPaquetes.size()) {
            fail("el test falla");
        }

        c = new Contenedor2(0, 0);
        c.sumarPaquete(p);
        if (1 == c.vecPaquetes.size()) {
            fail("el test falla, no previene insercion si hay exceso de tamaño");
        }
    }

    @Test
    public void testContarPaquetes()
    {
        Contenedor2 c = new Contenedor2(0, 0);
        Paquete p = new Paquete(10, 4);
        int aux = (int) (random() % 10);
        for (int i = 0; i < aux; i++) {
            c.sumarPaquete(p);
        }
        if (aux != c.contarPaquetes()) {
            fail("el test falla");
        }
    }

    @Test
    public void testCalculaAreaPaquete()
    {
        int anchoP;
        int altoP;
        Paquete p;
        for (int i = 0; i < 10; i++) {
            anchoP = (int) (random() * 10) + 1;
            altoP = (int) (random() * 10) + 1;
            p = new Paquete(anchoP, altoP);
            if (anchoP * altoP != p.calcularArea()) {
                fail("el test falla");
            }
        }
    }

    @Test
    public void testAreaTotalPaquetes()
    {
        int anchoP;
        int altoP;
        int suma = 0;
        Paquete p;
        Contenedor2 c = new Contenedor2(1000, 1000);
        for (int i = 0; i < 10; i++) {
            anchoP = (int) (random() * 10) + 1;
            altoP = (int) (random() * 10) + 1;
            p = new Paquete(anchoP, altoP);
            c.sumarPaquete(p);
            suma += anchoP * altoP;
        }
        if (suma != c.areaTotalPaquetes()) {
            fail("el test falla");
        }
    }


    @Test
    public void testEspacioSobrante()
    {
        int anchoP;
        int altoP;
        int suma = 0;
        Paquete p;
        /* Funciona de ambas maneras
        Contenedor2 c = new Contenedor2();
        c.setAncho(100);
        c.setAlto(1000);
        */
        Contenedor2 c = new Contenedor2(100,1000);
        for (int i = 0; i < 10; i++) {
            anchoP = (int) (random() * 10) + 1;
            altoP = (int) (random() * 10) + 1;
            p = new Paquete(anchoP, altoP);
            c.sumarPaquete(p);
            suma += anchoP * altoP;
        }
        if (100000-suma != c.espacioSobrante()) {
            fail("el test falla");
        }
    }

}
