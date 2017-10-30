/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polosur;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ignacio
 */
public class Utilidades
{

    final static Random aleatorio = new Random();

    /*
    *   Funcion RadixSortIMC para ordenar un array de SeresVivos segun su IMC
    *
    *   Usa Digito y Concatenar
    */
    static public ArrayList<SerVivo> RadixSortIMC(ArrayList<SerVivo> sort)
    {
        int n = sort.size();
        int d;
        ArrayList< ArrayList<SerVivo>> aux = new ArrayList();
        for (int i = 0; i < 10; i++) {
            aux.add(new ArrayList());
        }
        int iterations = 2;

        for (int i = 0; i <= iterations; ++i) {
            for (int j = 0; j < 10; ++j) {
                aux.set(j, new ArrayList());
            }

            for (int j = 0; j < n; ++j) {
                d = Digito(i, sort.get(i).getIMC());
                aux.get(d).add(sort.get(j));
            }
            sort = aux.get(0);
            for (int j = 1; j < 10; ++j) {
                ConcatenarVector(sort, aux.get(j));
            }
        }
        return sort;
    }
    
    static public ArrayList<SerVivo> RadixSortRaza(ArrayList<SerVivo> sort)
    {
        int n = sort.size();
        int d;
        ArrayList< ArrayList<SerVivo>> aux = new ArrayList();
        for (int i = 0; i < 10; i++) {
            aux.add(new ArrayList());
        }
        int iterations = 2;

        for (int i = 0; i <= iterations; ++i) {
            for (int j = 0; j < 10; ++j) {
                aux.set(j, new ArrayList());
            }

            for (int j = 0; j < n; ++j) {
                d = Digito(i, sort.get(i).getRaza());
                aux.get(d).add(sort.get(j));
            }
            sort = aux.get(0);
            for (int j = 1; j < 10; ++j) {
                ConcatenarVector(sort, aux.get(j));
            }
        }
        return sort;
    }

    /*
    * Funcion digito en base 10, para numeros entre 0 y 99
    */
    private static int Digito(int i, Integer num)
    {
        if(i==0)
        {
           return  num%10;
        }
        else
        {
            return num/10;
        }
    }

    /*
    * Funcion para concatenar Vectores
    */
    private static void ConcatenarVector(ArrayList<SerVivo> v1, ArrayList<SerVivo> v2)
    {
        v1.ensureCapacity(v1.size() + v2.size());
        for (int i = 0; i < v2.size(); i++) {
            v1.add(v2.get(i));
        }
    }
    
    /*
    *   Funcion para obtener Cierto o Falso con probabilidad dada sobre mil
    */
    static public boolean rand(int prob)
    {
        return (aleatorio.nextInt(999) < prob);
    }

    /*
    *   Funcion para obtener un numero entre x e y incluidos
    */
    static public int rand(int x, int y)
    {
        if(y>x)
            return aleatorio.nextInt(y - x) + x;
        if(x<y)
            return aleatorio.nextInt(x - y) + y;
        return x;
    }

}
