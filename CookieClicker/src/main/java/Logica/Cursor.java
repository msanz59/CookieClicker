package main.java.Logica;

public class Cursor implements Runnable {
    private Sistema sistema;
    private Thread hilo;
    private int contadorClicks = 0;

    public Cursor(Sistema sistema) {
        this.sistema = sistema;
        this.hilo = new Thread(this);
        this.hilo.start();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10000); // Espera 10 segundos entre clicks
                sistema.Click();
                contadorClicks++;
                System.out.println("Cursor ha hecho click. Total clicks: " + contadorClicks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
