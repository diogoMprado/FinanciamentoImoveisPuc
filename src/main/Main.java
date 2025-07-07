package main;

import modelo.Casa;
import modelo.Financiamento;
import util.AumentoMaiorDoQueJurosException;
import util.LeituraGravacaoArquivoTexto;
import util.InterfaceUsuario;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Path ARQ_TEXTO = Paths.get("Financiamentos.txt");
    private static final Path ARQ_SER = Paths.get("financiamentos.ser");

    public static void main(String[] args) {
        InterfaceUsuario iu = new InterfaceUsuario();
        List<Financiamento> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean continuarCadastro = true;
        while (continuarCadastro) {
            boolean cadastroValido = false;

            // LOOP DE CADASTRO
            while (!cadastroValido) {
                try {
                    switch (iu.tipoFinanciamento()) {
                        case CASA:
                            Casa casa = iu.lerCasa();
                            // loop para tratar Exceção
                            while (true) {
                                try {
                                    casa.calcularPagamentoMensal();
                                    break;  // sem exceção, sai do loop
                                } catch (AumentoMaiorDoQueJurosException e) {
                                    System.out.println(e.getMessage());
                                    casa.setAcrescimo(e.getValorCorrigido());
                                }
                            }
                            lista.add(casa);
                            cadastroValido = true;
                            break;

                        case APARTAMENTO:
                            lista.add(iu.lerApartamento());
                            cadastroValido = true;
                            break;

                        case TERRENO:
                            lista.add(iu.lerTerreno());
                            cadastroValido = true;
                            break;
                    }

                } catch (InputMismatchException ime) {
                    System.out.println("Entrada inválida — tente novamente.");
                    sc.nextLine(); // limpa buffer
                }
            }
            // PERGUNTA SE QUER CONTINUAR
            System.out.print("Deseja cadastrar outro financiamento? (S/N): ");
            String resp = sc.next().trim().toUpperCase();
            continuarCadastro = resp.equals("S");
        }

        // GRAVAÇÃO E LEITURA DE ARQUIVO
        try {
            // TEXTO
            LeituraGravacaoArquivoTexto.salvarComoTexto(lista, ARQ_TEXTO);
            System.out.println("Texto gravado em " + ARQ_TEXTO);

            List<String> linhas = LeituraGravacaoArquivoTexto.lerTexto(ARQ_TEXTO);
            System.out.println("Conteúdo de " + ARQ_TEXTO + ":");
            linhas.forEach(System.out::println);

            // SERIALIZAÇÃO
            LeituraGravacaoArquivoTexto.serializar(lista, ARQ_SER);
            System.out.println("Lista serializada em " + ARQ_SER);

            List<Financiamento> desser = LeituraGravacaoArquivoTexto.desserializar(ARQ_SER);
            System.out.println("Desserializados:");
            desser.forEach(f -> {
                System.out.println(f);
                System.out.println("---");
            });

        } catch (Exception e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        }
    }
}
