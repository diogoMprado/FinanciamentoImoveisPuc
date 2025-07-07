package util;

public class AumentoMaiorDoQueJurosException extends Exception {
    private final double valorCorrigido;

    public AumentoMaiorDoQueJurosException(String message, double valorCorrigido) {
        super(message);
        this.valorCorrigido = valorCorrigido;
    }

    public double getValorCorrigido() {
        return valorCorrigido;
    }
}
