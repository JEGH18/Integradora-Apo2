package iu;

public class LinkedList {

    private Node inicio;

    public LinkedList(Node inicio) {
        this.inicio = new Node(0);
        Node filaActual = inicio;
        Node columnaActual;

        for(int i = 0; i<8; i++){
            columnaActual = filaActual;
            for(int j = 1; j<8; j++){
                Node nuevoNodo = new Node(0);
                columnaActual. = nuevoNodo;
                nuevoNodo. = columnaActual;
                columnaActual = nuevoNodo;
            }
            if(i<7){
                Node nuevaFila = new Node(0);
            }
        }
    }

}
