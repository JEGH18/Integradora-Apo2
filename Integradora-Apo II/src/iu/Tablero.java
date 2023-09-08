package iu;

public class Tablero {
    private char[][] tablero;

    public Tablero() {
        this.tablero = new char[8][8];
        // Inicializar el tablero con valores por defecto
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.tablero[i][j] = 'X';
            }
        }
        // Colocar la fuente (F) y el drenaje (D) en posiciones aleatorias
        int filaF = (int) (Math.random() * 8);
        int columnaF = (int) (Math.random() * 8);
        this.tablero[filaF][columnaF] = 'F';
        int filaD = (int) (Math.random() * 8);
        int columnaD = (int) (Math.random() * 8);
        while (filaD == filaF && columnaD == columnaF) {
            filaD = (int) (Math.random() * 8);
            columnaD = (int) (Math.random() * 8);
        }
        this.tablero[filaD][columnaD] = 'D';
    }

    public void modificar(int fila, int columna, char valor) {
        // Verificar que la posición sea válida y no sea la fuente o el drenaje
        if (fila >= 0 && fila < 8 && columna >= 0 && columna < 8 && this.tablero[fila][columna] != 'F' && this.tablero[fila][columna] != 'D') {
            this.tablero[fila][columna] = valor;
        }
    }

    public boolean esSolucionCorrecta() {
        // Implementar un algoritmo para verificar si la solución es correcta
        return false;
    }

    public void mostrar() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}

