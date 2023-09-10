package model;

import iu.Partida;
import iu.Tablero;
import iu.Node;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("----------------------------------");
        System.out.println("1. Nueva partida");
        System.out.println("2. Ver puntaje");
        System.out.println("3. Salir");
        System.out.println("----------------------------------");

        int opcionPrincipal = Integer.parseInt(scanner.nextLine());
        switch (opcionPrincipal) {
            case 1:
                System.out.println("Digite su nombre de usuario: ");
                String nickname = scanner.nextLine();
                Partida partida = new Partida(nickname);
                partida.iniciarNuevaPartida();

                System.out.println("----------------------------------");
                System.out.println("1. Poner Tuberia");
                System.out.println("2. Simular");
                System.out.println("3. Salir");
                System.out.println("----------------------------------");

                int opcionCaso1 = scanner.nextInt();
                switch (opcionCaso1) {
                    case 1:
                        //Se pide al usuario que ingrese la posición (fila y columna) donde quiere poner la tubería
                        System.out.println("Introduce la fila donde deseas colocar la tubería:");
                        int fila = scanner.nextInt();
                        System.out.println("Introduce la columna donde deseas colocar la tubería:");
                        int columna = scanner.nextInt();

                        //Se limpia el buffer
                        scanner.nextLine();

                        //Se pide al usuario que ingrese el tipo de tubería que quiere colocar
                        System.out.println("Introduce el tipo de tubería que deseas colocar ('=', '|', 'o'):");
                        char tipo = scanner.nextLine().charAt(0);

                        partida.colocarTuberia(fila, columna, tipo);


                        //Se muestra el tablero después de poner la tubería
                        partida.mostrarTablero();
                        break;
                    case 2:
                        //Implementar "Simular"
                    case 3:
                        System.out.println("Saliendo de PipeMania");
                        System.exit(0);
                }

            case 2:

                //Implementar calculo de Puntaje

            case 3:
                System.out.println("Saliendo de PipeMania");
                System.exit(0);
        }

    }


}

