package br.ufjf.dcc;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SerializaRegistros {

    public static void main(String[] args) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ObjectOutputStream saida = new ObjectOutputStream(
                Files.newOutputStream(
                        Paths.get("lancamentos.ser")
                )
        );
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a descrição do lançamento:\n (XXXX dd/mm/yyyy NNN,NN)\n");
        while(true) {
            try {
                Lancamento lancamento = new Lancamento();
                lancamento.setDescricao(entrada.next());
                lancamento.setData(sdf.parse(entrada.next()));
                lancamento.setValor(entrada.nextDouble());
                saida.writeObject(lancamento);
                System.out.println("Novo registro? (S/n)");
                if(entrada.next().equalsIgnoreCase("n")) break;
                System.out.println("Digite a descrição do lançamento:\n (XXXX dd/mm/yyyy NNN,NN)\n");
                
            } catch (ParseException e) {
                System.err.println("Data inválida!");
            } catch (NoSuchElementException e) {
                System.err.println("Entrada inválida");
                entrada.nextLine();
            }catch(IOException e){
                System.err.println("Erro ao escrever o arquivo");
            }
        }
        saida.close();
    }

}
