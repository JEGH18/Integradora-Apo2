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

    public void colocarTuberia(int fila, int columna, char tipo) {
        this.tablero.colocarTuberia(fila, columna, tipo);
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

    public void setTuberiasUsadas(int tuberiasUsadas) {
        this.tuberiasUsadas = tuberiasUsadas;
    }
}

