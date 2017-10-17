/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acama;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Ignacio
 */
public class Cesion
{

    private int id;
    private Date fecha;
    private Miembro cesor;
    private Miembro adquisidor;
    private Moto moto;
    private static final DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public Cesion()
    {

    }

    /*
    Función NuevaCesion(int,Acama)
    Construye, con interaccion del usuario, el nuevo objeto cesion.
    Entradas:
        int: Máximo ID de cesiones hasta el momento.
        Acama: Objeto padre, para realizar comprobaciones.
    Devuelve:
        True si se ha creado sin problemas
        False si ha habido algun fallo en la creación.
    */
    public boolean NuevaCesion(int c, Acama org)
    {
        int input;
        id = c + 1;
        fecha = new Date();
        System.out.println("Introduzca Nº Socio cesor de la moto: ");
        input = GetNum();
        if (org.SocioExiste(input)) { //ERROR SI NO
            cesor = org.GetSocio(input);
        } else {
            System.out.println("Error, socio no existente");
            return false;
        }
        System.out.println("Introduzca Nº Socio que recibirá la moto: ");
        input = GetNum();
        if (org.SocioExiste(input)) { //ERROR SI NO
            adquisidor = org.GetSocio(input);
        } else {
            System.out.println("Error, socio no existente");
            return false;
        }
        if (adquisidor == cesor) //ERROR SI SÍ
        {
            System.out.println("Error, adquisidor mismo que cesor");
            return false;
        }
        System.out.println("Introduzca ID de usuario que recibirá la moto: ");
        input = GetNum();
        if (cesor.BuscarMoto(input)) {
            moto = cesor.GetMoto(input);
        } else {
            System.out.println("Error, id de moto no existente");
            return false;
        }
        if (adquisidor.CosteTotal(moto.GetCoste())) { //ERROR SI NO
            cesor.DeleteMoto(moto);
            adquisidor.AddMoto(moto);
            moto.SetPropietario(adquisidor);
        } else {
            System.out.println("Error, usuario tiene demasiadas motos");
            return false;
        }
        return true;
    }

    /*
    Función MostrarCesion
    Construye el string que representa este objeto
    */
    public String MostrarCesion()
    {
        String texto = "";
        texto = texto + ("Cesion " + id + ":\n");
        texto = texto + ("  Cesor:\n");
        texto = texto + cesor.MostrarMiembro(false);
        texto = texto + ("\n  Adquisidor:\n");
        texto = texto + adquisidor.MostrarMiembro(false);
        texto = texto + ("\n  Moto:\n");
        texto = texto + moto.MostrarMoto(false);
        texto = texto + ("\nA fecha de: " + formatoFecha.format(fecha) + "\n");
        return texto;
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
            num = -1; //Solo indices positivos, devolverá error justo después
        }
        return num;
    }

    /*
    Funcion toString
    Devuelve como string la cesion para llamadas desde la interfaz.
    */
    
    @Override
    public String toString()
    {
        return MostrarCesion();
    }
    
}
