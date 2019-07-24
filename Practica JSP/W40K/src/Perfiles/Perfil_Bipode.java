/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perfiles;

/**
 *
 * @author Ignacio
 */
public class Perfil_Bipode extends Perfil
{
    private final int HA;
    private final int F;
    private final int I;
    private final int A;
    private final int BF;
    private final int BL;
    private final int BP;
    private final int radio;
    private final int tamanoTransporte;
    private final int tipoVehiculo;

    public Perfil_Bipode(int ID, String nombre, int HA, int HP, int F, int I, int A, int BF, int BL, int BP, int radio, int tamanoTransporte, int tipoVehiculo, int puntos)
    {
        this.ID=ID;
        this.nombre=nombre;
        this.HA = HA;
        this.F = F;
        this.I = I;
        this.A = A;
        this.BF = BF;
        this.BL = BL;
        this.BP = BP;
        this.radio = radio;
        this.tamanoTransporte = tamanoTransporte;
        this.tipoVehiculo = tipoVehiculo;
        this.HP=HP;
        this.puntos=puntos;
    }

    public int getHA()
    {
        return HA;
    }

    public int getF()
    {
        return F;
    }

    public int getI()
    {
        return I;
    }

    public int getA()
    {
        return A;
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

    public int getRadio()
    {
        return radio;
    }

    public int getTamanoTransporte()
    {
        return tamanoTransporte;
    }

    public int getTipoVehiculo()
    {
        return tipoVehiculo;
    }
    
    
    
}
