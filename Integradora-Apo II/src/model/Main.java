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
                partida.mostrarTablero();
                partida.iniciarNuevaPartida();

                System.out.println("----------------------------------");
                System.out.println("1. Poner Tuberia");
                System.out.println("2. Simular");
                System.out.println("3. Salir");
                System.out.println("----------------------------------");

                int opcionCaso1 = scanner.nextInt();
                switch (opcionCaso1) {
                    case 1:
                        //Implementar "colocar Tuberia"
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

