/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perfiles;

import Codex.*;
import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class Perfil
{

    protected int ID;
    protected String nombre;
    protected int HP;
    protected int puntos;
    protected ArrayList<Integer> reglasEspeciales;
    protected ArrayList<Equipo> equipoObligatorio;
    protected ArrayList<Equipo> ArmaDefecto;
    protected ArrayList<Equipo> ArmaOpcional;
    protected int numOpciones;
    protected ArrayList<Equipo> equipoOpcional;

    public String getNombre()
    {
        return nombre;
    }

    public int getHP()
    {
        return HP;
    }

    public int getPuntos()
    {
        return puntos;
    }

    public ArrayList<Integer> getReglasEspeciales()
    {
        return reglasEspeciales;
    }

    public ArrayList<Equipo> getEquipoObligatorio()
    {
        return equipoObligatorio;
    }

    public ArrayList<Equipo> getArmaDefecto()
    {
        return ArmaDefecto;
    }

    public ArrayList<Equipo> getArmaOpcional()
    {
        return ArmaOpcional;
    }

    public int getNumOpciones()
    {
        return numOpciones;
    }

    public ArrayList<Equipo> getEquipoOpcional()
    {
        return equipoOpcional;
    }

    public int getH()
    {
        return -1;
    }

    public int getID()
    {
        return ID;
    }
}
