/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perfiles;

import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class Perfil_Vehiculo extends Perfil
{
    private final int BF;
    private final int BL;
    private final int BP;
    private final int tipoVehiculo;
    private final int ancho;
    private final int alto;
    private final int capacidad;
    private ArrayList<Integer> puntosAcceso; //Se miden por el perimetro desde el frente hacia la derecha

    public Perfil_Vehiculo(int ID, String nombre, int HP, int BF, int BL, int BP, int tipoVehiculo, int ancho, int alto, int capacidad, ArrayList<Integer> puntosAcceso, int puntos)
    {
        this.ID=ID;
        this.nombre=nombre;
        this.BF = BF;
        this.BL = BL;
        this.BP = BP;
        this.tipoVehiculo = tipoVehiculo;
        this.ancho = ancho;
        this.alto = alto;
        this.capacidad = capacidad;
        this.HP=HP;
        this.puntos=puntos;
        this.puntosAcceso=puntosAcceso;
    }
    
    public Perfil_Vehiculo(String nombre, int HP, int BF, int BL, int BP, int tipoVehiculo, int ancho, int alto, int puntos)
    {
        this.nombre=nombre;
        this.BF = BF;
        this.BL = BL;
        this.BP = BP;
        this.tipoVehiculo = tipoVehiculo;
        this.ancho = ancho;
        this.alto = alto;
        this.capacidad = 0;
        this.HP=HP;
        this.puntos=puntos;
        this.puntosAcceso = new ArrayList();
    }

    public int getBF()
    {
        return BF;
    }

    public int getBL()
    {
        return BL;
    }

    public int getBP()
    {
        return BP;
    }

    public int getTipoVehiculo()
    {
        return tipoVehiculo;
    }

    public int getAncho()
    {
        return ancho;
    }

    public int getAlto()
    {
        return alto;
    }

    public int getCapacidad()
    {
        return capacidad;
    }

    public ArrayList<Integer> getPuntosAcceso()
    {
        return puntosAcceso;
    }
    
    
    
}
