/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polosur;

import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ignacio
 */
public class Utilidades
{

    final static Random aleatorio = new Random();

    /*
    *   Funcion RadixSortIMC para ordenar un array de SeresVivos segun su IMC
    *   No desordena la ordenación anterior
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

        for (int i = 0; i < iterations; ++i) {
            for (int j = 0; j < 10; ++j) {
                aux.set(j, new ArrayList());
            }

            for (int j = 0; j < n; ++j) {
                d = Digito(i, sort.get(j).getIMC());
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
    *   Funcion RadixSortRaza para ordenar un array de SeresVivos segun su raza
    *   No desordena la ordenación anterior
    *
    *   Usa Digito y Concatenar
     */
    static public ArrayList<SerVivo> RadixSortRaza(ArrayList<SerVivo> sort)
    {
        int n = sort.size();
        int d;
        ArrayList< ArrayList<SerVivo>> aux = new ArrayList();
        for (int i = 0; i < 10; i++) {
            aux.add(new ArrayList());
        }
        int iterations = 1;

        for (int i = 0; i <= iterations; ++i) {
            for (int j = 0; j < 10; ++j) {
                aux.set(j, new ArrayList());
            }

            for (int j = 0; j < n; ++j) {
                d = Digito(i, sort.get(j).getRaza());
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
        if (i == 0) {
            return num % 10;
        } else {
            return num / 10;
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
        if (y > x) {
            return (aleatorio.nextInt(y + 1 - x) + x);
        }
        if (x < y) {
            return (aleatorio.nextInt(x + 1 - y) + y);
        }
        return x;
    }

    /*
    Funcion para mostrar un Dialog Pane indicando la extinción de una especie    
     */
    static void MostrarExtincion(int i, int d)
    {
        String mensaje = "";
        switch (i) {
            case 0:
                //mensaje = "El krill ha llegado al limite el dia " + d + ".";
                return;
            case 1:
                mensaje = "Los peces se han extinguido el dia " + d + ", es el fin del polo.";
                break;
            case 2:
                mensaje = "Las focas se han extinguido el dia " + d + ".";
                break;
            case 3:
                mensaje = "Los osos polares se han extinguido el dia " + d + ".";
                break;
            case 4:
                mensaje = "Las morsas se han extinguido el dia " + d + ".";
                break;
            case 5:
                mensaje = "Los esquimales han muerto el dia " + d + ".";
                break;
        }
        //default title and icon
        JOptionPane.showMessageDialog(new JFrame(), mensaje);
    }

    static void Serializar(Object serializado)
    {
        try {
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bs);
            os.writeObject(serializado);  // this es de tipo DatoUdp
            os.close();
            byte[] bytes = bs.toByteArray(); // devuelve byte[]
            FileOutputStream fos = new FileOutputStream("UltimaSesion.bin");
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            System.out.println("Error al serializar: " + e);
        }
    }

    static Polo getSerializado()
    {

        int reply = JOptionPane.showConfirmDialog(null, "Desea cargar el estado de la última sesión?", "Cargar datos", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.NO_OPTION) {
            return null;
        } else {
            try {
                FileInputStream fis = new FileInputStream("UltimaSesion.bin");
                byte[] bytes = new byte[12000];
                fis.read(bytes);
                ByteArrayInputStream bs = new ByteArrayInputStream(bytes); // bytes es el byte[]
                ObjectInputStream is = new ObjectInputStream(bs);
                Polo objeto = (Polo) is.readObject();
                is.close();
                return objeto;
            } catch (Exception e) {
                System.out.println("Error leer serializacion: " + e);
                return null;
            }

        }
    }

}
