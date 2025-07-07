package util;

import modelo.Financiamento;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LeituraGravacaoArquivoTexto {

    // Salva lista em arquivo de texto
    public static void salvarComoTexto(List<Financiamento> lista, Path arquivo)
            throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(arquivo)) {
            bw.write("LISTA DE FINANCIAMENTOS:\n\n");
            for (Financiamento f : lista) {
                bw.write(f.toString());
                bw.write("\n---\n");
            }
        }
    }

    // Lê o conteúdo de um texto e retorna como linhas
    public static List<String> lerTexto(Path arquivo) throws IOException {
        return Files.readAllLines(arquivo);
    }

    // Serializa a lista inteira em arquivo .ser
    public static void serializar(List<Financiamento> lista, Path arquivo)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(arquivo))) {
            oos.writeObject(lista);
        }
    }

    // Desserializa e retorna a lista salva
    @SuppressWarnings("unchecked")
    public static List<Financiamento> desserializar(Path arquivo)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(arquivo))) {
            return (List<Financiamento>) ois.readObject();
        }
    }
}
