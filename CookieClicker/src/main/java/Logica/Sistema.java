package main.java.Logica;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Sistema implements Serializable {
    private transient AtomicInteger numeroGalletas = new AtomicInteger(0);
    private transient ExecutorService executor = Executors.newCachedThreadPool();
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
    private int numeroGalletasValor;
    private boolean dobleClick = false;

    private void writeObject(ObjectOutputStream oos) throws IOException {
        numeroGalletasValor = numeroGalletas.get();
        oos.defaultWriteObject();
    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        numeroGalletas = new AtomicInteger(numeroGalletasValor);
        executor = Executors.newCachedThreadPool();
        recrearHilos();
    }

    public void guardarEstado(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Sistema cargarEstado(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Sistema sistema = (Sistema) ois.readObject();
            return sistema;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar el estado, iniciando nuevo juego.");
            return new Sistema();
        }
    }
    private void recrearHilos() {
        for (int i = 0; i < numCursors; i++) executor.execute(new Creador(this, 1, 10000));
        for (int i = 0; i < numAbuelas; i++) executor.execute(new Creador(this, 1, 1000));
        for (int i = 0; i < numGranjas; i++) executor.execute(new Creador(this, 8, 1000));
        for (int i = 0; i < numFabricas; i++) executor.execute(new Creador(this, 47, 1000));
        for (int i = 0; i < numBancos; i++) executor.execute(new Creador(this, 260, 1000));
    }

    public synchronized void Click() {
        if (dobleClick) {
            numeroGalletas.addAndGet(2);
        } else {
            numeroGalletas.incrementAndGet();
        }
    }
    public void setDobleClick(boolean dobleClick) {
        this.dobleClick = dobleClick;
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
