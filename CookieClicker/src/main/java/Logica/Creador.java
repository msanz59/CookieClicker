package main.java.Logica;

public class Creador implements Runnable {
    private Sistema sistema;
    private Thread hilo;

    private int cookiesporSegundo;
    private int tiempo;

    public Creador(Sistema sistema, int cookiesporSegundo, int tiempo) {
        this.sistema = sistema;
        this.cookiesporSegundo = cookiesporSegundo;
        this.tiempo = tiempo;
    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(tiempo); // Espera 1 segundo
                sistema.AgregarGalletas(cookiesporSegundo);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
