package util;

import enums.Categorias;
import enums.TiposTerrenos;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;

import java.util.Scanner;

public class InterfaceUsuario {
    private final Scanner sc = new Scanner(System.in);

    public Categorias tipoFinanciamento() {
        while (true) {
            System.out.print("Informe o tipo de financiamento (CASA/APARTAMENTO/TERRENO): ");
            String linha = sc.nextLine().trim().toUpperCase();
            if (linha.isEmpty()) continue;
            try {
                return Categorias.valueOf(linha);
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de financiamento incorreto!");
            }
        }
    }

    public Casa lerCasa() {
        System.out.println("=== Cadastro de CASA ===");
        double valor     = lerDouble("Informe o valor do Imóvel: ", v -> v > 0, "Valor deve ser maior que zero!");
        int    prazo     = lerInt   ("Informe o prazo de Financiamento (anos): ", p -> p > 0, "Prazo deve ser maior que zero!");
        double juros     = lerDouble("Informe a taxa de juros anual (%): ", j -> j >= 0 && j <= 80, "Taxa inválida!");
        double area      = lerDouble("Informe quantos m² de área construída: ", a -> a > 0, "Área deve ser maior que zero!");
        double tamanho   = lerDouble("Informe o tamanho do terreno (m²): ",
                t -> t >= area, "Terreno não pode ser menor que a área construída!");
        double acrescimo = lerDouble("Informe acréscimo: ", ac -> ac >= 0, "Acréscimo inválido!");

        return new Casa(valor, juros, prazo, area, tamanho, acrescimo);
    }

    public Apartamento lerApartamento() {
        System.out.println("=== Cadastro de APARTAMENTO ===");
        double valor = lerDouble("Informe o valor do Imóvel: ", v -> v > 0, "Valor deve ser maior que zero!");
        int    prazo = lerInt   ("Informe o prazo de Financiamento (anos): ", p -> p > 0, "Prazo deve ser maior que zero!");
        double juros = lerDouble("Informe a taxa de juros anual (%): ", j -> j >= 0 && j <= 80, "Taxa inválida!");
        int    andar = lerInt   ("Informe o número do andar: ", n -> n > 0, "Andar inválido!");
        int    vagas = lerInt   ("Informe o número de vagas: ", n -> n > 0, "Número de vagas inválido!");

        return new Apartamento(valor, juros, prazo, vagas, andar);
    }

    public Terreno lerTerreno() {
        System.out.println("=== Cadastro de TERRENO ===");
        double valor = lerDouble("Informe o valor do Imóvel: ", v -> v > 0, "Valor deve ser maior que zero!");
        int    prazo = lerInt   ("Informe o prazo de Financiamento (anos): ", p -> p > 0, "Prazo deve ser maior que zero!");
        double juros = lerDouble("Informe a taxa de juros anual (%): ", j -> j >= 0 && j <= 80, "Taxa inválida!");
        TiposTerrenos tipoZona = lerTipoTerreno();

        return new Terreno(valor, juros, prazo, tipoZona);
    }

    public TiposTerrenos lerTipoTerreno() {
        while (true) {
            System.out.print("Informe o tipo de Zona (RESIDENCIAL/COMERCIAL/RURAL): ");
            String linha = sc.nextLine().trim().toUpperCase();
            if (linha.isEmpty()) continue;
            try {
                return TiposTerrenos.valueOf(linha);
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de Zona inválida!");
            }
        }
    }


    private double lerDouble(String prompt, java.util.function.DoublePredicate validacao, String msgErro) {
        while (true) {
            System.out.print(prompt);
            String linha = sc.nextLine().trim();
            if (linha.isEmpty()) continue;
            try {
                double v = Double.parseDouble(linha);
                if (!validacao.test(v)) {
                    System.out.println(msgErro);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Valor deve ser apenas números!");
            }
        }
    }

    private int lerInt(String prompt, java.util.function.IntPredicate validacao, String msgErro) {
        while (true) {
            System.out.print(prompt);
            String linha = sc.nextLine().trim();
            if (linha.isEmpty()) continue;
            try {
                int v = Integer.parseInt(linha);
                if (!validacao.test(v)) {
                    System.out.println(msgErro);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Valor deve ser apenas números!");
            }
        }
    }
}
