package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {


    public static void main(String[] args) {

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        Double valorImovel = interfaceUsuario.valorImovel();
        int prazoFinanciamento = interfaceUsuario.prazoFinanciamento();
        Double taxaJurosAnual = interfaceUsuario.taxaJurosAnual();

        Financiamento financiamento = new Financiamento(valorImovel,taxaJurosAnual,prazoFinanciamento);

        System.out.println(financiamento.toString());





    }
}