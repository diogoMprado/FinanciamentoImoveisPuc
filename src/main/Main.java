package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Financiamento> financiamentos = new ArrayList<>();
        do{
            InterfaceUsuario usuario = new InterfaceUsuario();
            String tipo = String.valueOf(usuario.tipoFinanciamento());
            double valorImovel = usuario.valorImovel();
            int prazoFinanciamento = usuario.prazoFinanciamento();
            double taxaJurosAnual = usuario.taxaJurosAnual();


            switch (tipo) {
                case "CASA" -> {
                    double areaCasa = usuario.areaConstruida();
                    Casa casa = new Casa(valorImovel, taxaJurosAnual, prazoFinanciamento, areaCasa, usuario.tamanhoDoTerreno(areaCasa), usuario.acrescimo());
                    financiamentos.add(casa);
                }
                case "APARTAMENTO" -> {
                    Apartamento apartamento = new Apartamento(valorImovel, taxaJurosAnual, prazoFinanciamento, usuario.numeroDeVagas(), usuario.numeroDoAndar());
                    financiamentos.add(apartamento);
                }
                case "TERRENO" -> {
                    Terreno terreno = new Terreno(valorImovel, taxaJurosAnual, prazoFinanciamento, usuario.lerTipoTerreno());
                    financiamentos.add(terreno);
                }
            }
        }
        while (financiamentos.size() < 3);
        FileWriter fw = null;

        try{
            fw = new FileWriter("Financiamentos.txt");
            fw.write("LISTA DE FINANCIAMENTOS:\n\n");
            int contador = 0;
            while(contador < financiamentos.size()){
                fw.write(financiamentos.get(contador).toString() + "\n\n");
                contador++;
            }
            fw.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Financiamentos cadastrados com sucesso!");
    }
}