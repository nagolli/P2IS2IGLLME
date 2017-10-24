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
public class Esquimal extends SerVivo
{
    private static int MinIMC;                          //constante de clase
    private static int MaxIMC;                          //constante de clase
    private static int probReproduccion; 		//valor de clase
    private static int probMuerte;                      //valor de clase
    private static ArrayList<ArrayList<Integer>> dieta; //valor de clase
    private static int cantidad;

    
    /*
    *   Constructor de la clase, hereda de SerVivo
    */
    public Esquimal(int IMC, int diaNacimiento)
    {
        super(IMC, diaNacimiento);
        Esquimal.cantidad=cantidad+1;
        ID=5;
    }
    
    /*
    * Setter de prob de reproduccion
    */
    @Override
    public void setReproduccion(int prob)
    {
        Esquimal.probReproduccion=prob;
    }

    /*
    * Setter de prob de muerte
    */
    @Override
    public void setMuerte(int prob)
    {
        Esquimal.probMuerte=prob;
    }

    /*
    *   Setter de prob de dieta para la raza con cierto ID
    */
    @Override
    public void setDieta(int id, int min, int max)
    {
        Esquimal.dieta.get(id).set(0, min);
        Esquimal.dieta.get(id).set(1, max);
    }

    
    /*
    *   Setter de probs de dieta para una raza con valor ID 
    */
    @Override
    public void modDieta(int id, int min, int max)
    {
        Esquimal.dieta.get(id).set(0, min+dieta.get(id).set(0, min));
        Esquimal.dieta.get(id).set(1, max+dieta.get(id).set(1, max));
    }

    /*
    *   Modificador de prob reproduccion, para añadir un valor constante
    */
    @Override
    public void modReproduccion(int prob)
    {
        Esquimal.probReproduccion=probReproduccion+prob;
    }

    /*
    *   Modificador de prob muerte, para añadir un valor constante
    */
    @Override
    public void modMuerte(int prob)
    {
        Esquimal.probMuerte=probMuerte+prob;
    }

    /*
    *   Devuelve la cantidad de elementos de esta clase
    */
    @Override
    public String cantidad() 
    {
        return (String.valueOf(cantidad)+" esquimales");
    }
    
    /*
    *   Permite ajustar el rango de IMCs
    */
    @Override
        public void setIMC(int min,int max)
    {
        Esquimal.MinIMC=min;
        Esquimal.MaxIMC=max;
    }
        
    /*
    *   Asigna la cantidad inicial    
    */
    @Override
    public void IniciaCantidad()
    {
        Esquimal.cantidad=0;
    }    
    
    /*
    * Funcion para modificar la cantidad de elementos de esta clase
    */
    @Override
    public void modCantidad(int i)
    {
        Esquimal.cantidad=cantidad+i;
    }

}
