package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Estacionamento {
    private ArrayList<Vaga> vagas;
    private ArrayList<Ticket> ticketsAbertos;
    private Tarifário tarifario;
    protected int totalDeVagas;
    protected int vagasLivres = totalDeVagas;
    Scanner scanner = new Scanner(System.in);

    public Estacionamento(int totalDeVagas) {
        this.tarifario = new Tarifário(10.0, 20.0, 30.0, 40.0);
        this.vagas = new ArrayList<>();
        this.ticketsAbertos = new ArrayList<>();

        for (int i = 1; i <= totalDeVagas; i++){
            Vaga novaVaga = new Vaga(i, null);
            this.vagas.add(novaVaga);
        }
    }

    public void entradaVeiculo(Veículo veiculo){
        int contador = 0;
        for (Vaga vaga : vagas){
            if (!vaga.ocupada) {
                vaga.Estacionar(veiculo);
                vagasLivres --;

                Ticket novoTicket = new Ticket(veiculo);
                ticketsAbertos.add(novoTicket);
                break;
            }
            contador++;
        }
        if (contador == 10){
            System.out.println("Não há vagas disponíveis");
        }
    }

    public void saidaVeiculo(String saidaPlaca) {
        int contador = 0;
        for (Vaga vaga : vagas) {
            if (vaga.ocupada && vaga.GetveiculoEstacionado().getPlaca().equalsIgnoreCase(saidaPlaca)) {
                Ticket ticketDoCarro = null;
                for (Ticket ticket : ticketsAbertos) {
                    if (ticket.getCarro().getPlaca().equalsIgnoreCase(saidaPlaca)) {
                        ticketDoCarro = ticket;
                        break;
                    }
                }
                System.out.println("[ Vaga " + vaga.GetNumero() + " - " + vaga.GetveiculoEstacionado().getPlaca() + " ]");
                System.out.println("Vaga liberada com sucesso");
                long minutos = ticketDoCarro.calcularTempoEmMinutos();
                double valorCobrado = tarifario.calcularValor(minutos);
                ticketsAbertos.remove(ticketDoCarro);
                vaga.Liberar();
                vagasLivres++;
                contador++;
                System.out.println("Tempo estacionado: " + minutos + " minutos.");
                System.out.printf("Total a pagar: R$ " + valorCobrado);
                break;
            }
        }
        if (contador==totalDeVagas) {
            System.out.println("Não foi encontrado nenhum veículo com a placa: " + saidaPlaca);
        }
    }

    public void exibirVagasLivres() {
        System.out.println("--- Vagas Disponíveis ---");
        int contador = 0;

        for (Vaga vaga : vagas) {
            if (vaga.ocupada) {
                System.out.println("[ Vaga " + vaga.GetNumero() + " - " + vaga.GetveiculoEstacionado().getPlaca() + " ]");
            } else {
                System.out.println("[ Vaga " + vaga.GetNumero() + " - Vazia ]");
                contador++;
            }
        }
        System.out.println("\nTotal de vagas livres : " + contador);
    }
}
