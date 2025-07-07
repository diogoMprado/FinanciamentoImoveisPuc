package modelo;

import util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento {

    private final double areaConstruida;
    private final double tamanhoDoTerreno;
    private double acrescimo;

    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, double areaConstruida,double tamanhoDoTerreno, double acrescimo) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.areaConstruida = areaConstruida;
        this.tamanhoDoTerreno = tamanhoDoTerreno;
        this.acrescimo = acrescimo;
    }

    private void testeValorJuros (double acrescimo, double valorJuros){
        if (acrescimo > valorJuros){
            throw new AumentoMaiorDoQueJurosException("O valor do acrécimo é maior que o valor dos juros! Será corrigido.");
        }
    }

    @Override
    public double calcularPagamentoMensal(){
        double metadeValorJuros = (super.calcularPagamentoMensal() - (this.valorImovel / (this.prazoFinanciamento * 12)))/2;
//80 for maior do que a metade do valor dos juros da mensalidade.
        try{
            testeValorJuros(acrescimo, metadeValorJuros);
        }
        catch (AumentoMaiorDoQueJurosException e){
            System.out.println(e.getMessage());
            this.acrescimo = metadeValorJuros;
        }
        return super.calcularPagamentoMensal() + this.acrescimo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nÁrea construída: " + String.format("%.2f", this.areaConstruida) +
                "\nTamanho do terreno: " + String.format("%.2f",this.tamanhoDoTerreno) + "\n";
    }
}
