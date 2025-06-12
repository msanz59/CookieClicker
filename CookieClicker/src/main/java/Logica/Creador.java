package main.java.Logica;

public class Creador implements Runnable {
    private final Sistema sistema;
    private Thread hilo;

    private final int cookiesporSegundo;
    private final int tiempo;

    public Creador(Sistema sistema, int cookiesporSegundo, int tiempo) {
        this.sistema = sistema;
        this.cookiesporSegundo = cookiesporSegundo;
        this.tiempo = tiempo;
    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(tiempo);
                sistema.AgregarGalletas(cookiesporSegundo);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
