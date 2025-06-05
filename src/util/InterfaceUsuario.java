package util;

import java.util.Scanner;

public class InterfaceUsuario {

    Scanner sc = new Scanner(System.in);

    // Recebe o valor do imóvel, com o teste "SE for maior que zero"
    public Double valorImovel(){
        while(true){
            System.out.print("Informe o valor do Imóvel: ");
            double valor = sc.nextDouble();
            if (valor > 0){
                return valor;
            }
            else{
                System.out.println("Informe um valor válido!");
            }
        }
    }

    // Recebe a quantidade de meses do financiamento, com o teste "SE for maior que zero"
    public int prazoFinanciamento(){
        while(true){
            System.out.print("Informe o Prazo de Financiamento: ");
            int prazo = sc.nextInt();
            if (prazo > 0){
                return prazo;
            }
            else{
                System.out.println("Informe um Prazo de Financiamento maior que zero!");
            }
        }
    }
    // Recebe o valor da taxa de juros anual, com o teste "SE for maior que zero"
    public Double taxaJurosAnual(){
        while(true) {
            System.out.print("Informe o taxa juros: ");
            double juros = sc.nextDouble();
            if (juros > 0 && juros <= 1000) {
                return juros;
            }
            else {
                System.out.println("Informe um valor válido!");
            }
        }
    }
}
