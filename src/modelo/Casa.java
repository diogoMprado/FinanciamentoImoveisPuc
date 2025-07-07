package modelo;

import util.AumentoMaiorDoQueJurosException;

import java.io.Serial;
import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final double areaConstruida;
    private final double tamanhoDoTerreno;
    private double acrescimo;

    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, double areaConstruida,double tamanhoDoTerreno, double acrescimo) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.areaConstruida = areaConstruida;
        this.tamanhoDoTerreno = tamanhoDoTerreno;
        this.acrescimo = acrescimo;
    }


    @Override
    public double calcularPagamentoMensal() throws AumentoMaiorDoQueJurosException {
        double metadeValorJuros = (super.calcularPagamentoMensal() - (this.valorImovel / (this.prazoFinanciamento * 12)))/2;
        double base = super.calcularPagamentoMensal();


        if (this.acrescimo > metadeValorJuros){
            throw new AumentoMaiorDoQueJurosException("O valor do acrécimo é maior que a metade dos juros!",metadeValorJuros);
        }
        return base + this.acrescimo;
    }

    //PERMITE AJUSTAR O ACRÉSCIMO CASO TENHA ALGUMA EXCEÇÃO
    public void setAcrescimo(double acrescimo) {
        this.acrescimo = acrescimo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nÁrea construída: " + String.format("%.2f", this.areaConstruida) + "m²" +
                "\nTamanho do terreno: " + String.format("%.2f",this.tamanhoDoTerreno) + "m²"
                + "\nValor acrescimo: " + String.format("%.2f",this.acrescimo) + "\n";
    }
}
