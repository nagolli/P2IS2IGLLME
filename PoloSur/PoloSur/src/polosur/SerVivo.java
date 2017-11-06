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
public class SerVivo
{

    protected int ID;
    protected int IMC;
    protected int diaNacimiento;
    protected int MinIMC;                          //constante de clase
    protected int MaxIMC;                          //constante de clase


    /*
    *   Constructor por defecto
     */
    SerVivo(int IMC, int diaNacimiento) //IMC=0 generará aleatoriamente el IMC
    {
        if (IMC < 1 || IMC > 99) {
            this.IMC = IMC;
        } else {
            this.IMC = Utilidades.rand(MinIMC, MaxIMC);
        }
        this.diaNacimiento = diaNacimiento;
    }

    /*
    *   Funcion para recuperar el tipo de Ser Vivo que es, asignación: 1 Pez, 2 Foca, 3 Morsa, 4 Oso, 5 Esquimal
     */
    public int getTipo() //Devuelve el identificador de raza [0-x] que estará ordenado con el 0 aquello que este en la base de la cadena alimenticia
    {
        return ID;
    }

    /*
    *   Funcion para calcular cuantas presas de cada ID van a ser devorados
     */
    public ArrayList<Integer> come() //Devuelve cuantas presas ha comido de cada ID
    {
        return null;
    }

    /*
    *   Función que devuelve si el SerVivo se va a reproducir o no
     */
    public boolean reproducirse()
    {
        return false;
    }

    /*
    *   Función que devuelve si el SerVivo muere o no
     */
    public boolean morir()
    {
        return false;
    }

    /*
    *   Función que debe ser llamada al eliminar un SerVivo para modificar la cantidad
     */
    public void destruir()
    {
        modCantidad(-1);
    }

    /*
    *   Función que devuelve el IMC de el SerVivo
     */
    public int getIMC()
    {
        return IMC;
    }

    /*
    *   Funcion para recuperar el String del SerVivo
     */
    @Override
    public String toString()
    {
        String respuesta;
        switch (ID) {
            case 2:
                respuesta = "[Foca";
                break;
            case 3:
                respuesta = "[Morsa";
                break;
            case 4:
                respuesta = "[Oso Polar";
                break;
            case 5:
                respuesta = "[Esquimal";
                break;
            default:
                respuesta = "";
                break;
        }
        return (respuesta + " IMC: " + IMC + " nacido el dia: " + diaNacimiento + "]\n");
    }

    /*
    * Funcion para asignar la dieta de esta raza de seres vivos
    * ID indicaqué animal de la dieta se modifica
     */
    public void setDieta(int id, int min, int max)
    {
    }

    /*
    * Funcion para asignar la tasa de reproduccion de esta raza de seres vivos
     */
    public void setReproduccion(int prob)
    {
    }

    /*
    * Funcion para asignar la tasa de muerte de esta raza de seres vivos
     */
    public void setMuerte(int prob)
    {
    }

    /*
    * Funcion para asignar la tasa de IMC de esta raza de seres vivos
     */
    public void setIMC(int min, int max)
    {
    }

    /*
    * Funcion para modificar la dieta de esta raza de seres vivos en X unidades
    * ID indicaqué animal de la dieta se modifica
     */
    public void modDieta(int id, int min, int max)
    {
    }

    /*
    * Funcion para modificar la tasa de reproduccion de esta raza de seres vivos en X unidades
     */
    public void modReproduccion(int prob)
    {
    }

    /*
    * Funcion para modificar la tasa de muerte de esta raza de seres vivos en X unidades
     */
    public void modMuerte(int prob)
    {
    }

    /*
    * Funcion para obtener la cantidad de seres vivos de la raza de la especie de este SerVivo
    * Ejemplo: Devuelve "3 esquimales" ó "10 peces que son: 3 atunes, 2 merluzas y 5 rapes"
     */
    public String cantidad(int raza)
    {
        return "";
    }

    /*
    * Funcion para configurar esta especie
     */
    public void Configurar(int minIMC, int maxIMC, int probReproduccion, int probMuerte, ArrayList<ArrayList<Integer>> dieta)
    {
        setIMC(minIMC, maxIMC);
        setMuerte(probMuerte);
        setReproduccion(probReproduccion);
        iniDieta(dieta);
        IniciaCantidad();
    }

    /*
    * Funcion para asignar la cantidad de esta raza a 0
     */
    static public void IniciaCantidad()
    {
        Esquimal.IniciaCantidad();
        Foca.IniciaCantidad();
        Morsa.IniciaCantidad();
        Oso.IniciaCantidad();
        Pez.IniciaCantidad();
    }

    /*
    * Funcion para modificar la cantidad de esta raza en 1
     */
    public void modCantidad(int i)
    {
    }

    /*
    * Funcion para asignar la cantidad de la raza pez en 1 de la raza C
     */
    public void modCantidad(int i, int c)
    {
    }

    /*
    *   Funcion para asignar la dieta desde el inicializado
     */
    public void iniDieta(ArrayList<ArrayList<Integer>> dieta)
    {

    }

    /*
    *   Funcion para recuperar la raza de la especie, si hubiera
     */
    public int getRaza()
    {
        return 0;
    }

}
