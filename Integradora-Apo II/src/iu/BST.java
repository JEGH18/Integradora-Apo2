package iu;

public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    public void agregarPuntaje(int puntos, int valor, Partida partida) {
        root = insertar(root, puntos, valor, partida);
    }

    private Node insertar(Node nodo, int puntos, int valor, Partida partida) {
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

    // Método para mostrar el árbol en orden
    public void mostrarEnOrden() {
        inOrden(root);
    }

    // Método auxiliar para recorrido inorden
    private void inOrden(Node nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzquierda());
            System.out.print(nodo.getValor() + " ");
            inOrden(nodo.getDerecha());
        }
    }
}
