package P6;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ignacio
 */
public class Utilidades
{
    public static ArrayList<Integer> MejorCamino(ArrayList<ArrayList<Integer>> datos)
    {
        ArrayList<Integer> sol = new ArrayList();
        ArrayList<ArrayList<Integer>> Combinaciones=perm(4);
        float mejor=999999999;
        float actual;
        
        for(int i=0;i<Combinaciones.size();i++)
        {
            actual=esfuerzo(Combinaciones.get(i),datos);
            if(actual<mejor)
            {
                mejor=actual;
                sol=Combinaciones.get(i);
            }
        }
        //Para que los datos se correspondan con 1 a N, en vez de 0 a N-1;
        for(int i=0;i<sol.size();i++)
        {
            sol.set(i, sol.get(i)+1);
        }
        return sol;
    }
    
    
    private static ArrayList<ArrayList<Integer>> perm (int n)
    {
        ArrayList<ArrayList<Integer>> solucion = new ArrayList();
        ArrayList<Integer> camino = new ArrayList();
        ArrayList<Integer> restantes = new ArrayList();
        for(int i=0;i<n;i++)
        {
            restantes.add(i);
        }
        Utilidades.perm(camino,restantes,solucion);
        return solucion;
    }

    static private void perm(ArrayList<Integer> camino, ArrayList<Integer> restantes, ArrayList<ArrayList<Integer>> solucion)
    {
        if(restantes.isEmpty())
        {
            solucion.add(camino);
        }
        else
        {
            ArrayList<Integer> tRest;
            ArrayList<Integer> tCam;
            for(int i=0;i<restantes.size();i++)
            {
                tRest = copyArray(restantes);
                tCam = copyArray(camino);
                tCam.add(restantes.get(i));
                tRest.remove(i);
                Utilidades.perm(tCam,tRest,solucion);
            }
        }
    }
    
    static private ArrayList<Integer> copyArray(ArrayList<Integer> orig)
    {
        ArrayList<Integer> sol = new ArrayList();
        for(int i=0;i<orig.size();i++)
        {
            sol.add(orig.get(i));
        }
        return sol;
    }
    
    private static float esfuerzo( ArrayList<Integer> camino , ArrayList<ArrayList<Integer>> datos ) //1er indice numero, //2º X Y Peso
    {
        float esfuerzo=0;
        int peso=2;
        for(int i=0;i<camino.size();i++)
        {
            peso+=datos.get(i).get(2);
        }
        System.out.println(calculoDistancia(0,0,datos.get(camino.get(0)).get(0),datos.get(camino.get(0)).get(1))+","+peso);
        esfuerzo = calculoDistancia(0,0,datos.get(camino.get(0)).get(0),datos.get(camino.get(0)).get(1))*(peso);
        peso-=datos.get(camino.get(0)).get(2);
        for(int i=0;i<3;i++)
        {
        System.out.println(calculoDistancia(datos.get(camino.get(i)).get(0),datos.get(camino.get(i)).get(1),datos.get(camino.get(i+1)).get(0),datos.get(camino.get(i+1)).get(1))+","+peso); 
        esfuerzo+=calculoDistancia(datos.get(camino.get(i)).get(0),datos.get(camino.get(i)).get(1),datos.get(camino.get(i+1)).get(0),datos.get(camino.get(i+1)).get(1))*(peso);
        peso-=datos.get(camino.get(i+1)).get(2);
        }
        System.out.println(calculoDistancia(datos.get(camino.get(3)).get(0),datos.get(camino.get(3)).get(1),0,0)+","+peso); 
        esfuerzo+=calculoDistancia(datos.get(camino.get(3)).get(0),datos.get(camino.get(3)).get(1),0,0)*(peso);
        return esfuerzo;
    }
    
    private static float calculoDistancia(int x1,int y1,int x2, int y2)
    {
        double x = x1-x2;
        double y = y1-y2;
        double z = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        return (float)z;
    }
    
    public static ArrayList<ArrayList<Integer>> montarDatos(int x1,int y1,int p1,int x2,int y2,int p2,int x3,int y3,int p3,int x4,int y4,int p4)
    {
        ArrayList<ArrayList<Integer>> datos= new ArrayList();
        ArrayList<Integer> temporal = new ArrayList();
            temporal.add(x1);
            temporal.add(y1);
            temporal.add(p1);
        datos.add(temporal);
        temporal = new ArrayList();
            temporal.add(x2);
            temporal.add(y2);
            temporal.add(p2);
        datos.add(temporal);
        temporal = new ArrayList();
            temporal.add(x3);
            temporal.add(y3);
            temporal.add(p3);
        datos.add(temporal);
        temporal = new ArrayList();
            temporal.add(x4);
            temporal.add(y4);
            temporal.add(p4);
        datos.add(temporal);
        return datos;
    }
}
