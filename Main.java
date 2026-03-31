package org.example;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento(10);
        int opcao = 0;
        do {
            System.out.println("\n--- Menu Estacionamento ---");
            System.out.println("1 - Registrar veículo");
            System.out.println("2 - Registrar saída");
            System.out.println("3 - Exibir vagas livres");
            System.out.println("4 - Sair do sistema");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();
        } while (opcao!=4);
        System.out.println("Tchau");
    }
}