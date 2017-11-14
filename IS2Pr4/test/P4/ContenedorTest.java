/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P4;

import org.junit.Test;
import static org.junit.Assert.*;
import P4.*;
import static java.lang.Math.random;

/**
 *
 * @author Ignacio
 */
public class ContenedorTest
{

    @Test
    public void testContenedorIntInt()
    {
        /*
        // Voy a testear el funcionamiento de la creación de un contenedor usando el
        // constructor con parámetros, siendo el primer argumento el ancho y el segundo el alto
        Contenedor c = new Contenedor(10, 20);
        int ancho = c.getAncho();
        int alto = c.getAlto();
        // Comprobación:
        assertTrue(ancho == 20); Falla
        assertTrue(alto == 10);
        assertTrue(ancho == 10); Es correcto
        assertTrue(alto == 20);    
         */
 /*
        //Version 2
        int alto;
        int ancho;
        Contenedor c;
        for(int i=0;i<10;i++)
        {
        ancho=(int)(random()*100);
        alto=(int)(random()*100);
        c = new Contenedor(ancho, alto);
        // Comprobación:
        assertEquals(ancho,c.getAncho());
        assertEquals(alto,c.getAlto());
        }
         */
        //Version 3
        int alto;
        int ancho;
        Contenedor c;
        for (int i = 0; i < 10; i++) {
            ancho = (int) (random() * 100);
            alto = (int) (random() * 100);
            c = new Contenedor(ancho, alto);
            // Comprobación:
            if (ancho != c.getAncho() || alto != c.getAlto()) {
                fail("el test falla");
            }
        }

    }

    @Test
    public void testCalcularPerimetro()
    {
        int alto;
        int ancho;
        Contenedor c;
        for (int i = 0; i < 10; i++) {
            ancho = (int) (random() * 100);
            alto = (int) (random() * 100);
            c = new Contenedor(ancho, alto);
            if (c.getAncho() * 2 + c.getAlto() * 2 != c.calcularPerimetro()) {
                fail("el test falla");
            }
            c = new Contenedor(ancho, ancho);   //Caso cuadrado
            if (c.getAncho() * 4 != c.calcularPerimetro()) {
                fail("el test falla");
            }
        }
    }

    @Test
    public void testCalculaNumPaquete()
    {
        int altoC, anchoC, altoP, anchoP;
        Contenedor c;
        Paquete p;
        
        //Lo supera porque no hay espacio sobrante
        c = new Contenedor(200, 4);
        p = new Paquete(10, 4);
        if (c.calculaNumPaquete(p) == (20 * 4)) {
            fail("el test falla");
        }
        
        //Falla, no tiene en cuenta el tamaño minimo de alto/ancho de paquete
        c = new Contenedor(2, 200);
        p = new Paquete(4, 4);
        if (c.calculaNumPaquete(p) == 0) {
            fail("el test falla");
        }

        for (int i = 0; i < 10; i++) {
            anchoC = (int) (random() * 100);
            altoC = (int) (random() * 100);
            anchoP = (int) (random() * 10) + 1;
            altoP = (int) (random() * 10) + 1;
            c = new Contenedor(anchoC, altoC);
            p = new Paquete(anchoP, altoP);
            if (c.calculaNumPaquete(p) == ((anchoC / anchoP) * (altoC / altoP))) {
                fail("el test falla");
            }
        }

    }
    
    @Test
    public void testSobrantePaquete()
    {
        int altoC, anchoC, altoP, anchoP;
        Contenedor c;
        Paquete p;
        
        c = new Contenedor(200, 4);
        p = new Paquete(10, 4);
        if (c.sobrantePaquete(p) == 0) {
            fail("el test falla");
        }
        //Como es de esperar, al fallar el metodo anterior y este depende del anterior, falla
        //Al mirar el código la funcion final resulta más complicada de lo que debería
        c = new Contenedor(2, 200);
        p = new Paquete(4, 4);
        if (c.sobrantePaquete(p) == 2*200) {
            fail("el test falla");
        }

        for (int i = 0; i < 10; i++) {
            anchoC = (int) (random() * 100);
            altoC = (int) (random() * 100);
            anchoP = (int) (random() * 10) + 1;
            altoP = (int) (random() * 10) + 1;
            c = new Contenedor(anchoC, altoC);
            p = new Paquete(anchoP, altoP);
            if (c.sobrantePaquete(p) == (anchoC*altoC)-(anchoP*altoP*c.calculaNumPaquete(p))) {
                fail("el test falla");
            }
        }
    }
     
}
