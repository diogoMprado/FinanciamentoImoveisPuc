package modelo;

import enums.TiposTerrenos;
import util.AumentoMaiorDoQueJurosException;

import java.io.Serial;
import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final TiposTerrenos tipoDeZona;

    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, TiposTerrenos tipoDeZona) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.tipoDeZona = tipoDeZona;
    }

    @Override
    public double calcularPagamentoMensal() throws AumentoMaiorDoQueJurosException {
        double valorMensal = super.calcularPagamentoMensal();
        return valorMensal + valorMensal * 0.2 ;
    }

    @Override
    public String toString(){
        return super.toString() + "\nTipo de Zona: " + this.tipoDeZona;
    }
}
