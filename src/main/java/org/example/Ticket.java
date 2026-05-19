package org.example;
import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private Veículo carro;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Ticket(Veículo carro){
        this.carro = carro;
        this.horaEntrada = LocalDateTime.now();
    }

    public void registrarSaida() {
        this.horaSaida = LocalDateTime.now();
    }

    public long calcularTempoEmMinutos() {
        if (this.horaSaida == null) {
            registrarSaida();
        }
        return Duration.between(this.horaEntrada, this.horaSaida).toMinutes();
    }

    public Veículo getCarro() {
        return carro;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }
}
