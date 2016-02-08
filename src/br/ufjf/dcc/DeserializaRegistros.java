package br.ufjf.dcc;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeserializaRegistros {

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ObjectInputStream entrada = new ObjectInputStream(
                    Files.newInputStream(
                            Paths.get("lancamentos.ser")
                    )
            );

            try {
                while (true) {
                    Lancamento lancamento = (Lancamento) entrada.readObject();
                    System.out.printf("%s\t%s\t%.2f\n", lancamento.getDescricao(), sdf.format(lancamento.getData()), lancamento.getValor());
                }
            } catch (EOFException | ClassNotFoundException e) {
            }
            entrada.close();
        } catch (IOException ex) {
            Logger.getLogger(DeserializaRegistros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
