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
public class Oso extends SerVivo
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
    public Oso(int IMC, int diaNacimiento)
    {
        super(diaNacimiento);
        if (IMC > 0 && IMC < 100) {
            this.IMC = IMC;
        } else {
            this.IMC = Utilidades.rand(MinIMC, MaxIMC);
        }
        Oso.cantidad=cantidad+1;
        ID=3;
    }
    
    /*
    * Setter de prob de reproduccion
    */
    @Override
    public void setReproduccion(int prob)
    {
        Oso.probReproduccion=prob;
    }

    /*
    *   Setter de prob de muerte
    */
    @Override
    public void setMuerte(int prob)
    {
        Oso.probMuerte=prob;
    }

    /*
    *   Inicia la dieta con los valores por defecto
     */
    @Override
    public void iniDieta(ArrayList<ArrayList<Integer>> dieta)
    {
        Oso.dieta=dieta;
    }
    
    /*
    *   Setter de prob de dieta, para la raza de ID id
    */
    @Override
    public void setDieta(int id, int min, int max)
    {
        Oso.dieta.get(id).set(0, min);
        Oso.dieta.get(id).set(1, max);
    }

    /*
    *   Setter de probs de dieta para una raza con valor ID
    */
    @Override
    public void modDieta(int id, int min, int max)
    {
        Oso.dieta.get(id).set(0, min+dieta.get(id).set(0, min));
        Oso.dieta.get(id).set(1, max+dieta.get(id).set(1, max));
    }

    /*
    *   Modificador de prob reproduccion, para añadir un valor constante
    */
    @Override
    public void modReproduccion(int prob)
    {
        Oso.probReproduccion=probReproduccion+prob;
    }

    /*
    *   Modificador de prob muerte, para añadir un valor constante
    */
    @Override
    public void modMuerte(int prob)
    {
        Oso.probMuerte=probMuerte+prob;
    }

    /*
    *   Devuelve la cantidad de elementos de esta clase
    */
    @Override
    public String cantidad(int raza) 
    {
        return (String.valueOf(cantidad));
    }
    
    /*
    *   Permite ajustar el rango de IMCs
    */
    @Override
        public void setIMC(int min,int max)
    {
        Oso.MinIMC=min;
        Oso.MaxIMC=max;
    }

    /*
    * Funcion para inicializar la cantidad de elementos de esa clase
    */
    static public void IniciaCantidad()
    {
        Oso.cantidad=0;
    }    
    
    /*
    * Funcion para modificar la cantidad de elementos de esta clase
    */
    @Override
    public void modCantidad(int i)
    {
        Oso.cantidad=cantidad+i;
    }
    
    /*
    *   Funcion para calcular cuantas presas de cada ID van a ser devorados
     */
    @Override
    public ArrayList<Integer> come() //Devuelve cuantas presas ha comido de cada ID
    {
        ArrayList<Integer> ret = new ArrayList();
        for (int i = 0; i < 6; i++) {
                    ret.add(Utilidades.rand(Oso.dieta.get(i).get(0), Oso.dieta.get(i).get(1)));
        }
        return ret;
    }

    /*
    *   Función que devuelve si se va a reproducir o no
     */
    @Override
    public boolean reproducirse()
    {
        return (Utilidades.rand(Oso.probReproduccion));
    }

    /*
    *   Función que devuelve si muere o no
     */
    @Override
    public boolean morir()
    {
        return (Utilidades.rand(Oso.probMuerte));
    }
}
