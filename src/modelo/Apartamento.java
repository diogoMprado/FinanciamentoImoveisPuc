package modelo;

public class Apartamento extends Financiamento{

    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
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
