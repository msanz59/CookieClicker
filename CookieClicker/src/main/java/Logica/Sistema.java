package main.java.Logica;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Sistema extends Thread {
    private AtomicInteger numeroGalletas = new AtomicInteger(0);
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private int numCursors = 0;
    private int precioCursors = 15;
    private int numAbuelas = 0;
    private int precioAbuelas = 100;
    private int numGranjas = 0;
    private int precioGranjas = 500;
    private int numFabricas = 0;
    private int precioFabricas = 3000;
    private int numBancos = 0;
    private int precioBancos = 20000;

    public synchronized void Click() {
        numeroGalletas.incrementAndGet();
        System.out.println("Galletas: " + numeroGalletas.get());
    }

    public int getNumeroGalletas() {
        return numeroGalletas.get();
    }
    public void AgregarGalletas(int cantidad) {
        numeroGalletas.addAndGet(cantidad);

    }
    public void CrearCursor(){
        int precioActual = (int) Math.ceil(precioCursors * Math.pow(1.15, numCursors));
        if (numeroGalletas.get() < precioActual) {
            System.out.println("No tienes suficientes galletas para comprar un cursor.");
            return;
        }

        Creador cursor = new Creador(this, 1, 10000);
        executor.execute(cursor);
        numCursors++;
        numeroGalletas.addAndGet(-precioActual);

    }
    public void CrearAbuela(){
        int precioActual = (int) Math.ceil(precioAbuelas * Math.pow(1.15, numAbuelas));
        if (numeroGalletas.get() < precioActual) {
            System.out.println("No tienes suficientes galletas para comprar una abuela.");
            return;
        }
        Creador abuela = new Creador(this, 1, 1000);
        executor.execute(abuela);
        numAbuelas++;
        numeroGalletas.addAndGet(-precioActual);
    }
    public int getNumCursors() {
        return numCursors;
    }
    public int getNumAbuelas() {
        return numAbuelas;
    }
    public void CrearGranja(){
        int precioActual = (int) Math.ceil(precioGranjas * Math.pow(1.15, numGranjas));
        if (numeroGalletas.get() < precioActual) {
            System.out.println("No tienes suficientes galletas para comprar una granja.");
            return;
        }
        Creador granja = new Creador(this, 8, 1000);
        executor.execute(granja);
        numGranjas++;
        numeroGalletas.addAndGet(-precioActual);
    }
    public void CrearFabrica(){
        int precioActual = (int) Math.ceil(precioFabricas * Math.pow(1.15, numFabricas));
        if (numeroGalletas.get() < precioActual) {
            System.out.println("No tienes suficientes galletas para comprar una fabrica.");
            return;
        }
        Creador fabrica = new Creador(this, 47, 1000);
        executor.execute(fabrica);
        numFabricas++;
        numeroGalletas.addAndGet(-precioActual);
    }
    public int getNumGranjas() {
        return numGranjas;
    }
    public int getNumFabricas() {
        return numFabricas;
    }
    public void CrearBanco(){
        int precioActual = (int) Math.ceil(precioBancos * Math.pow(1.15, numBancos));
        if (numeroGalletas.get() < precioActual) {
            System.out.println("No tienes suficientes galletas para comprar un banco.");
            return;
        }
        Creador banco = new Creador(this, 260, 1000);
        executor.execute(banco);
        numBancos++;
        numeroGalletas.addAndGet(-precioActual);
    }
    public int getNumBancos() {
        return numBancos;
    }





}
