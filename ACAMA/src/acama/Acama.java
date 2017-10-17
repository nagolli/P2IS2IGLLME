/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acama;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ignacio y Lidia
 */
class Acama
{

    private ArrayList<Cesion> cesiones;
    private ArrayList<Miembro> miembros;
    private ArrayList<Moto> motos;

    public Acama()
    {
        cesiones = new ArrayList();
        miembros = new ArrayList();
        motos = new ArrayList();
    }

    /*
    Función NuevoMiembro
    Realiza el procedimiento para crear un miembro. Si hay un error no lo añade al sistema.
     */
    public boolean NuevoMiembro(int costemaximo)
    {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int input;
        String nombre, apellidos;
        boolean error = false;

        System.out.println("Introduzca Nº Socio: ");
        input = GetNum();
        if (input > 0) {
            if (!SocioExiste(input)) {    //Comprobamos que el socio no exista antes de crearlo
                System.out.println("Introduzca nombre: ");
                System.out.print(">> ");
                nombre = sc.next();
                System.out.println("Introduzca apellidos: ");
                System.out.print(">> ");
                apellidos = sc.next();

                Miembro miembro = new Miembro(nombre, apellidos, input, costemaximo);
                miembros.add(miembro);
                OrdenarInsercion(miembros);
            } else {
                System.out.println("Socio ya existente");
                error = true;
            }
        } else {
            System.out.println("Por favor, carnets con valores positivos");
            error = true;
        }
        return error;
    }

    /*
    Función NuevaMoto
    Inicia el procedimiento para crear una moto. Si hay un error no la añade al sistema.
     */
    public void NuevaMoto()
    {
        Moto moto = new Moto();
        if (moto.NuevaMoto(motos.size(), this)) {
            motos.add(moto);
        }
    }

    /*
    Función NuevaCesion
    Inicia el procedimiento para crear una cesión. Si hay un error no la añade al sistema.
     */
    public void NuevaCesion()
    {
        Cesion cesion = new Cesion();
        if (cesion.NuevaCesion(cesiones.size(), this)) {
            cesiones.add(cesion);
        }
    }

    /*
    Función MiembrosMotos
    Muestra por pantalla todos los miembros
     */
    public void MiembrosMotos()
    {
        for (int i = 0; i < miembros.size(); i++) {
            System.out.println(miembros.get(i).toString());

        }
    }

    /*
    Función ListaMotos
    Muestra por pantalla todas las motos
     */
    public void ListaMotos()
    {
        for (int i = 0; i < motos.size(); i++) {
            System.out.println(motos.get(i).toString());
        }
    }

    /*
    Función MostrarCesiones
    Muestra por pantalla las cesiones
     */
    public void MostrarCesiones()
    {
        for (int i = 0; i < cesiones.size(); i++) {
            System.out.println(cesiones.get(i).toString());
        }
    }

    /*
    Función Salir
    Guarda los datos en un fichero
     */
    public boolean Salir()
    {
        Scanner sc = new Scanner(System.in);
        FileWriter fichero = null;
        PrintWriter pw = null;
        String input;
        try {
            System.out.println("Escriba nombre del fichero sin extesion: ");
            System.out.print(">> ");
            input = sc.next();

            fichero = new FileWriter(input + ".txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < miembros.size(); i++) {
                pw.println(miembros.get(i).toString());
                pw.println(" ");
            }
            pw.println(" ");
            for (int i = 0; i < cesiones.size(); i++) {
                pw.println(cesiones.get(i).toString());
                pw.println(" ");
            }

            if (null != fichero) {
                fichero.close();
            }
        } catch (Exception e) {
            System.out.println("Error al guardar, revise la ruta");
            return false;
        }
        return true;
    }

    /*
    Función SocioExiste(int)
    Comprueba si un socio con ID=int existe
    
     */
    public boolean SocioExiste(int input)
    {
        for (int i = 0; i < miembros.size(); i++) {
            if (miembros.get(i).GetNSocio() == input) {
                return true;
            }
        }
        return false;
    }

    /*
    Función GetSocio(int)
    Devuelve un socio con id igual al int
    No dará error si primero se comprueba con SocioExiste(int)
     */
    public Miembro GetSocio(int input)
    {
        for (int i = 0; i < miembros.size(); i++) {
            if (miembros.get(i).GetNSocio() == input) {
                return miembros.get(i);
            }
        }
        return null;
    }

    /*
    Función OrdenarInsercion(ArrayList Miembro)
    Ordena de menor a mayor el array por numero de socio.
        Se ha escogido este metodo porque es el más eficiente para ordenar un 
    solo miembro
     */
    private ArrayList<Miembro> OrdenarInsercion(ArrayList<Miembro> v)
    {
        int i, j;
        int n = v.size();
        v.add(null);
        for (i = n - 2; i >= 0; i--) {
            v.set(n, v.get(i));
            j = i + 1;
            while (v.get(j).GetNSocio() < v.get(n).GetNSocio()) {
                v.set(j - 1, v.get(j));
                j++;
            }
            v.set(j - 1, v.get(n));
        }
        v.remove(n);

        return v;
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
            num = -1; //Ningun caso
        }
        return num;
    }

    /*
    Funcion AumentarGastosMotos
    Aumenta el coste adicional asociado a una moto.
    */
    void AumentarGastosMotos()
    {
        int input, i;
        //Seleccionar ID moto
        System.out.println("Introduzca ID de moto: ");
        i = GetNum();
        if (!BuscarMoto(i)) {
            System.out.println("ID de moto no existente.");
            return;
        }
        //Introducir numero
        System.out.println("Escriba el importe a aumentar:");
        input = GetNum();
        if (input < 0) {
            System.out.println("Los costes añadidos deben ser positivos.");
            return;
        }
        motos.get(i-1).AddOtrosGastos(input);
    }
    /*
    Funcion BuscarMoto
    Funcion que busca si existe el ID de una moto en el vector de motos
    */
     public Boolean BuscarMoto(int id){
        for(int i=0;i<motos.size();i++)
        {
            if(motos.get(i).GetId()==id){
                return true;
            }
        }
        return false;
    }
     
}
