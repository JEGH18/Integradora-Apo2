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
        } while (Math.abs(filaD - filaF) + Math.abs(columnaD - columnaF) < 9); // Asegurar una distancia mínima de 5
        this.tablero.get(filaD).set(columnaD, 'D');
    }

    public void colocarTuberia(int fila, int columna, char tipo) {

        //Se verifica que los valores ingresados por el usuario sean menores que 7 y mayores a 0
        if (fila < 0 || fila > 7 || columna < 0 || columna > 7) {
            System.out.println("Los valores de fila y columna deben estar entre 0 y 7.");
            return;
        }
        //Se verifica que el usuario no ponga tuberías en el punto de inicio ni de fin
        if (this.tablero.get(fila).get(columna) == 'F' || this.tablero.get(fila).get(columna) == 'D') {
            System.out.println("No puedes colocar una tubería en la posición de la fuente o el drenaje.");
            return;
        }
        //Se pide el tipo de tubería
        if (tipo != '=' && tipo != '|' && tipo != 'o') {
            System.out.println("El tipo de tubería debe ser '=', '||' o 'o'.");
            return;
        }
        //Se coloca la tubería
        this.tablero.get(fila).set(columna, tipo);

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
        // Mostrar el tablero en consola
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < 8; j++) {
                System.out.print(this.tablero.get(i).get(j) + "|");
            }
            System.out.println();
        }
    }

    public void simular() {
        // Implementar un algoritmo para simular el flujo de agua



    }
}



