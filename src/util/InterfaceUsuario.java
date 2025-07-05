package util;

import java.util.Scanner;

public class InterfaceUsuario {

    Scanner sc = new Scanner(System.in);

    public String Categorias (){
        System.out.print("Informe o tipo de financiamento(CASA/APARTAMENTO/TERRENO): ");
        String tipo = sc.nextLine();
        return tipo;
    }


    // Recebe o valor do imóvel, com o teste "SE for maior que zero"
    public double valorImovel(){
        double valor;
        do {
            System.out.print("Informe o valor do Imóvel: ");
            valor = sc.nextDouble();
            if (valor <= 0) {
                System.out.println("Informe um valor válido!");
            }
        } while (valor <= 0);
        return valor;
    }

    // Recebe a quantidade de meses do financiamento, com o teste "SE for maior que zero"
    public int prazoFinanciamento(){
        int prazo;
        do {
            System.out.print("Informe o Prazo de Financiamento: ");
            prazo = sc.nextInt();
            if (prazo <= 0){
                System.out.println("Informe um Prazo de Financiamento maior que zero!");
            }
        }
        while (prazo <= 0);
        return prazo;
    }

    // Recebe o valor da taxa de juros anual, com o teste "SE for maior que zero"
    public double taxaJurosAnual(){
        double juros;
        do {
            System.out.print("Informe o taxa juros: ");
            juros = sc.nextDouble();
            if (juros <= 0 || juros > 1000) {
                System.out.println("Informe um valor válido!");
            }
        }
        while(juros <= 0 || juros > 1000);
        return juros;
    }
}
