package modelo;

public class Casa extends Financiamento{

    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
    }
    @Override
    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() + 80;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
