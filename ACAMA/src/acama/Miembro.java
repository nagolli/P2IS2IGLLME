/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acama;

import java.util.ArrayList;

/**
 *
 * @author Lidia
 */
public class Miembro {
    private String nombre;      //Normalmente se usa como identificador el dni,
    private String apellidos;   //pero dado que estamos trabajando con un club
    private int nsocio;      //privado con carnets, usaremos el número de socio
    private ArrayList <Moto> motosposesion;
    private static int costemaximo;
    
    Miembro(){
        //Constructor vacio por si se crea sin argumentos
    }
    
    /*
    Constructor estandar   
    */
    Miembro(String nombre, String apellidos, int nsocio, int costemaximo){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.nsocio=nsocio;
        motosposesion = new ArrayList();
        Miembro.costemaximo=costemaximo;
        //Se puede crear miembro sin introducir las motos en la construcción
    }
    Miembro(String nombre, String apellidos, int nsocio, ArrayList <Moto> motosposesion, int costemaximo){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.nsocio=nsocio;
        this.motosposesion=motosposesion;
        Miembro.costemaximo=costemaximo;
    }
    public String GetNombre(){
        return nombre;
    }
    public String GetApellidos(){
        return apellidos;
    }
    public int GetNSocio(){
        return nsocio;
    }
    public ArrayList <Moto> GetMotos(){
        return motosposesion;
    }

    public static int getCostemaximo() {
        return costemaximo;
    }
    
    /*
    Función GetMoto(int)
    Devuelve una moto con la id Int proporcionado.
    No da error si previamente se llama BuscarMoto(int)
    */
    public Moto GetMoto(int id){
        for(int i=0;i<motosposesion.size();i++)
        {
            if(motosposesion.get(i).GetId()==id){
                return motosposesion.get(i);
            }
        }
        return null;
    }
    
    /*
    Función BuscarMoto(int)
    Busca si una moto con cierto ID pertenece a ese miembro.
    */
    public Boolean BuscarMoto(int id){
        for(int i=0;i<motosposesion.size();i++)
        {
            if(motosposesion.get(i).GetId()==id){
                return true;
            }
        }
        return false;
    }
    public void SetNombre(String nombre){
        this.nombre=nombre;
    }
    public void SetApellidos(String apellidos){
        this.apellidos=apellidos;
    }
    
    /*
    Función AddMoto(moto)
    Añade una moto al vector de motos en propiedad.
    */
    public void AddMoto(Moto moto){
        motosposesion.add(moto);
    }
    
    /*
    Función DeleteMoto(moto)
    Busca la moto entre las motos en posesión del miembro para borrarla,
    si no la encuentra devuelve false
     */
    public boolean DeleteMoto(Moto moto){
        for(int i=0;i<motosposesion.size();i++)
        {
            if(motosposesion.get(i)==moto){
                motosposesion.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /*
    Función MostrarMiembro(bool)
    Construye el string que representa este objeto
        Entrada: 
        bool Si es true, mostrará las motos tambien.
     */
    public String MostrarMiembro(boolean mostrarMotos){
        String texto="";
        
        texto=texto+("Miembro " + nsocio + ": \n");
        texto=texto+("  Apellidos, nombre: \n");
        texto=texto+apellidos;
        texto=texto+(", ");
        texto=texto+nombre;
        if(mostrarMotos==true){
            if(motosposesion.size()>0)
                texto=texto+("\n  Motos: \n");
            for(int i=0;i<motosposesion.size();i++)
            {
                texto=texto+motosposesion.get(i).MostrarMoto(false);
                texto=texto+"\n";
            }
        }
        return texto;
    }
    
    /*
    Funcion CosteTotal(int)
    Comprueba si la suma de costes de las motos más la que se va a añadir
    excede el maximo establecido por la asociación.
    Devuelve True si no se excede
             False si lo excede
    */
    public Boolean CosteTotal(int num){
        int sumatotal=num;
        
        for(int i=0;i<motosposesion.size();i++)
        {
            sumatotal=sumatotal+motosposesion.get(i).GetCoste();
        }
        if(sumatotal>costemaximo)
            return false;
        return true;
    }
    
    /*
    Funcion toString
    Devuelve como string el miembro para llamadas desde la interfaz.
    */
    
    @Override
    public String toString()
    {
        return MostrarMiembro(true);
    }
}
