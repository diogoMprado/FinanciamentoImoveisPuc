public class Financiamento {
    private Double valorImovel;
    private int prazoFinanciamento;
    private Double taxaJurosAnual;

    public Financiamento(){
    }

    public Financiamento(int prazoFinanciamento, Double taxaJurosAnual, Double valorImovel) {
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
        this.valorImovel = valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public Double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(Double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public Double getValorImovel() {
        return valorImovel;
    }

    public void setValorImovel(Double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public Double calcularPagamentoMensal(){
        return valorImovel / (prazoFinanciamento * 12) * (1 + (taxaJurosAnual / 12));
    }

    public Double calcularTotalPagamento(){
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }
}
