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
public class Foca extends SerVivo
{
    private static int MinIMC; 	//constante de clase
    private static int MaxIMC; 	//constante de clase
    private static int probReproduccion; 		//valor de clase
    private static int probMuerte;                      //valor de clase
    private static ArrayList<ArrayList<Integer>> dieta; //valor de clase
    private static int cantidad;

    
    /*
    *   Constructor de la clase, hereda de SerVivo
    */
    public Foca(int IMC, int diaNacimiento)
    {
        super(IMC, diaNacimiento);
        Foca.cantidad=cantidad+1;
        ID=2;
    }
    
    /*
    * Setter de prob de reproduccion
    */
    @Override
    public void setReproduccion(int prob)
    {
        Foca.probReproduccion=prob;
    }

    /*
    *   Setter de prob de muerte
    */
    @Override
    public void setMuerte(int prob)
    {
        Foca.probMuerte=prob;
    }

    /*
    *   Inicia la dieta con los valores por defecto
     */
    @Override
    public void iniDieta(ArrayList<ArrayList<Integer>> dieta)
    {
        Foca.dieta=dieta;
    }
    
    /*
    *   Setter de prob de dieta, para la raza de ID id
    */
    @Override
    public void setDieta(int id, int min, int max)
    {
        Foca.dieta.get(id).set(0, min);
        Foca.dieta.get(id).set(1, max);
    }

    /*
    *   Setter de probs de dieta para una raza con valor ID
    */
    @Override
    public void modDieta(int id, int min, int max)
    {
        Foca.dieta.get(id).set(0, min+dieta.get(id).set(0, min));
        Foca.dieta.get(id).set(1, max+dieta.get(id).set(1, max));
    }

    /*
    *   Modificador de prob reproduccion, para añadir un valor constante
    */
    @Override
    public void modReproduccion(int prob)
    {
        Foca.probReproduccion=probReproduccion+prob;
    }

    /*
    *   Modificador de prob muerte, para añadir un valor constante
    */
    @Override
    public void modMuerte(int prob)
    {
        Foca.probMuerte=probMuerte+prob;
    }

    /*
    *   Devuelve la cantidad de elementos de esta clase
    */
    @Override
    public String cantidad() //Devuelve "3 esquimales" ó "10 peces que son: 3 atunes, 2 merluzas y 5 rapes"
    {
        return (String.valueOf(cantidad)+" focas");
    }
    
    /*
    *   Permite ajustar el rango de IMCs
    */
    @Override
        public void setIMC(int min,int max)
    {
        Foca.MinIMC=min;
        Foca.MaxIMC=max;
    }

    /*
    * Funcion para inicializar la cantidad
    */
    static public void IniciaCantidad()
    {
        Foca.cantidad=0;
    }    
    
    /*
    * Funcion para modificar la cantidad de elementos de esta clase
    */
    @Override
    public void modCantidad(int i)
    {
        Foca.cantidad=cantidad+i;
    }
    
    /*
    *   Funcion para calcular cuantas presas de cada ID van a ser devorados
     */
    @Override
    public ArrayList<Integer> come() //Devuelve cuantas presas ha comido de cada ID
    {
        ArrayList<Integer> ret = new ArrayList();
        for (int i = 0; i < 6; i++) {
                    ret.add(Utilidades.rand(Foca.dieta.get(i).get(0), Foca.dieta.get(i).get(1)));
        }
        return ret;
    }

    /*
    *   Función que devuelve si se va a reproducir o no
     */
    @Override
    public boolean reproducirse()
    {
        return (Utilidades.rand(Foca.probReproduccion));
    }

    /*
    *   Función que devuelve si muere o no
     */
    @Override
    public boolean morir()
    {
        return (Utilidades.rand(Foca.probMuerte));
    }
}