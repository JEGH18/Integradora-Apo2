package iu;

import java.util.Scanner;

public class Partida {
    private String nombreJugador;
    private Tablero tablero;
    private long tiempoInicio;
    private long tiempoFin;
    private int tuberiasUsadas;

    public void ponerTuberia() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escriba la posición, primero la fila y luego la columna");
        int fila = scanner.nextInt();

        int columna = scanner.nextInt();
        System.out.println("Escriba el tipo de tubería =, ||, o.");

        char tipoTuberia = scanner.next().charAt(0);

        this.tablero.modificar(fila, columna, tipoTuberia);
        this.tablero.mostrar();
    }

    public Partida(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.tablero = new Tablero();
        this.tiempoInicio = System.currentTimeMillis();
        this.tiempoFin = 0;
        this.tuberiasUsadas = 0;
    }

    public void iniciarNuevaPartida() {
        this.tablero.mostrar();
        this.tiempoInicio = System.currentTimeMillis();
        this.tiempoFin = 0;
        this.tuberiasUsadas = 0;
    }

    public void mostrarTablero() {
        this.tablero.mostrar();
    }

    public void actualizarEstado(int tuberiasUsadas) {
        this.tuberiasUsadas = tuberiasUsadas;
        if (this.tablero.esSolucionCorrecta()) {
            this.tiempoFin = System.currentTimeMillis();
        }
    }

    public int getPuntos() {
        long tiempoEnSegundos = (tiempoFin - tiempoInicio) / 1000;
        return (100 - tuberiasUsadas) * 10 - (int)tiempoEnSegundos;
    }

    public void colocarTuberia(int fila, int columna, char tipo) {
        this.tablero.colocarTuberiaEnTablero(fila, columna, tipo, this);
    }

    public void simular() {
        this.tablero.simular();
    }

    public boolean esSolucionCorrecta() {
        return this.tablero.esSolucionCorrecta();
    }

    public void mostrarResultados() {
        System.out.println("Resultados de la partida:");
        System.out.println("Nombre del jugador: " + this.nombreJugador);
        System.out.println("Tiempo de la partida: " + (this.tiempoFin - this.tiempoInicio) / 1000 + " segundos");
        System.out.println("Tuberías usadas: " + this.tuberiasUsadas);
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public long getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(long tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public long getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(long tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public int getTuberiasUsadas() {
        return tuberiasUsadas;
    }

    public int getTiempoEnSegundos() {
        return (int) ((this.tiempoFin - this.tiempoInicio) / 1000);
    }

    public void setTuberiasUsadas(int tuberiasUsadas) {
        this.tuberiasUsadas = tuberiasUsadas;
    }
}