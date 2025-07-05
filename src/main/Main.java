package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Financiamento> financiamentos = new ArrayList<>();
        do{
            InterfaceUsuario usuario = new InterfaceUsuario();
            String tipo = usuario.Categorias();
            double valorImovel = usuario.valorImovel();
            int prazoFinanciamento = usuario.prazoFinanciamento();
            double taxaJurosAnual = usuario.taxaJurosAnual();


            if(tipo.equals("Casa")){
                Casa casa = new Casa(valorImovel,taxaJurosAnual,prazoFinanciamento);
                financiamentos.add(casa);
                System.out.println(casa.toString());

            }
            else if(tipo.equals("Apartamento")){
                Apartamento apartamento = new Apartamento(valorImovel,taxaJurosAnual,prazoFinanciamento);
                financiamentos.add(apartamento);
                System.out.println(apartamento.toString());
            }
            else if (tipo.equals("Terreno")){
                Terreno terreno = new Terreno(valorImovel,taxaJurosAnual,prazoFinanciamento);
                financiamentos.add(terreno);
                System.out.println(terreno.toString());
            }
        }
        while (financiamentos.size() < 3);

    }




}