package model;

import iu.BST;
import iu.Partida;
import iu.Tablero;
import iu.Node;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Partida partida = null;
        Tablero tablero = new Tablero();
        BST bst = new BST();

        boolean mostrarMenuPrincipal = true;
        while (mostrarMenuPrincipal) {
            System.out.println("----------------------------------");
            System.out.println("    -> |   PIPE MANIA   | <-      ");
            System.out.println("----------------------------------");
            System.out.println("1. Nueva partida");
            System.out.println("2. Ver puntaje");
            System.out.println("3. Salir");
            System.out.println("----------------------------------");

            int opcionPrincipal = Integer.parseInt(scanner.nextLine());


            switch (opcionPrincipal) {
                case 1:
                    System.out.println("----------------------------------");
                    System.out.println("Digite su nombre de usuario: ");
                    System.out.println("----------------------------------");
                    String nickname = scanner.nextLine();
                    partida = new Partida(nickname);

                    System.out.println("----------------------------------");
                    partida.iniciarNuevaPartida();


                    boolean mostrarMenuJuego = true;
                    while (mostrarMenuJuego) {
                        System.out.println("----------------------------------");
                        System.out.println("1. Poner Tuberia");
                        System.out.println("2. Simular");
                        System.out.println("3. Salir");
                        System.out.println("----------------------------------");

                        int opcionCaso1 = scanner.nextInt();

                        switch (opcionCaso1) {

                            case 1:

                                boolean ponerTuberia = true;
                                while (ponerTuberia) {
                                    //Se pide al usuario que ingrese la posición (fila y columna) donde quiere poner la tubería
                                    System.out.println("Introduce la fila donde deseas colocar la tubería:");
                                    int fila = scanner.nextInt();

                                    fila -= 1;

                                    //Se verifica que los valores ingresados por el usuario sean menores que 7 y mayores a 0

                                    if (fila < 0 || fila > 7) {
                                        System.out.println("Los valores de fila y columna deben estar entre 0 y 7.");
                                        return;
                                    }

                                    System.out.println("Introduce la columna donde deseas colocar la tubería:");
                                    int columna = scanner.nextInt();

                                    columna -= 1;

                                    //Se verifica que los valores ingresados por el usuario sean menores que 7 y mayores a 0

                                    if (columna < 0 || columna > 7) {
                                        System.out.println("Los valores de fila y columna deben estar entre 0 y 7.");
                                        return;
                                    }

                                    //Se limpia el buffer
                                    scanner.nextLine();

                                    //Se pide al usuario que ingrese el tipo de tubería que quiere colocar
                                    System.out.println("Introduce el tipo de tubería que deseas colocar ('=', '|', 'o'):");
                                    char tipo = scanner.nextLine().charAt(0);

                                    partida.colocarTuberia(fila, columna, tipo);


                                    //Se muestra el tablero después de poner la tubería
                                    partida.mostrarTablero();

                                    //Se verifica si el usuario quiere poner otra tubería
                                    System.out.println("¿Deseas poner otra tubería? (S/N)");
                                    String respuesta1 = "S";
                                    String respuesta2 = "N";
                                    String respuesta = scanner.nextLine();

                                    if(!respuesta.equalsIgnoreCase(respuesta1) && !respuesta.equalsIgnoreCase(respuesta2)){
                                        System.out.println("ATENCIÓN \n Debe ingresar carácteres válidos: S/N ");
                                        System.exit(1);
                                    }

                                    if (respuesta.equals("N") || respuesta.equals("n")) {
                                        ponerTuberia = false;
                                        partida.setTiempoFin(System.currentTimeMillis());
                                    }
                                }


                                if (partida.esSolucionCorrecta()) {

                                    partida.mostrarResultados();
                                    System.out.println("La solución es correcta\n");
                                    System.out.println("Tiempo total: " + partida.getTiempoEnSegundos() + " segundos");
                                    bst.agregarPuntaje(partida.getTuberiasUsadas(), partida.getTiempoEnSegundos(), partida);

                                    // Mostrar la tabla de puntuaciones
                                    System.out.println("Tabla de puntuaciones:");
                                    bst.mostrarEnOrden();


                                } else {
                                    partida.mostrarResultados();
                                    System.out.println("La solución no es correcta");
                                    System.out.println("Tiempo total: " + partida.getTiempoEnSegundos() + " segundos");
                                    bst.agregarPuntaje(partida.getTuberiasUsadas(), partida.getTiempoEnSegundos(), partida);

                                    // Mostrar la tabla de puntuaciones
                                    System.out.println("Tabla de puntuaciones:");
                                    bst.mostrarEnOrden();
    
                                }

                                break;

                            case 2:
                                System.out.println("Simulando...");
                                partida.simular();
                                if (partida.esSolucionCorrecta()) {
                                    partida.mostrarResultados();
                                } else {
                                    System.out.println("La solución no es correcta");
                                }
                                break;

                            case 3:
                                System.out.println("Saliendo de PipeMania");
                                System.exit(0);
                                mostrarMenuJuego = false;
                                break;

                            default:
                                System.out.println("Opción inválida");
                                break;

                        }
                        mostrarMenuPrincipal = true;
                    }

                case 2:
                    if (partida != null) { // Verificar si se ha creado una partida
                        bst.mostrarEnOrden();
                    } else {
                        System.out.println("Primero debes crear una partida.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo de PipeMania");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }


        }

    }


}
