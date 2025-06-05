package modelo;

public class Financiamento {

    private Double valorImovel;
    private Integer prazoFinanciamento;
    private Double taxaJurosAnual;

    // Construtor de "Financiamento"
    public Financiamento(Double valorImovel, Double taxaJurosAnual, int prazoFinanciamento) {
        this.valorImovel = valorImovel;
        this.taxaJurosAnual = taxaJurosAnual;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public Double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public Double getValorImovel() {
        return valorImovel;
    }

    public Double calcularPagamentoMensal(){
        return valorImovel / (prazoFinanciamento * 12) * (1 + (taxaJurosAnual / 12));
    }

    public Double calcularTotalPagamento(){
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    @Override
    public String toString() {
        return "Valor financiamento do imóvel: R$ " + String.format("%.2f",valorImovel) +
                "\nPrazo financiamento: " + prazoFinanciamento +
                "\nTaxa de juros anual: " + taxaJurosAnual + "%" +
                "\nValor Mensal: R$ " + String.format("%.2f",calcularPagamentoMensal()) +
                "\nValor total: R$ " + String.format("%.2f", calcularTotalPagamento());
    }
}
