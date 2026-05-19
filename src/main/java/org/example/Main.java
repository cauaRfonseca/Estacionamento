package org.example;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento(10);
        String placaT, modeloT;
        int opcao = 0;
        do {
            System.out.println("\n--- Menu Estacionamento ---");
            System.out.println("1 - Registrar veículo");
            System.out.println("2 - Registrar saída");
            System.out.println("3 - Exibir vagas livres");
            System.out.println("4 - Sair do sistema");
            System.out.println("Escolha uma opção: ");

            String entradaOpcao = scanner.nextLine().trim();
            try {
                opcao = Integer.parseInt(entradaOpcao);
            }catch(NumberFormatException e){
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Entrada inválida. Digite apenas um número de 1 a 4.");
                System.out.println("Tente novamente.");
                continue;
            }

            switch(opcao){
                case 1:
                    System.out.println("@#@#@#@# Registrando Entrada @#@#@#@#");
                    System.out.println("Digite a placa do veículo");
                    String entradaPlaca = scanner.nextLine().trim();
                    System.out.println("Digite o modelo do veículo");
                    String entradaModelo = scanner.nextLine().trim();
                    Veículo veiculo = new Veículo(entradaPlaca, entradaModelo);
                    estacionamento.entradaVeiculo(veiculo);
                    break;
                case 2:
                    if (estacionamento.vagasLivres==estacionamento.totalDeVagas){
                        System.out.println("Não há veículos estacionados");
                    }else {
                        System.out.println("@#@#@#@# Registrando Saida @#@#@#@#");
                        System.out.println("Digite a placa do veículo");
                        String saidaPlaca = scanner.nextLine().trim();
                        estacionamento.saidaVeiculo(saidaPlaca);
                    }
                    break;
                case 3:
                    estacionamento.exibirVagasLivres();
                    break;
            }

        } while (opcao!=4);
        System.out.println("Tchau");
    }
}