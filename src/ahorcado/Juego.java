package ahorcado;

import java.util.Scanner;

public class Juego {
	private Jugador jugador1;
    private Jugador jugador2;
    private int puntosJugador1;
    private int puntosJugador2;
    private static final int NUM_PARTIDAS = 5;
    
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del Jugador 1: ");
        jugador1 = new Jugador(scanner.nextLine());

        System.out.print("Introduce el nombre del Jugador 2: ");
        jugador2 = new Jugador(scanner.nextLine());

        for (int i = 0; i < NUM_PARTIDAS; i++) {
            System.out.println("\n--- Partida " + (i + 1) + " ---");
            Jugador creador = (i % 2 == 0) ? jugador1 : jugador2;
            Jugador adivinador = (i % 2 == 0) ? jugador2 : jugador1;

            System.out.print(creador.getNombre() + ", introduce la palabra a adivinar: ");
            String palabraOculta = scanner.nextLine().toLowerCase();
            ocultarPantalla();

            Partida partida = new Partida(palabraOculta);
            boolean adivinado = partida.jugar(adivinador);

            if (adivinado) {
                if (adivinador == jugador1) {
                    puntosJugador1++;
                } else {
                    puntosJugador2++;
                }
            }
        }

        mostrarResultados();
    }
    
    private void mostrarResultados() {
        System.out.println("\n--- Resultados Finales ---");
        System.out.println(jugador1.getNombre() + ": " + puntosJugador1 + " puntos");
        System.out.println(jugador2.getNombre() + ": " + puntosJugador2 + " puntos");

        if (puntosJugador1 > puntosJugador2) {
            System.out.println("¡" + jugador1.getNombre() + " gana el juego!");
        } else if (puntosJugador2 > puntosJugador1) {
            System.out.println("¡" + jugador2.getNombre() + " gana el juego!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }

    private void ocultarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
