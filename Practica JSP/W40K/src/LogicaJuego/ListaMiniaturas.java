/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJuego;

import Codex.Codex;
import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class ListaMiniaturas
{

    ArrayList<Miniatura> lista;
    ArrayList<Boolean> propMinis;
    Codex Host;
    Codex Client;

    public ListaMiniaturas(Codex Host, Codex Client)
    {
        this.Host = Host;
        this.Client = Client;
        propMinis = new ArrayList();
        lista = new ArrayList();
    }

    public void addMiniatura(Miniatura m, Boolean host)
    {
        propMinis.add(host);
        lista.add(m);
    }

    @Override
    public String toString()
    {
        String res = String.valueOf(Host.getID()) + "+" + String.valueOf(Client.getID()) + "+";
        for (int i = 0; i < propMinis.size(); i++) {
            if (propMinis.get(i)) {
                res = res + "?";
            } else {
                res = res + "¿";
            }
            res = res + lista.get(i).toString() + "*";
        }
        return res;
    }

    public ListaMiniaturas(String cadena)
    {
        propMinis = new ArrayList();
        lista = new ArrayList();
        String buffer = "";
        int cont = 0;
        Boolean host;
        int NumCodex;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != '*' && cadena.charAt(i) != '?' && cadena.charAt(i) != '¿' && cadena.charAt(i) != '+') {
                buffer += cadena.charAt(i);
            } else if (cadena.charAt(i) == '?') {
                propMinis.add(true);
            } else if (cadena.charAt(i) == '¿') {
                propMinis.add(false);
            } else if (cadena.charAt(i) == '*') {
                lista.add(new Miniatura(buffer));
                buffer = "";
            } else if (cadena.charAt(i) == '+') {
                if (cont == 0) {
                    NumCodex = Integer.valueOf(buffer);
                    Host = Codex.getCodexByID(NumCodex);
                    cont++;
                    buffer = "";
                } else {
                    NumCodex = Integer.valueOf(buffer);
                    Client = Codex.getCodexByID(NumCodex);
                    cont++;
                    buffer = "";
                }
            }
        }
    }

}
