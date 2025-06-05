import java.util.Scanner;

public interface InterfaceUsuario {

    Scanner sc = new Scanner(System.in);

    Double solicitarValorImovel(System.out.println("Qual o valor do imóvel?"), return sc.nextDouble())


    default int solicitarPrazoFinanciamto(){
        System.out.println("Qual o prazo do financiamento?");
        return sc.nextInt();
    }

    default Double solicitarTaxaJurosAnual(){
        System.out.println("Qual a taxa de juros?");
        return sc.nextDouble();
    }
}
