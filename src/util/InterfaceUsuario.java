package util;

import Enums.TiposTerrenos;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class InterfaceUsuario {

    Scanner sc = new Scanner(System.in);

    public String Categorias (){
        System.out.print("Informe o tipo de financiamento(CASA/APARTAMENTO/TERRENO): ");
        return sc.nextLine();
    }


    // Recebe o valor do imóvel, com o teste "SE for maior que zero"
    public double valorImovel() {
        double valor = -1;
        while (valor <= 0) {
            System.out.print("Informe o valor do Imóvel: ");

            try {
                valor = sc.nextDouble();
                if (valor <= 0) {
                    System.out.println("Informe um valor válido!");
                }
            } catch (InputMismatchException e) { //Para quando digitar letras ou símbolos
                System.out.println("Valor deve ser apenas números!");
                sc.next();
            }
        }
        return valor;
    }

    // Recebe a quantidade de meses do financiamento, com o teste "SE for maior que zero"
    public int prazoFinanciamento(){
        int prazo = -1;
        while (prazo <= 0) {
            System.out.print("Informe o prazo de Financiamento: ");

            try {
                prazo = sc.nextInt();
                if (prazo <= 0){
                    System.out.println("Informe um Prazo de Financiamento maior que zero!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor deve ser apenas números!");
                sc.next();
            }
        }
        return prazo;
    }

    // Recebe o valor da taxa de juros anual, com o teste "SE for maior que zero"
    public double taxaJurosAnual(){
        double juros = -1;
        while (juros <= 0) {
            System.out.print("Informe a taxa de Juros: ");
            try {
                juros = sc.nextDouble();
                if (juros <= 0){
                    System.out.println("Informe a taxa de juros válida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor deve ser apenas números!");
                sc.next();
            }
        }
        return juros;
    }

    public double areaConstruida(){
        double area = -1;
        while (area <= 0) {
            System.out.print("Informe quantos m² de área contruída: ");
            try {
                area = sc.nextDouble();
                if (area <= 0){
                    System.out.println("Informe um de área contruída válida!");
                }
            } catch  (InputMismatchException e) {
                System.out.println("Valor deve ser apenas números!");
                sc.next();
            }
        }
        return area;
    }

    public double tamanhoDoTerreno(){
        double tamanho = -1;
        while (tamanho <= 0) {
            System.out.print("Informe o tamanho do terreno: ");
            try {
                tamanho = sc.nextDouble();
                if (tamanho <= 0){
                    System.out.println("Informe um tamanho de terreno válido!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor deve ser apenas números!");
                sc.next();
            }
        }
        return tamanho;
    }

    public int numeroDeVagas(){
        int numeroDeVagas = -1;
        while (numeroDeVagas <= 0) {
            System.out.print("Informe um numero de vagas: ");
            try {
                numeroDeVagas = sc.nextInt();
                if (numeroDeVagas <= 0){
                    System.out.println("Informe um número de vagas válido!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor deve ser apenas números!");
                sc.next();
            }
        }
        return numeroDeVagas;
    }

    public int numeroDoAndar(){
        int numeroDoAndar = -1;
        while (numeroDoAndar <= 0) {
            System.out.print("Informe um número de Andar: ");
            try {
                numeroDoAndar = sc.nextInt();
                if (numeroDoAndar <= 0){
                    System.out.println("Informe um numero de andar válido!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor deve ser apenas números!");
                sc.next();
            }
        }
        return numeroDoAndar;
    }

    public TiposTerrenos lerTipoTerreno() {
        while(true){
            System.out.print("Informe o tipo de Zona (Residencial, Comercial ou Rural): ");
            String tipoTerreno = sc.next().trim().toUpperCase();

            try{
                return TiposTerrenos.valueOf(tipoTerreno);

            } catch(IllegalArgumentException e){
                System.out.println("Informe o tipo de Zona!");
            }
        }
    }
}