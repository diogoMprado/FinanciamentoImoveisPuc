package modelo;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double tamanhoDoTerreno;

    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, double areaConstruida,double tamanhoDoTerreno) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.areaConstruida = areaConstruida;
        this.tamanhoDoTerreno = tamanhoDoTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }
    public void setAreaConstruida(double areaConstruida) {}

    public double getTamanhoDoTerreno() {
        return tamanhoDoTerreno;
    }
    public void setTamanhoDoTerreno(double tamanhoDoTerreno) {}

    @Override
    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() + 80;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
