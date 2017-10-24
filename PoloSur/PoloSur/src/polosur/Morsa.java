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
public class Morsa extends SerVivo
{
    static int MinIMC; 	//constante de clase
    static int MaxIMC; 	//constante de clase
    static int probReproduccion; 		//valor de clase
    static int probMuerte;                      //valor de clase
    static ArrayList<ArrayList<Integer>> dieta; //valor de clase
    private static int cantidad;

    
    /*
    *   Constructor de la clase, hereda de SerVivo
    */
    public Morsa(int IMC, int diaNacimiento)
    {
        super(IMC, diaNacimiento);
        Morsa.cantidad=cantidad+1;
        ID=3;
    }
    
    /*
    * Setter de prob de reproduccion
    */
    @Override
    public void setReproduccion(int prob)
    {
        Morsa.probReproduccion=prob;
    }

    /*
    *   Setter de prob de muerte
    */
    @Override
    public void setMuerte(int prob)
    {
        Morsa.probMuerte=prob;
    }

    /*
    *   Setter de prob de dieta, para la raza de ID id
    */
    @Override
    public void setDieta(int id, int min, int max)
    {
        Morsa.dieta.get(id).set(0, min);
        Morsa.dieta.get(id).set(1, max);
    }

    /*
    *   Setter de probs de dieta para una raza con valor ID
    */
    @Override
    public void modDieta(int id, int min, int max)
    {
        Morsa.dieta.get(id).set(0, min+dieta.get(id).set(0, min));
        Morsa.dieta.get(id).set(1, max+dieta.get(id).set(1, max));
    }

    /*
    *   Modificador de prob reproduccion, para añadir un valor constante
    */
    @Override
    public void modReproduccion(int prob)
    {
        Morsa.probReproduccion=probReproduccion+prob;
    }

    /*
    *   Modificador de prob muerte, para añadir un valor constante
    */
    @Override
    public void modMuerte(int prob)
    {
        Morsa.probMuerte=probMuerte+prob;
    }

    /*
    *   Devuelve la cantidad de elementos de esta clase
    */
    @Override
    public String cantidad() //Devuelve "3 esquimales" ó "10 peces que son: 3 atunes, 2 merluzas y 5 rapes"
    {
        return (String.valueOf(cantidad)+" morsas");
    }
    
    /*
    *   Permite ajustar el rango de IMCs
    */
    @Override
        public void setIMC(int min,int max)
    {
        Morsa.MinIMC=min;
        Morsa.MaxIMC=max;
    }

    /*
    * Funcion para modificar la cantidad de elementos de esta clase
    */
    @Override
    public void modCantidad(int i)
    {
        Morsa.cantidad=cantidad+i;
    }
    
    /*
    * Funcion para inicializar la cantidad de elementos de esa clase
    */
    @Override
    public void IniciaCantidad()
    {
        Morsa.cantidad=0;
    }    
}