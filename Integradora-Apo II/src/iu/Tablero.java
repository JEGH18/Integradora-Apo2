package iu;

import java.util.LinkedList;

public class Tablero {
    private LinkedList<LinkedList<Character>> tablero;

    public Tablero() {
        this.tablero = new LinkedList<>();
        // Inicializar el tablero con valores por defecto
        for (int i = 0; i < 8; i++) {
            LinkedList<Character> fila = new LinkedList<>();
            for (int j = 0; j < 8; j++) {
                fila.add('X');
            }
            this.tablero.add(fila);
        }
        // Colocar la fuente (F) y el drenaje (D) en posiciones aleatorias
        int filaF = (int) (Math.random() * 8);
        int columnaF = (int) (Math.random() * 8);
        this.tablero.get(filaF).set(columnaF, 'F');
        int filaD, columnaD;
        do {
            filaD = (int) (Math.random() * 8);
            columnaD = (int) (Math.random() * 8);
        } while (Math.abs(filaD - filaF) + Math.abs(columnaD - columnaF)<10); // Asegurar una distancia mínima de 10
        this.tablero.get(filaD).set(columnaD, 'D');
    }


    public void modificar(int fila, int columna, char valor) {
        // Verificar que la posición sea válida y no sea la fuente o el drenaje
        if (fila >= 0 && fila < 8 && columna >= 0 && columna < 8 && this.tablero.get(fila).get(columna) != 'F' && this.tablero.get(fila).get(columna) != 'D') {
            this.tablero.get(fila).set(columna, valor);
        }
    }

    public boolean esSolucionCorrecta() {
        // Implementar un algoritmo para verificar si la solución es correcta
        return false;
    }

    public void mostrar() {
        for (LinkedList<Character> fila : this.tablero) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}


