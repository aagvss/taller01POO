package org.example;
import java.util.Scanner;

public class ProcesadorTexto {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int i;
        String frase;
        do {
            mostrarMenu();
            i = sc.nextInt();
            sc.nextLine();

            if (i >= 1 && i <= 4) {
                System.out.print("Ingresa la frase: ");
                frase = sc.nextLine();
                opciones(i, frase); 
            } else if (i != 5) {
                System.out.println("Opción inválida");
            }
        } while (i != 5);

        System.out.println("Adiós");
        sc.close();
    }
    public static void mostrarMenu(){
        System.out.print("""
                    \n Menu
                    1. Verificar Reves-Derecho
                    2. Contar Vocales
                    3. Encriptar Texto
                    4. Desencriptar Texto
                    5. Salir
                    Opción:""");
    }
    public static void opciones(int i, String frase){
        switch (i) {
            case 1->System.out.println("¿Es Reves-Derecho?: "+esRevesDerecho(frase));
            case 2->System.out.println("Vocales: "+contarVocales(frase));
            case 3->System.out.println("Encriptado: "+encriptarTexto(frase));
            case 4->System.out.println("Desencriptado: "+desencriptarTexto(frase));
            default -> System.out.println("Opcion no valida");
        }
    }
    public static boolean esRevesDerecho(String texto) {
        String limpio=texto.replaceAll("\\s+","").toLowerCase();
        String invertido=new StringBuilder(limpio).reverse().toString();
        return limpio.equals(invertido);
    }
    public static int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();
        for (char c : texto.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }
    public static String encriptarTexto(String texto) {
        return texto.toLowerCase()
                .replace("a","@")
                .replace("e",">")
                .replace("i","|")
                .replace("o",">*")
                .replace("u","#");
    }
    public static String desencriptarTexto(String texto) {
        return texto
                .replace(">*","o")
                .replace("@","a")
                .replace(">","e")
                .replace("|","i")
                .replace("#","u");
    }
}
