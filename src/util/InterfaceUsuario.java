package util;

import java.util.Objects;
import java.util.Scanner;

public class InterfaceUsuario {

    Scanner sc = new Scanner(System.in);

    public String Categorias (){
        System.out.print("Informe o tipo de financiamento(CASA/APARTAMENTO/TERRENO): ");
        return sc.nextLine();
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

    public double areaConstruida(){
        double area;
        do {
            System.out.print("Informe quantos m² de área contruída: ");
            area = sc.nextDouble();
            if (area <= 0) {
                System.out.println("Informe um de área contruída válida!");
            }
        }
        while (area <= 0);
        return area;
    }

    public double tamanhoDoTerreno(){
        double tamanho;
        do {
            System.out.print("Informe o Tamanho do Terreno: ");
            tamanho = sc.nextDouble();
            if (tamanho <= 0) {
                System.out.println("Informe um tamanho de terreno válido!");
            }
        }
        while (tamanho <= 0);
        return tamanho;
    }

    public int numeroDeVagas(){
        int numeroDeVagas;
        do {
            System.out.print("Informe o numero de Vagas: ");
            numeroDeVagas = sc.nextInt();
            if (numeroDeVagas <= 0) {
                System.out.println("Informe um número de vagas válido!");
            }
        }
        while (numeroDeVagas <= 0);
        return numeroDeVagas;
    }

    public int numeroDoAndar(){
        int numeroDoAndar;
        do {
            System.out.print("Informe o numero do andar: ");
            numeroDoAndar = sc.nextInt();
            if (numeroDoAndar < 0) {
                System.out.println("Informe um numero de andar válido!");
            }
        }
        while (numeroDoAndar < 0);
        return numeroDoAndar;
    }

    public String TiposTerrenos() {
        String tipoDeZona;
        do{
            System.out.print("Informe o tipo de Zona (Residencial ou Comercial): ");
            tipoDeZona = sc.next();
            if (tipoDeZona == null) {
                System.out.println("Informe o tipo de Zona!");
            }
        }
        while (tipoDeZona == null);
        return tipoDeZona;
    }
}