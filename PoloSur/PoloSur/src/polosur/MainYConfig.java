/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polosur;

import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class MainYConfig
{
    /*
    *   Función de inicializado de datos
    */
    static private ArrayList<Integer> Config()
    {
        Pez pez=new Pez(1,1,1);
        Foca foca=new Foca(1,1);
        Morsa morsa=new Morsa(1,1);
        Oso oso=new Oso(1,1);
        Esquimal hombre=new Esquimal(1,1);
        ArrayList<ArrayList<Integer>> dietaPez = new ArrayList();
        ArrayList<ArrayList<Integer>> dietaFoca = new ArrayList();
        ArrayList<ArrayList<Integer>> dietaMorsa = new ArrayList();
        ArrayList<ArrayList<Integer>> dietaOso = new ArrayList();
        ArrayList<ArrayList<Integer>> dietaEsquimal = new ArrayList();
        ArrayList<Integer> valores = new ArrayList();;

            // Configuración inicial del programa:
            //Alimentacion diaria de peces
            dietaPez.add(new ArrayList(){{add(1);add(2);}});//min krill, max krill (en millones)
            dietaPez.add(new ArrayList(){{add(0);add(0);}});//min peces, max peces
            dietaPez.add(new ArrayList(){{add(0);add(0);}});//min focas, max focas
            dietaPez.add(new ArrayList(){{add(0);add(0);}});//min osos, max osos
            dietaPez.add(new ArrayList(){{add(0);add(0);}});//min morsas, max morsas
            dietaPez.add(new ArrayList(){{add(0);add(0);}});//min esquimales, max esquimales
            //Alimentacion diaria de focas
            dietaFoca.add(new ArrayList(){{add(0);add(0);}});//min krill, max krill (en millones)
            dietaFoca.add(new ArrayList(){{add(15);add(25);}});//min peces, max peces
            dietaFoca.add(new ArrayList(){{add(0);add(0);}});//min focas, max focas
            dietaFoca.add(new ArrayList(){{add(0);add(0);}});//min osos, max osos
            dietaFoca.add(new ArrayList(){{add(0);add(0);}});//min morsas, max morsas
            dietaFoca.add(new ArrayList(){{add(0);add(0);}});//min esquimales, max esquimales
            //Alimentacion diaria de morsas
            dietaMorsa.add(new ArrayList(){{add(0);add(0);}});//min krill, max krill (en millones)
            dietaMorsa.add(new ArrayList(){{add(0);add(0);}});//min peces, max peces
            dietaMorsa.add(new ArrayList(){{add(1);add(2);}});//min focas, max focas
            dietaMorsa.add(new ArrayList(){{add(0);add(2);}});//min osos, max osos
            dietaMorsa.add(new ArrayList(){{add(0);add(0);}});//min morsas, max morsas
            dietaMorsa.add(new ArrayList(){{add(0);add(0);}});//min esquimales, max esquimales
            //Alimentacion diaria de osos
            dietaOso.add(new ArrayList(){{add(0);add(0);}});//min krill, max krill (en millones)
            dietaOso.add(new ArrayList(){{add(10);add(15);}});//min peces, max peces
            dietaOso.add(new ArrayList(){{add(1);add(2);}});//min focas, max focas
            dietaOso.add(new ArrayList(){{add(0);add(0);}});//min osos, max osos
            dietaOso.add(new ArrayList(){{add(0);add(0);}});//min morsas, max morsas
            dietaOso.add(new ArrayList(){{add(0);add(0);}});//min esquimales, max esquimales
            //Alimentacion diaria de esquimales
            dietaEsquimal.add(new ArrayList(){{add(0);add(0);}});//min krill, max krill (en millones)
            dietaEsquimal.add(new ArrayList(){{add(2);add(4);}});//min peces, max peces
            dietaEsquimal.add(new ArrayList(){{add(0);add(1);}});//min focas, max focas
            dietaEsquimal.add(new ArrayList(){{add(0);add(0);}});//min osos, max osos
            dietaEsquimal.add(new ArrayList(){{add(0);add(0);}});//min morsas, max morsas
            dietaEsquimal.add(new ArrayList(){{add(0);add(0);}});//min esquimales, max esquimales
            //Configuración de estadisticas de especies
            //                 minIMC,  maxIMC, probReproduccion, ProbMuerte, dieta)                
            pez.Configurar(    55,      70,     185,              163,        dietaPez);
            foca.Configurar(   25,      32,     100,              90,         dietaFoca);
            morsa.Configurar(  30,      42,     98,               95,         dietaMorsa);
            oso.Configurar(    40,      55,     153,              95,         dietaOso);
            hombre.Configurar( 35,      48,     32,               24,         dietaEsquimal);
            //Seleccion de parametros de inicio
            valores.add(65000);valores.add(75000);//Min y Max de krill inicial (en millones)
            valores.add(7000);valores.add(8000);  //Min y Max de peces iniciales
            valores.add(260);valores.add(290);    //Min y Max de focas iniciales
            valores.add(42);valores.add(48);      //Min y Max de morsas iniciales
            valores.add(22);valores.add(28);      //Min y Max de osos polares iniciales
            valores.add(12);valores.add(14);      //Min y Max de esquimales iniciales
            valores.add(4);                       //Temperatura inicial del agua
            
        pez.destruir();
        foca.destruir();
        morsa.destruir();
        oso.destruir();
        hombre.destruir();
        
        return valores;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Integer> valores;
        valores=Config();
        Polo modelo=new Polo(valores);
        modelo.DiezDias();
        modelo.DiezDias();
        System.exit(0);
    }
    
}
