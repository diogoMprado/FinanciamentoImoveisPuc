package modelo;

import Enums.TiposTerrenos;

public class Terreno extends Financiamento{

    private final String tipoDeZona;

    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, String tipoDeZona) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.tipoDeZona = tipoDeZona;
    }

    public String getTipoDeZona() {
        return tipoDeZona;
    }

    public void setTipoDeZona(String tipoDeZona) {
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
