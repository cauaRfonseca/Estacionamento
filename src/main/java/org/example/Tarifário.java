package org.example;

public class Tarifário {
    private double valorHora;
    private double valorDiaria;
    private double valorSemanal;
    private double valorMensal;

    public Tarifário(double v, double v1, double v2, double v3){
        this.valorHora = valorHora;
        this.valorDiaria = valorDiaria;
        this.valorSemanal = valorSemanal;
        this.valorMensal = valorMensal;
    }

    public double calcularValor(long totalMinutos) {
        double totalHoras = Math.ceil(totalMinutos / 60.0);

        if (totalHoras > 504) return valorMensal;
        if (totalHoras > 120) return valorSemanal;
        if (totalHoras >= 24) return valorDiaria;
        if (totalHoras * valorHora > valorDiaria) return valorDiaria;

        if (totalHoras < 1) totalHoras = 1; // Cobrança mínima de 1 hora
        return totalHoras * valorHora;
    }
}
