/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w40k;

import Vistas.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ignacio
 */
public class HiloReceptor extends Thread
{

    private Socket TCP;
    PantallaJuego tablero;
    SeleccionListaHost seleccionHost;
    SeleccionListaClient seleccionCliente;
    ServerSocket server;

    public void SetTablero(PantallaJuego tablero)
    {
        this.tablero=tablero;
    }
    
    public HiloReceptor(SeleccionListaHost seleccionHost)
    {
        TCP = null;
        this.seleccionHost = seleccionHost;
    }

    public void killServer()
    {
        try {
            Socket FakeTCP = new Socket("localhost", 1993);
            Thread.sleep(5);
        } catch (Exception e) {

        }
    }

    public Socket Conectar()
    {
        boolean conected = false;
        while (!conected) {
            try {
                server = new ServerSocket(1993);
                TCP = server.accept();
                conected = true;
                server.close();
            } catch (IOException e) {
                System.out.println("Error HiloReceptor.Conectar: " + e);
            }
        }
        return TCP;
    }

    public Socket getTCP()
    {
        return TCP;
    }

    public HiloReceptor(Socket TCP, SeleccionListaClient seleccionCliente)
    {
        this.TCP = TCP;
        this.seleccionCliente = seleccionCliente;
    }

    @Override
    public void run()
    {
        if (TCP == null) {
            TCP = Conectar();
            seleccionHost.conexion(TCP);
            System.out.println(TCP.getInetAddress() + "/" + TCP.getLocalAddress());
        }

        while (true) {
            procesar(Utilidades.receiveTCP(TCP));
        }
    }

    private void procesar(String cadena)
    {
        System.out.println("Mensaje recibido: " + cadena);
        if(cadena!=null)
        if (cadena.length() > 0) {
            switch (cadena.charAt(0)) {
                case '0': //Mensaje de chat
                {
                    tablero.RecibirMensaje(cadena.substring(2,cadena.length()));
                    break;
                }
                case '1': //Protocolos de conexion
                {
                    switch (cadena.charAt(2)) {
                        case '1': //Enviado de puntos
                        {
                            seleccionCliente.setPuntos(Integer.valueOf(cadena.substring(4)));
                            break;
                        }
                        case '2': //Notificar cliente preparado
                        {
                            seleccionHost.setClientePreparado(true);
                            break;
                        }
                        case '3': //Notificar cliente no preparado
                        {
                            seleccionHost.setClientePreparado(false);
                            break;
                        }
                        case '4': //AbrirPantallaJuego
                        {
                            seleccionCliente.abrirPantallaJuego();
                            break;
                        }
                    }
                }
                case '2': //Listas
                {
                    break;
                }
                case '3': //Ubicacion y estado Miniaturas
                {
                    break;
                }
                case '4': //Tiradas
                {
                    tablero.RecibirTiradas(cadena.substring(2,cadena.length()));
                    break;
                }    
            }
        }

    }
}
