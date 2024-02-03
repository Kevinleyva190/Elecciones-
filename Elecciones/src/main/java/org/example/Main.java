package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numVotantes;
        do {
            System.out.print("Ingrese el número de votantes (entre 5 y 100): ");
            numVotantes = scanner.nextInt();
        } while (numVotantes < 5 || numVotantes > 100);

        Votante[] votantes = new Votante[numVotantes];

        for (int i = 0; i < numVotantes; i++) {
            votantes[i] = new Votante();

            System.out.println("\nVotante #" + (i + 1));
            int votoVerde, votoAnaranjado, votoRojo;
            do {
                System.out.print("Ingrese la cantidad de votos para el Partido Verde: ");
                votoVerde = scanner.nextInt();
                System.out.print("Ingrese la cantidad de votos para el Partido Anaranjado: ");
                votoAnaranjado = scanner.nextInt();
                System.out.print("Ingrese la cantidad de votos para el Partido Rojo: ");
                votoRojo = scanner.nextInt();

                if (votoVerde + votoAnaranjado + votoRojo != 5) {
                    System.out.println("El total de votos debe ser exactamente 5. Inténtelo de nuevo.");
                }
            } while (votoVerde + votoAnaranjado + votoRojo != 5);

            scanner.nextLine(); // Limpiar el buffer del scanner
            System.out.print("Ingrese el género del votante (hombre/mujer): ");
            String genero = scanner.nextLine().toLowerCase();

            votantes[i].votar(votoVerde, votoAnaranjado, votoRojo, genero);
        }

        // Calcular resultados
        int totalVotosVerde = 0;
        int totalVotosAnaranjado = 0;
        int totalVotosRojo = 0;
        int totalHombres = 0;
        int totalMujeres = 0;

        for (Votante votante : votantes) {
            totalVotosVerde += votante.getVotosPartidoVerde();
            totalVotosAnaranjado += votante.getVotosPartidoAnaranjado();
            totalVotosRojo += votante.getVotosPartidoRojo();

            if (votante.getGenero().equals("hombre")) {
                totalHombres++;
            } else if (votante.getGenero().equals("mujer")) {
                totalMujeres++;
            }
        }

        // Determinar el partido ganador
        String partidoGanador;
        if (totalVotosVerde > totalVotosAnaranjado && totalVotosVerde > totalVotosRojo) {
            partidoGanador = "Verde";
        } else if (totalVotosAnaranjado > totalVotosVerde && totalVotosAnaranjado > totalVotosRojo) {
            partidoGanador = "Anaranjado";
        } else {
            partidoGanador = "Rojo";
        }

        // Calcular porcentaje de participación
        double porcentajeHombres = (double) totalHombres / numVotantes * 100;
        double porcentajeMujeres = (double) totalMujeres / numVotantes * 100;

        // Imprimir resultados
        System.out.println("\nResultados de las elecciones:");
        System.out.println("Partido ganador: " + partidoGanador);
        System.out.println("Porcentaje de participación de hombres: " + porcentajeHombres + "%");
        System.out.println("Porcentaje de participación de mujeres: " + porcentajeMujeres + "%");

        scanner.close();
    }}