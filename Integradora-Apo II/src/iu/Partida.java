package iu;

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
        this.tablero = new Tablero();
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
}

