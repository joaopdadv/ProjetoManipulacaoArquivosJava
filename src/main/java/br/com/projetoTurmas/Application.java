package br.com.projetoTurmas;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Path pathJava = Paths.get("./files/turmaJava.txt");
        Path pathBancoDeDados = Paths.get("./files/turmaBancoDeDados.txt");
        Path outputPath = Paths.get("./files/turmas-saida.txt");

        try{
            List<String> listaAlunosJava = Files.readAllLines(pathJava);
            //Turma java = Turma.builder().nome("Java").alunos(listaAlunosJava).build();

            List<String> listaAlunosBanco = Files.readAllLines(pathBancoDeDados);
            //Turma banco = Turma.builder().nome("Banco").alunos(listaAlunosBanco).build();

            Set<String> listaChamada = new HashSet();

            listaAlunosJava.forEach(item -> {
                listaChamada.add(item);
            });

            listaAlunosBanco.forEach(item -> {
                listaChamada.add(item);
            });

            BufferedWriter writer = Files.newBufferedWriter(outputPath, Charset.forName("UTF-8"));

            writer.append("Alunos Java: \n");
            writer.append("\n");
            listaAlunosJava.forEach(linha -> {
                try {
                    writer.append(linha + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.append("\n");
            writer.append("Alunos Banco De Dados: \n");
            writer.append("\n");
            listaAlunosBanco.forEach(linha -> {
                try {
                    writer.append(linha + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.append("\n");
            writer.append("Todos Alunos: \n");
            writer.append("\n");
            listaChamada.forEach(linha -> {
                try {
                    writer.append(linha + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*private static Set<String> lerArquivos(String path){
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String linha = reader.readLine();
            while (linha != null){
                System.out.println(linha);
                linha = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void escreverArquivo(String outputPath, Set<String> lista){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))){
            lista.forEach(item -> {
                try {
                    writer.append(item);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
