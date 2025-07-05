package modelo;

public class Terreno extends Financiamento{
    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
    }

    @Override
    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() + super.calcularPagamentoMensal() * 0.2 ;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
