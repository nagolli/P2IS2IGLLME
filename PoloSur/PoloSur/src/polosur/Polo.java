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

    Polo(ArrayList<Integer> valoresConfig)
    {
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
            animales.set(i, Utilidades.RadixSort(animales.get(i)));
        }
        System.out.println(krill + "," + animales.get(1).size() + "," + animales.get(2).size() + "," + animales.get(3).size() + "," + animales.get(4).size() + "," + animales.get(5).size());
    }

    public void UnDia()
    {
        int i=0;
        for (i = 0; i < 6; i++) {
            for (int j = 0; j < animales.get(i).size(); j++) {

                if (!procesoComer(i, j)) {
                    animales.get(i).get(j).destruir();
                    animales.get(i).remove(j);
                    j--;
                } else {
                    if (animales.get(i).size() > 0 && j < animales.get(i).size()) {

                        if (animales.get(i).get(j).reproducirse()) {
                            ProcesoReproducirse(i, j);
                            j++;
                        }
                        if(j < animales.get(i).size())
                        if (animales.get(i).get(j).morir()) {
                            animales.get(i).get(j).destruir();
                            animales.get(i).remove(j);
                            j--;
                            
                        }
                    }
                }

            }
        }
        modificarKrill();
        modificarTemperatura();
        dia++;
        System.out.println(dia + ":" + krill + "," + animales.get(1).size() + "," + animales.get(2).size() + "," + animales.get(3).size() + "," + animales.get(4).size() + "," + animales.get(5).size());
    }

    public void DiezDias()
    {
        for (int i = 0; i < 10; i++) {
            UnDia();
        }
    }

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

    private void ProcesoReproducirse(int i, int j)
    {
        switch (i) {
            case 1:
                animales.get(1).add(j, new Pez(animales.get(1).get(j).getIMC(), dia, animales.get(1).get(j).getRaza()));
                break;
            case 2:
                animales.get(2).add(j, new Foca(animales.get(2).get(j).getIMC(), dia));
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

}
