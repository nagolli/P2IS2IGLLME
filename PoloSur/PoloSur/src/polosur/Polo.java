/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polosur;

import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class Polo
{

    private ArrayList<ArrayList<SerVivo>> animales;
    private int krill; //Se mide en millones
    private float temperatura;
    private int dia;
    private ArrayList<Boolean> flagsDesastres;
    private VentanaPrincipal vista;

    /*
    * Constructor de Polo
    */
    Polo(ArrayList<Integer> valoresConfig, VentanaPrincipal vista)
    {
        this.vista=vista;
        flagsDesastres=new ArrayList(); 
        for(int d=0;d<2;d++)    //< Modificar al añadir desastres
                flagsDesastres.add(false);
        dia = 1;
        animales = new ArrayList();
        for (int i = 0; i < 6; i++) //ID 0 reservado para el krill, no son objetos, pero si objetivos de comida
        {
            animales.add(new ArrayList());
        }
        SerVivo.IniciaCantidad();
        int randNum = Utilidades.rand(valoresConfig.get(0), valoresConfig.get(1));
        krill = randNum;
        randNum = Utilidades.rand(valoresConfig.get(2), valoresConfig.get(3));
        for (int i = 0; i < randNum; i++) {
            animales.get(1).add(new Pez(0, dia, 0));
        }
        randNum = Utilidades.rand(valoresConfig.get(4), valoresConfig.get(5));
        for (int i = 0; i < randNum; i++) {
            animales.get(2).add(new Foca(0, dia));
        }
        randNum = Utilidades.rand(valoresConfig.get(8), valoresConfig.get(9));
        for (int i = 0; i < randNum; i++) {
            animales.get(3).add(new Oso(0, dia));
        }
        randNum = Utilidades.rand(valoresConfig.get(6), valoresConfig.get(7));
        for (int i = 0; i < randNum; i++) {
            animales.get(4).add(new Morsa(0, dia));
        }

        randNum = Utilidades.rand(valoresConfig.get(10), valoresConfig.get(11));
        for (int i = 0; i < randNum; i++) {
            animales.get(5).add(new Esquimal(0, dia));
        }
        temperatura = valoresConfig.get(12);

        for (int i = 1; i < 6; i++) {
            animales.set(i, Utilidades.RadixSortIMC(animales.get(i)));
        }
        System.out.println(krill + "," + animales.get(1).size() + "," + animales.get(2).size() + "," + animales.get(3).size() + "," + animales.get(4).size() + "," + animales.get(5).size());
    }

    /*
    * Funcion para pasar un dia
    */
    public void UnDia()
    {
        int i=0;
        for (i = 0; i < 6; i++) {
            for (int j = animales.get(i).size()-1; j >= 0 ; j--) {

                if (!procesoComer(i, j)) {
                    animales.get(i).get(j).destruir();
                    animales.get(i).remove(j);
                } else {
                    if (animales.get(i).size() > 0 && j < animales.get(i).size()) {

                        if (animales.get(i).get(j).reproducirse()) {
                            ProcesoReproducirse(i, j);
                        }
                        if(j < animales.get(i).size())
                        if (animales.get(i).get(j).morir()) {
                            animales.get(i).get(j).destruir();
                            animales.get(i).remove(j);
                        }
                    }
                }

            }
        }
        modificarKrill();
        modificarTemperatura();
        ejecutarDesastres();
        for(i=0;i<animales.size();i++)
        {
            if(animales.get(i).size()==0)
                Utilidades.MostrarExtincion(i,vista,dia);
        }
        dia++;
        System.out.println(dia + ":" + krill + "," + animales.get(1).size() + "," + animales.get(2).size() + "," + animales.get(3).size() + "," + animales.get(4).size() + "," + animales.get(5).size());
    }

    /*
    * Funcion para pasar diez dias
    */
    public void DiezDias()
    {
        for (int i = 0; i < 10; i++) {
            UnDia();
        }
    }

    /*
    * Funcion para obtener cuanto va a comer un ser vivo y eliminarlo del array
    * Devuelve si el animal ha conseguido alimentarse o no
    */
    private boolean procesoComer(int a, int b)
    {
        ArrayList<Integer> muertes;
        muertes = animales.get(a).get(b).come();
        if (muertes.get(0) > krill) {
            krill = 0;
            return false;
        } else {
            krill -= muertes.get(0);
        }
        for (int i = 1; i < muertes.size(); i++) {
            for (int j = 0; j < muertes.get(i); j++) {
                if (animales.get(i).size() > 0) {
                    animales.get(i).get(0).destruir(); //Reduce en 1 la cantidad
                    animales.get(i).remove(0);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    * Funcion para que en caso de que un ser vivo se reproduzca, se añadan sus crias al array de seres vivos
    */
    private void ProcesoReproducirse(int i, int j)
    {
        switch (i) {
            case 1:
                animales.get(1).add(j, new Pez(animales.get(1).get(j).getIMC(), dia, animales.get(1).get(j).getRaza()));
                //Descomentar para que cada pez ponga 5 crias, mejora muchisimo la supervivencia de los mismos
                animales.get(1).add(j, new Pez(animales.get(1).get(j).getIMC(), dia, animales.get(1).get(j).getRaza()));
                animales.get(1).add(j, new Pez(animales.get(1).get(j).getIMC(), dia, animales.get(1).get(j).getRaza()));
                animales.get(1).add(j, new Pez(animales.get(1).get(j).getIMC(), dia, animales.get(1).get(j).getRaza()));
                animales.get(1).add(j, new Pez(animales.get(1).get(j).getIMC(), dia, animales.get(1).get(j).getRaza()));
                //
                break;
            case 2:
                animales.get(2).add(j, new Foca(animales.get(2).get(j).getIMC(), dia));
                //Descomentar para que cada foca ponga 2 crias, mejora la supervivencia de las mismas
                animales.get(2).add(j, new Foca(animales.get(2).get(j).getIMC(), dia));
                //
                break;
            case 3:
                animales.get(3).add(j, new Oso(animales.get(3).get(j).getIMC(), dia));
                break;
            case 4:
                animales.get(4).add(j, new Morsa(animales.get(4).get(j).getIMC(), dia));
                break;
            case 5:
                animales.get(5).add(j, new Esquimal(animales.get(5).get(j).getIMC(), dia));
                break;
        }

    }

    /*
    * Funcion para aplicar la variación de temperatura, no depende de nada
    */
    private void modificarTemperatura()
    {
        if (temperatura <= 3) {
            if (Utilidades.rand(550)) {
                temperatura += 0.2f;
            } else {
                temperatura -= 0.2f;
            }
        } else if (temperatura >= 5) {
            if (Utilidades.rand(450)) {
                temperatura += 0.2f;
            } else {
                temperatura -= 0.2f;
            }
        } else {
            int aux = Utilidades.rand(0, 99);
            if (aux < 30) {
                temperatura -= 0.2f;
            } else if (aux < 95) {
                temperatura += 0.2f;
            }

        }
    }

    /*
    * Funcion para aplicar la variación de krill segun la temperatura
    */
    private void modificarKrill()
    {
        if (temperatura < 5.5f && temperatura >= 3f) {
            if (temperatura < 5f) {
                if (temperatura < 4f) {
                    krill += 18000;
                } else {
                    krill += 22000;
                }
            } else {
                krill += 12000;
            }
        }
    }
    
    /*
    * Funcion para obtener toda la información del polo
    */
    public String Info()
    {
        String mensaje="";
        mensaje+= "Fecha: Dia "+dia;
        Utilidades.RadixSortRaza(animales.get(1));
        for(int i=1;i<animales.size();i++)
            for(int j=0;j<animales.get(i).size();i++)
            {
                
                mensaje += animales.get(i).get(j).toString();
                
            }
        Utilidades.RadixSortIMC(animales.get(1));
        for(int i=1;i<animales.size();i++)
        {
                try{
                mensaje += animales.get(i).get(0).toString();
                }catch(Exception e){}
        }
        mensaje+=krill+".000000 unidades de Krill\n";
        mensaje+="Temperatura del agua: "+temperatura+ "ºC\n";
        for(int i=1;i<flagsDesastres.size();i++)
        {
            if(flagsDesastres.get(i))
                mensaje+=EscribirDesastre(i);
        }
        return mensaje;
    }
    
    /******************    DESASTRES   ******************/
    
    public void ActivarDesastre(int i)
    {
        flagsDesastres.set(i-1, true);
    }
    
    private String EscribirDesastre(int i)
    {
        switch(i)
        {
            case 1: return "Desastre: Calentamiento global";
            case 2: return "Desastre: Buques de pesca mayor";
            default: return "Desastre no identificado: "+i;
        }
    }
    
    private void ejecutarDesastres()
    {
        if(flagsDesastres.get(0))
            calentamientoGlobal();
        if(flagsDesastres.get(1))
            buquesDePescaMayor();
    }
    
    private void calentamientoGlobal()   //FLAG 1
    {
        temperatura+=2;
        flagsDesastres.set(0, false);
    }
    
    private void buquesDePescaMayor()    //FLAG 2
    {
        flagsDesastres.set(1, false);
        for(int i=0;i<animales.get(3).size();i++)
        {
            if (Utilidades.rand(150)) {
                            animales.get(3).get(i).destruir();
                            animales.get(3).remove(i);
                            i--;
                        }
        }
        for(int i=0;i<animales.get(4).size();i++)
        {
            if (Utilidades.rand(200)) {
                            animales.get(4).get(i).destruir();
                            animales.get(4).remove(4);
                            i--;
                        }
        }
    }
    
}


