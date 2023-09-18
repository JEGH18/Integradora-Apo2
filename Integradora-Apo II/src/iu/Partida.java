package iu;

import java.util.Scanner;

public class Partida {
    private String nombreJugador;
    private Tablero tablero;
    private long tiempoInicio;
    private long tiempoFin;
    private int tuberiasUsadas;
    
    
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
        long tiempoEnSegundos = getTiempoEnSegundos();
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
        if (this.tiempoFin > 0) { // Asegurarse de que tiempoFin se ha establecido
            return (int) ((this.tiempoFin - this.tiempoInicio) / 1000);
        } else {
            return 0; // Devolver 0 si tiempoFin aún no se ha establecido
        }
        
    }

    public void setTuberiasUsadas(int tuberiasUsadas) {
        this.tuberiasUsadas = tuberiasUsadas;
    }
}
