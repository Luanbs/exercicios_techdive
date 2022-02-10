package Exercicio6;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex6 {
        public static void main(String[] args){
            double bytes = 0;
            String caminho = "C:\\Users\\luank\\Desktop\\TechDive\\exercicios_techdive\\Modulo1\\Semana10\\src\\Exercicio6\\teste.txt";
            Path path = Paths.get(caminho);

            try {
                bytes = Files.size(path);
            }catch (IOException e){
                System.out.println("Arquivo não encontrado.");
            }

            System.out.printf("Tamanho em bytes: %.2f", bytes);
            System.out.printf("%nTamanho em Kbytes: %.2f", bytes/1024);
            System.out.printf("%nTamanho em Mbytes: %.2f", bytes/1024/1024);


        }
    }

