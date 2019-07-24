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
public class Perfil_Infanteria extends Perfil
{
    
    private final int HA;
    private final int F;
    private final int R;
    private final int H;
    private final int I;
    private final int A;
    private final int L;
    private final int Sn;
    private final int Se;
    private final int tipoUnidad;
    private final int radio;
    private final int tamanoTransporte;

    public Perfil_Infanteria(int ID, String nombre, int HA, int HP, int F, int R, int H, int I, int A, int L, int Sn, int Se, int tipoUnidad, int radio, int tamanoTransporte, int puntos)
    {
        this.ID=ID;
        this.nombre=nombre;
        this.HA = HA;
        this.F = F;
        this.R = R;
        this.H = H;
        this.I = I;
        this.A = A;
        this.L = L;
        this.Sn = Sn;
        this.Se = Se;
        this.tipoUnidad = tipoUnidad;
        this.radio = radio;
        this.tamanoTransporte = tamanoTransporte;
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

    public int getR()
    {
        return R;
    }

    public int getH()
    {
        return H;
    }

    public int getI()
    {
        return I;
    }

    public int getA()
    {
        return A;
    }

    public int getL()
    {
        return L;
    }

    public int getSn()
    {
        return Sn;
    }

    public int getSe()
    {
        return Se;
    }

    public int getTipoUnidad()
    {
        return tipoUnidad;
    }

    public int getRadio()
    {
        return radio;
    }

    public int getTamanoTransporte()
    {
        return tamanoTransporte;
    }

    
    
}
