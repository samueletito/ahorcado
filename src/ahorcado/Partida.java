package ahorcado;

import java.util.Scanner;

public class Partida {
	private String palabraOculta;
    private StringBuilder progreso;
    private int intentos;
    private static final int MAX_INTENTOS = 6;

    public Partida(String palabraOculta) {
        this.palabraOculta = palabraOculta.toLowerCase();
        this.intentos = 0;
        this.progreso = new StringBuilder();
        for (int i = 0; i < palabraOculta.length(); i++) {
            progreso.append("_");
        }
    }
    
    public boolean jugar(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        while (intentos < MAX_INTENTOS && progreso.indexOf("_") != -1) {
            System.out.println("\nPalabra: " + progreso);
            System.out.println("Intentos restantes: " + (MAX_INTENTOS - intentos));
            System.out.print(jugador.getNombre() + ", introduce una letra: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Entrada no válida. Introduce una sola letra.");
                continue;
            }

            char letra = input.charAt(0);
            if (palabraOculta.contains(Character.toString(letra))) {
                System.out.println("¡Correcto! La letra " + letra + " está en la palabra.");
                actualizarProgreso(letra);
            } else {
                System.out.println("Incorrecto. La letra " + letra + " no está en la palabra.");
                intentos++;
            }
        }

        if (progreso.indexOf("_") == -1) {
            System.out.println("\n¡Felicidades, " + jugador.getNombre() + "! Adivinaste la palabra: " + palabraOculta);
            return true;
        } else {
            System.out.println("\nLo siento, " + jugador.getNombre() + ". Has agotado tus intentos. La palabra era: " + palabraOculta);
            return false;
        }
    }
        
    private void actualizarProgreso(char letra) {
    	for (int i = 0; i < palabraOculta.length(); i++) {
    		if (palabraOculta.charAt(i) == letra) {
    			progreso.setCharAt(i, letra);
            }
        }
    }
}
