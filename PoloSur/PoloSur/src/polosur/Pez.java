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
public class Pez extends SerVivo
{

    static int MinIMC; 	//constante de clase
    static int MaxIMC; 	//constante de clase
    static int probReproduccion; 		//valor de clase
    static int probMuerte;                      //valor de clase
    static ArrayList<ArrayList<Integer>> dieta; //valor de clase

    /*
    Nota: Dados los requisitos, no merece la pena heredar las distintas razas de pescados
    ya que la unica diferencia entre ellos es la raza, sin embargo la
     */
    private static int cantidad; //Bacalaos
    private static int cantidad2;//Rayas
    private static int cantidad3;//Merluzas negras
    int raza;

    /*
    *   Constructor de la clase, hereda de SerVivo
     */
    public Pez(int IMC, int diaNacimiento, int raza)
    {
        super(IMC, diaNacimiento);
        ID = 1;
        if (raza < 1 || raza > 3) {
            this.raza = Utilidades.rand(1, 3);
        } else {
            this.raza = raza;
        }
        switch (raza) {
            case 1:
                Pez.cantidad = cantidad + 1;
                break;
            case 2:
                Pez.cantidad2 = cantidad2 + 1;
                break;
            case 3:
                Pez.cantidad3 = cantidad3 + 1;
                break;
        }

    }

    /*
    * Setter de prob de reproduccion
     */
    @Override
    public void setReproduccion(int prob)
    {
        Pez.probReproduccion = prob;
    }

    /*
    *   Setter de prob de muerte
     */
    @Override
    public void setMuerte(int prob)
    {
        Pez.probMuerte = prob;
    }

    /*
    *   Setter de prob de dieta, para la raza de ID id
     */
    @Override
    public void setDieta(int id, int min, int max)
    {
        Pez.dieta.get(id).set(0, min);
        Pez.dieta.get(id).set(1, max);
    }

    /*
    *   Setter de probs de dieta para una raza con valor ID
     */
    @Override
    public void modDieta(int id, int min, int max)
    {
        Pez.dieta.get(id).set(0, min + dieta.get(id).set(0, min));
        Pez.dieta.get(id).set(1, max + dieta.get(id).set(1, max));
    }

    /*
    *   Modificador de prob reproduccion, para añadir un valor constante
     */
    @Override
    public void modReproduccion(int prob)
    {
        Pez.probReproduccion = probReproduccion + prob;
    }

    /*
    *   Modificador de prob muerte, para añadir un valor constante
     */
    @Override
    public void modMuerte(int prob)
    {
        Pez.probMuerte = probMuerte + prob;
    }

    /*
    *   Devuelve la cantidad de elementos de esta clase
     */
    @Override
    public String cantidad() //Devuelve "3 esquimales" ó "10 peces que son: 3 atunes, 2 merluzas y 5 rapes"
    {
        return (String.valueOf(cantidad + cantidad2 + cantidad3) + " esquimales que son: " + cantidad + " bacalaos, " + cantidad2 + " rayas y " + cantidad3 + " merluzas negras");
    }

    /*
    *   Permite ajustar el rango de IMCs
     */
    @Override
    public void setIMC(int min, int max)
    {
        Pez.MinIMC = min;
        Pez.MaxIMC = max;
    }

    /*
    * Funcion para inicializar la cantidad de elementos de esta clase
     */
    @Override
    public void IniciaCantidad()
    {
        Pez.cantidad = 0;
        Pez.cantidad2 = 0;
        Pez.cantidad3 = 0;
    }

    /*
    * Funcion para modificar la cantidad de elementos de esta clase
     */
    @Override
    public void modCantidad(int i, int raza)
    {
        switch (raza) {
            case 1:
                Pez.cantidad = cantidad + i;
                break;
            case 2:
                Pez.cantidad2 = cantidad2 + i;
                break;
            case 3:
                Pez.cantidad3 = cantidad3 + i;
                break;
        }
    }

    /*
    * Funcion para destruir el objeto
    */
    @Override
    public void destruir()
    {
        switch (raza) {
            case 1:
                Pez.cantidad = cantidad - 1;
                break;
            case 2:
                Pez.cantidad2 = cantidad2 -1;
                break;
            case 3:
                Pez.cantidad3 = cantidad3 - 1;
                break;
        }
    }
    
    /*
    *   Funcion para recuperar el String del Pez
    */
    @Override
    public String toString()
    {
        String respuesta="";
        switch(raza)
        {
            case 1:
                respuesta="[Bacalao";
                break;
            case 2:
                respuesta="[Raya";
                break;
            case 3:
                respuesta="[Merluza Negra";
            break;
        }
        return (respuesta+" IMC: "+IMC+" nacido el dia: "+diaNacimiento+"]\n");
    }
}
