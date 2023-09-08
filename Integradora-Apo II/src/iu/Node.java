package iu;

public class Node {

    private int valor;
    private Node arriba;
    private Node abajo;
    private Node izquierda;
    private Node derecha;
    private Node next;
    private Node previous;

    public Node(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getArriba() {
        return arriba;
    }

    public void setArriba(Node arriba) {
        this.arriba = arriba;
    }

    public Node getAbajo() {
        return abajo;
    }

    public void setAbajo(Node abajo) {
        this.abajo = abajo;
    }

    public Node getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Node izquierda) {
        this.izquierda = izquierda;
    }

    public Node getDerecha() {
        return derecha;
    }

    public void setDerecha(Node derecha) {
        this.derecha = derecha;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
