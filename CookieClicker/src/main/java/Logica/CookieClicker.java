/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.java.Logica;


import GUI.Interfaz;

/**
 *
 * @author msanz
 */
public class CookieClicker {

    public static void main(String[] args)
    {
        Sistema sistema = Sistema.cargarEstado("datos.ser");
        Interfaz interfaz = new Interfaz(sistema);
        interfaz.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            sistema.guardarEstado("datos.ser");
            System.out.println("Estado guardado.");
        }));

    }

}
