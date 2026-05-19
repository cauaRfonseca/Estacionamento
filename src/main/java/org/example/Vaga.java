package org.example;

public class Vaga {
    protected int numero;
    protected boolean ocupada = false;
    private Veículo veiculoEstacionado;

    public Vaga(int numero, Veículo veiculoEstacionado) {
        this.numero = numero;
        this.ocupada = false;
        this.veiculoEstacionado = null;
    }
    public boolean Estacionar(Veículo veiculo) {
        this.veiculoEstacionado = veiculo;
        this.ocupada = true;

        return true;
    }

    public boolean Liberar() {
        this.veiculoEstacionado = null;
        this.ocupada = false;
        return true;
    }

    public int GetNumero() { return numero; }
    public Veículo GetveiculoEstacionado() { return veiculoEstacionado; }
}
