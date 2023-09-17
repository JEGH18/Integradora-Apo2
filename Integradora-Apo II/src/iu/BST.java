package iu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    public void agregarPuntaje(int tuberiasUsadas, int tiempoEnSegundos, Partida partida) {
        int puntos = (100 - tuberiasUsadas) * 10 - tiempoEnSegundos;
        root = insertar(root, puntos, partida.getNombreJugador(), partida);
    }

    private Node insertar(Node nodo, int puntos, String valor, Partida partida) {
        if (nodo == null) {
            return new Node(puntos, valor, partida);
        }

        if (puntos < nodo.getPuntos()) {
            Node izquierda = insertar(nodo.getIzquierda(), puntos, valor, partida);
            nodo.setIzquierda(izquierda); // Establecer nodo izquierdo
        } else if (puntos > nodo.getPuntos()) {
            Node derecha = insertar(nodo.getDerecha(), puntos, valor, partida);
            nodo.setDerecha(derecha); // Establecer nodo derecho
        }

        return nodo;
    }
    private int contadorJugadores;

    // Método para mostrar el árbol en orden
    public void mostrarEnOrden() {
        this.contadorJugadores = 1;
        inOrden(root);
    }

    // Método auxiliar para recorrido inorden
    private void inOrden(Node nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzquierda());
            Partida partida = nodo.getPartida();
            int tuberiasUsadas = partida.getTuberiasUsadas();
            int tiempoEnSegundos = partida.getTiempoEnSegundos();
            int puntos = (100 - tuberiasUsadas) * 10 - tiempoEnSegundos;
            System.out.print(this.contadorJugadores + ". Jugador: " + nodo.getValor() + ", Puntos: " + puntos + "\n");
            this.contadorJugadores++;
            inOrden(nodo.getDerecha());
        }
    }
}
