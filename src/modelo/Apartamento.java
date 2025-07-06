package modelo;

public class Apartamento extends Financiamento{

    private final int numeroDeVagas;
    private final int numeroDoAndar;

    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, int numeroDeVagas, int numeroDoAndar) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.numeroDeVagas = numeroDeVagas;
        this.numeroDoAndar = numeroDoAndar;
    }

    @Override
    public double calcularPagamentoMensal(){

        double taxaAnual = taxaJurosAnual / 100; // converte de percentual para decimal
        double taxaMensal = taxaAnual / 12;
        int meses = prazoFinanciamento * 12;

        double fator = Math.pow(1 + taxaMensal, meses);
        return (valorImovel * fator * taxaMensal) / (fator - 1);

    }
    @Override
    public String toString() {
        return super.toString();
    }
}
