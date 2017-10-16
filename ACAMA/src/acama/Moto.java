/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acama;

import java.util.Scanner;

/**
 *
 * @author Ignacio
 */
public class Moto
{

    String nombre;
    int cc;
    int coste;
    int id;
    Miembro propietario;

    public Moto()
    {

    }

    /*
    Función NuevaMoto(int,Acama)
    Construye, con interaccion del usuario, el nuevo objeto cesion.
    Entradas:
        int: Máximo ID de motos hasta el momento.
        Acama: Objeto padre, para realizar comprobaciones.
    Devuelve:
        True si se ha creado sin problemas
        False si ha habido algun fallo en la creación.
     */
    public boolean NuevaMoto(int c, Acama org)
    {
        int input;
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        id = c + 1;
        System.out.println("Introduzca nombre de la moto: ");
        System.out.print(">> ");
        nombre = sc.next();

        System.out.println("Introduzca cilindrada: ");
        cc = GetNum();
        if (cc <= 0) {
            System.out.println("Error, cc debe ser mayor que 0");
            return false;
        }
        System.out.println("Introduzca coste (sin centimos): ");
        coste = GetNum();
        if (coste <= 0) {
            System.out.println("Error, coste debe ser mayor que 0");
            return false;
        }

        System.out.println("Introduzca numero de socio: ");
        input = GetNum();
        if (org.SocioExiste(input)) { //ERROR SI NO
            propietario = org.GetSocio(input);
        } else {
            System.out.println("Error, usuario no existente");
            return false;
        }
        if (propietario.CosteTotal(coste)) {
            propietario.AddMoto(this);
        } else {
            System.out.println("Error, usuario tiene demasiadas motos");
            return false;
        }
        return true;
    }

    /*
    Función GetNum
    Lee un numero por pantalla
        Devuelve un entero, en caso de error, devuelve un -1.
     */
    private int GetNum()
    {
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Por favor, solo valores numericos");
            num = -1; //IDs y carnets de socio nunca negativos, será error en siguiente operación
        }
        return num;
    }

    /*
    Función SetPropietario
        Establece el propietario de esta moto
     */
    public void SetPropietario(Miembro miembro)
    {
        this.propietario = miembro;
    }

    /*
    Función GetCoste
        Devuelve el coste de la moto, para comprobaciones de no exceder
        maximo de coste permitido
     */
    public int GetCoste()
    {
        return coste;
    }

    /*
    Función MostrarMoto(bool)
    Construye el string que representa este objeto
        Entrada: 
        bool Si es true, mostrará al propietario tambien.
     */
    public String MostrarMoto(boolean mostrarPropietario)
    {
        String texto = "";
        texto = texto + ("Motocicleta " + id + ":\n");
        texto = texto + ("  Modelo:\n");
        texto = texto + nombre;
        texto = texto + ("\n  Cilindrada:\n");
        texto = texto + cc + " CC\n";
        texto = texto + ("  Coste:\n");
        texto = texto + coste + "€\n";
        if (mostrarPropietario) {
            texto = texto + ("  Propietario:\n");
            texto = texto + propietario.MostrarMiembro(false);
        }
        return texto;
    }

    /*
    Función GetId
    Devuelve el ID de la moto, para realizar busquedas.
     */
    public int GetId()
    {
        return id;
    }

    /*
    Funcion toString
    Devuelve como string la moto para llamadas desde la interfaz.
     */
    @Override
    public String toString()
    {
        return MostrarMoto(true);
    }
}
