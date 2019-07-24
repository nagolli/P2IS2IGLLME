/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJuego;

import Codex.Codex;
import Perfiles.*;
import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class Miniatura
{

    private Codex codex;
    private int id;
    private int numescuadra;
    private int numescuadraTemporal;
    private Perfil perfil;
    private int heridas;
    private final ArrayList<Integer> estados;
    private int Xcentro;
    private int Ycentro;
    private int Orientacion;

    public Miniatura(int id, int numescuadra, Perfil perfil, Codex codex)
    {
        this.codex = codex;
        this.id = id;
        this.numescuadra = numescuadra;
        numescuadraTemporal = numescuadra;
        this.perfil = perfil;
        heridas = perfil.getH();
        estados = new ArrayList();
        Xcentro = -1;
        Ycentro = -1;
        Orientacion = 0; // Entre 0 y 360
    }

    public Miniatura(String cadena)
    {
        estados = new ArrayList();
        String buffer = "";
        int cont = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != '-' && cadena.charAt(i) != '_') {
                buffer += cadena.charAt(i);
            } else if (cadena.charAt(i) == '_') {
                estados.add(Integer.valueOf(buffer));
            } else {
                switch (cont) {
                    case 0: {
                        id = Integer.valueOf(buffer);
                        break;
                    }
                    case 1: {
                        numescuadra = Integer.valueOf(buffer);
                        break;
                    }
                    case 2: {
                        int NumCodex = Integer.valueOf(buffer);
                        codex = Codex.getCodexByID(NumCodex);
                        break;
                    }
                    case 3: {
                        heridas = Integer.valueOf(buffer);
                        break;
                    }
                    case 4: {
                        Xcentro = Integer.valueOf(buffer);
                        break;
                    }
                    case 5: {
                        Ycentro = Integer.valueOf(buffer);
                        break;
                    }
                    case 6: {
                        Orientacion = Integer.valueOf(buffer);
                        break;
                    }
                    case 7: {
                        int NumPerfil = Integer.valueOf(buffer);
                        perfil = codex.getPerfilByID(NumPerfil);
                        break;
                    }

                }
                buffer = "";
                cont++;
            }
        }
    }

    public void setPosicion(int X, int Y, int Orient)
    {
        Xcentro = X;
        Ycentro = Y;
        Orientacion = Orient;
    }

    public void addEstado(int num)
    {
        estados.add(num);
    }

    public void RemoveEstado(int num)
    {
        for (int i = 0; i < estados.size(); i++) {
            if (estados.get(i) == num) {
                estados.remove(i);
            }
        }
    }

    public void setNumescuadraTemporal(int numescuadraTemporal)
    {
        this.numescuadraTemporal = numescuadraTemporal;
    }

    public boolean addHerida()
    {
        if (heridas > 0) {
            heridas = heridas - 1;
        }
        return (heridas == 0);
    }

    public Perfil getPerfil()
    {
        return perfil;
    }

    public int getId()
    {
        return id;
    }

    public int getNumescuadra()
    {
        return numescuadra;
    }

    public int getHeridas()
    {
        return heridas;
    }

    public ArrayList<Integer> getEstados()
    {
        return estados;
    }

    public int getNumescuadraTemporal()
    {
        return numescuadraTemporal;
    }

    public int getXcentro()
    {
        return Xcentro;
    }

    public int getYcentro()
    {
        return Ycentro;
    }

    public int getOrientacion()
    {
        return Orientacion;
    }

    @Override
    public String toString()
    {
        String res = String.valueOf(id) + "-" + String.valueOf(numescuadra) + "-" + String.valueOf(codex.getID()) + "-" + String.valueOf(heridas) + "-" + String.valueOf(Xcentro) + "-" + String.valueOf(Ycentro) + "-" + String.valueOf(Orientacion) + "-" + String.valueOf(perfil.getID());
        for (int i = 0; i < estados.size(); i++) {
            res = res + String.valueOf(estados.get(i)) + "_";
        }
        return res;
    }

}
