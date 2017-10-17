/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acama;

import java.util.Scanner;

/**
 *
 * @author Lidia
 */
public class Main
{

    /*
    Función Main
    Pone en bucle el programa para asignar instrucciones. Finaliza con la opción 7.
    */
    public static void main(String[] args)
    {
        Boolean isnotend = true;
        int input, costemaximo;
        Acama org = new Acama();
        do{
            System.out.println("Introduzca el límite de compra de las motos:");
            costemaximo=GetNum();
            if(costemaximo<0){
                System.out.println("El límite ha de ser mayor a 0");
            }
        }while(costemaximo<0);
        while (isnotend) {
            ImprimeOpciones();
            input = GetNum();
            if (input > 0 && input < 10) {
                switch (input) {
                    case 1:
                        org.NuevoMiembro(costemaximo);
                        break;
                    case 2:
                        org.NuevaMoto();
                        break;
                    case 3:
                        org.NuevaCesion();
                        break;
                    case 4:
                        org.MiembrosMotos();
                        break;
                    case 5:
                        org.ListaMotos();
                        break;
                    case 6:
                        org.MostrarCesiones();
                        break;
                    case 7:
                        org.AumentarGastosMotos();
                        break;
                    case 8:
                        org.EliminarMiembro();
                        break;
                    default:
                        isnotend=!org.Salir();
                        break;
                }
            } else {
                System.out.println("Error, introduzca numeros del 1 al 9");
            }
        }
    }

    /*
    Función GetNum
    Lee un numero por pantalla
        Devuelve un entero, en caso de error, devuelve un -1.
    */
    static private int GetNum()
    {
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Por favor, solo valores numericos");
            num = -1; //Ningun caso
        }
        return num;
    }

    /*
    Función ImprimeOpciones
    Imprime el menu indicado en los requisitos
    */
    static private void ImprimeOpciones()
    {
        System.out.println("");
        System.out.println("Escriba el numero de la opción deseada:");
        System.out.println("1. Registrar un nuevo miembro");
        System.out.println("2. Registrar una nueva motocicleta");
        System.out.println("3. Registrar una cesión");
        System.out.println("4. Listar en pantalla los miembros y motos en posesión");
        System.out.println("5. Listar todas las motos");
        System.out.println("6. Mostrar las cesiones realizadas");
        System.out.println("7. Añadir gastos adicionales moto");
        System.out.println("8. Eliminar miembro");
        System.out.println("9. Salir");

    }

}
