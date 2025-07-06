package modelo;

import Enums.TiposTerrenos;

public class Terreno extends Financiamento{

    private final TiposTerrenos tipoDeZona;

    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, TiposTerrenos tipoDeZona) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.tipoDeZona = tipoDeZona;
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
