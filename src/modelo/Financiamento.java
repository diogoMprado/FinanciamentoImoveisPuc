package modelo;

import util.AumentoMaiorDoQueJurosException;

import java.io.Serial;
import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    // Construtor de "Financiamento"
    public Financiamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        this.valorImovel = valorImovel;
        this.taxaJurosAnual = taxaJurosAnual;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public double calcularPagamentoMensal() throws AumentoMaiorDoQueJurosException {
        return this.valorImovel / (this.prazoFinanciamento * 12) * (1 + (this.taxaJurosAnual / 12));
    }

    public double calcularTotalPagamento() throws AumentoMaiorDoQueJurosException {
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }
    public String toString() {
        try {
            return "Valor financiamento do imóvel: R$ " + String.format("%.2f",valorImovel) +
                    "\nPrazo financiamento: " + prazoFinanciamento + " ano(s)" +
                    "\nTaxa de juros anual: " + String.format("%.2f",taxaJurosAnual) + "%" +
                    "\nValor Mensal: R$ " + String.format("%.2f",calcularPagamentoMensal()) +
                    "\nValor total: R$ " + String.format("%.2f", calcularTotalPagamento());
        } catch (AumentoMaiorDoQueJurosException e) {
            throw new RuntimeException(e);
        }
    }
}
