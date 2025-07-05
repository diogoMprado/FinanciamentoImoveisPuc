package modelo;

public abstract class Financiamento {

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    // Construtor de "Financiamento"
    public Financiamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        this.valorImovel = valorImovel;
        this.taxaJurosAnual = taxaJurosAnual;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public double calcularPagamentoMensal(){
        return this.valorImovel / (this.prazoFinanciamento * 12) * (1 + (this.taxaJurosAnual / 12));
    }

    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }
    public String toString() {
        return "Valor financiamento do imóvel: R$ " + String.format("%.2f",valorImovel) +
                "\nPrazo financiamento: " + prazoFinanciamento + " ano(s)" +
                "\nTaxa de juros anual: " + taxaJurosAnual + "%" +
                "\nValor Mensal: R$ " + String.format("%.2f",calcularPagamentoMensal()) +
                "\nValor total: R$ " + String.format("%.2f", calcularTotalPagamento());
    }

}
