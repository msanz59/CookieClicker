package main.java.Logica;

import java.util.concurrent.atomic.AtomicInteger;

public class Sistema extends Thread {
    private AtomicInteger numeroGalletas = new AtomicInteger(0);

    public synchronized void Click() {
        numeroGalletas.incrementAndGet();
        System.out.println("Galletas: " + numeroGalletas.get());
    }




}
