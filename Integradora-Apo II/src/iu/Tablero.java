package iu;

import java.util.LinkedList;

public class Tablero {
    private LinkedList<LinkedList<Character>> tablero;
    private Partida partida;
    private boolean[][] visitado;

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
        } while (Math.abs(filaD - filaF) + Math.abs(columnaD - columnaF) < 2); // Asegurar una distancia mínima de 10
        this.tablero.get(filaD).set(columnaD, 'D');
    }

    public void colocarTuberiaEnTablero(int fila, int columna, char tipo, Partida partida) {
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
            System.out.println("El tipo de tubería debe ser '=', '|', o 'o'.");
            return;
        }
        //Se coloca la tubería
        this.tablero.get(fila).set(columna, tipo);

        partida.actualizarEstado(partida.getTuberiasUsadas() + 1);
    }

    public void modificar(int fila, int columna, char valor) {
        // Verificar que la posición sea válida y no sea la fuente o el drenaje
        if (fila >= 0 && fila < 8 && columna >= 0 && columna < 8 && this.tablero.get(fila).get(columna) != 'F' && this.tablero.get(fila).get(columna) != 'D') {
            this.tablero.get(fila).set(columna, valor);
        }
    }

    public boolean esSolucionCorrecta() {
        // Reiniciar la matriz de visitados antes de cada verificación
        this.visitado = new boolean[8][8];
    
        // Encontrar la posición de la fuente (F)
        int filaF = -1, columnaF = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j< 8; j++) {
                if (this.tablero.get(i).get(j) == 'F') {
                    filaF = i;
                    columnaF = j;
                    break;
                }
            }
            if (filaF != -1) {
                break;
            }
        }
    
        // Iniciar la verificación desde la fuente con todas las direcciones posibles
        return dfs(filaF, columnaF, '|') || dfs(filaF, columnaF, '=');
    }
    

    private boolean dfs(int fila, int columna, char direccion) {
        // Verificar si hemos llegado al drenaje (D)
        if (this.tablero.get(fila).get(columna) == 'D') {
            return true;
        }
    
        // Marcar la celda actual como visitada
        this.visitado[fila][columna] = true;
    
        // Explorar las celdas vecinas
        int[] dx = {-1, 0, 1, 0}; // Desplazamiento en x (fila)
        int[] dy = {0, 1, 0, -1}; // Desplazamiento en y (columna)
        char[] direcciones = {'|', '=', '|', '='}; // Direcciones correspondientes a los desplazamientos
        for (int i = 0; i < 4; i++) {
            if (direcciones[i] == direccion || this.tablero.get(fila).get(columna) == 'o') {
                int nuevaFila = fila + dx[i];
                int nuevaColumna = columna + dy[i];
    
                // Verificar si la nueva posición es válida y no ha sido visitada
                if (nuevaFila >= 0 && nuevaFila < 8 && nuevaColumna >= 0 && nuevaColumna < 8 && !this.visitado[nuevaFila][nuevaColumna]) {
                    if (dfs(nuevaFila, nuevaColumna, direcciones[(i+2)%4])) { // La dirección opuesta
                        return true;
                    }
                }
            }
        }
    
        return false;
    }
    
    public void simular() {
        // Reiniciar la matriz de visitados antes de cada simulación
        this.visitado = new boolean[8][8];
    
        // Encontrar la posición de la fuente (F)
        int filaF = -1, columnaF = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j< 8; j++) {
                if (this.tablero.get(i).get(j) == 'F') {
                    filaF = i;
                    columnaF = j;
                    break;
                }
            }
            if (filaF != -1) {
                break;
            }
        }
    
        // Iniciar la simulación desde la fuente con todas las direcciones posibles
        dfs(filaF, columnaF, '|');
        dfs(filaF, columnaF, '=');
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
}