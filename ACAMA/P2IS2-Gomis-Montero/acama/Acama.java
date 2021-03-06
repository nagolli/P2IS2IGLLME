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
                OrdenarInsercion(miembros,1);
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
                if(miembros.get(i)!=null){
                pw.println(miembros.get(i).toString());
                pw.println(" ");
                }
            }
            pw.println(" ");
            for (int i = 0; i < cesiones.size(); i++) {
                if(cesiones.get(i)!=null){
                pw.println(cesiones.get(i).toString());
                pw.println(" ");
                }
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
    Función OrdenarInsercion(ArrayList Miembro,int modo)
    Ordena de menor a mayor el array por numero de socio.
        Se ha escogido este metodo porque es el más eficiente para ordenar un 
    solo miembro
    
    Modo: 1 ordena por Nsocio
          2 ordena por Num cesiones
     */
    private ArrayList<Miembro> OrdenarInsercion(ArrayList<Miembro> v,int modo)
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
    /*
    Función EliminarMiembro
    Elimina un usuario del programa.
     */
     public void EliminarMiembro(){
         int i, nsocio, input;
         Miembro socio;
         ArrayList <Moto> motosmiembro = new ArrayList();
         Boolean seguir=false;
         Boolean cede=false;
         Cesion cesion = new Cesion();
         do{
            do{
               System.out.println("Introduzca número de socio: ");
               nsocio = GetNum();
            }while(!SocioExiste(nsocio));
            socio=GetSocio(nsocio);
            System.out.println("Desea eliminar este miembro?(1.Sí, 2.No, 3.Salir): ");
            System.out.println(socio.MostrarMiembro(false));
            input = GetNum();
            if(input==1)
                seguir=true;
            if(input==3)
                return;
         }while(!seguir);
         motosmiembro=socio.GetMotos();
         for(i=0;i<motosmiembro.size();i++){
             do{
             motosmiembro.get(i).MostrarMoto(false);

             cede=cesion.NuevaCesionSocio(cesiones.size(), this, nsocio, motosmiembro.get(i));
             if(cede)
                 cesiones.add(cesion);
             else{
                 System.out.println("Debe ceder la moto");
             }
                     }while(!cede);
         }
         for(i=0;i<miembros.size();i++){
             if(miembros.get(i).GetNSocio()==nsocio)
                 miembros.remove(i);
         }
     }
     
     /*
     Funcion MiembroMasCedido
     Muestra el miembro que mas cesiones ha recibido a lo largo del tiempo.
     En caso de empate muestra todos los empatados.
     Muestra primero las motos en posesion actualmente y posteriormente las 
     anteriormente poseidas
     */
    void MiembroMasCedido()
    {
        ArrayList<Miembro> aux=new ArrayList();
        int max=0;
        
        for(int i=0;i<miembros.size();i++)
        {
            //System.out.println("DEBUG: NUM CESIONES DE "+i+": "+miembros.get(i).getNumCesiones());
            if(miembros.get(i).getNumCesiones()>=max)
            {
                if(miembros.get(i).getNumCesiones()==max)
                {
                    //System.out.println("DEBUG: ADDED");
                    aux.add(miembros.get(i));
                }
                else if(miembros.get(i).getNumCesiones()>max)
                {
                    //System.out.println("DEBUG: INICIADO");
                    aux=new ArrayList();
                    aux.add(miembros.get(i));
                    max=miembros.get(i).getNumCesiones();
                }
            }
        }
        for(int i=0;i<aux.size();i++)
        {
            System.out.println(" ");
            System.out.println(aux.get(i));
            //System.out.println("DEBUG: USUARIO "+aux.get(i).GetNSocio());
            for(int j=0;j<cesiones.size();j++)
            {
                //System.out.println("DEBUG: CESOR"+cesiones.get(j).getCesor().GetNSocio());
                if(cesiones.get(j).getCesor()==aux.get(i))
                {
                    System.out.println(cesiones.get(j).getMoto().MostrarMoto(false));
                    //System.out.println("DEBUG: EXITO");
                }
            }
        }
    }
}
