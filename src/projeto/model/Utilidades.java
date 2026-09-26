package projeto.model;

import java.util.List;
import java.util.Random;

public class Utilidades {

        // Preenche a lista com a quantidade de números definida e o intervalo de valores informado
        public static void popularLista(
            List<Integer> lista, 
            long quantidadeNumeros, 
            int inicio, int fim, 
            boolean aleatorio) {

        Random gerador = new Random();
        
        // Verifica se a lista deve ser preenchida com número aleatórios
        if (aleatorio) {

            // Se sim, adiociona números aleatórios dentro do intervalo definido
            for (long i = 0; i < quantidadeNumeros; i++) {
                lista.add(gerador.nextInt(inicio, fim));
            }
        } else {

            // Se não, cria uma lista sequencial
            for (long i = 0; i < quantidadeNumeros; i++) {
                lista.add((int) (inicio + i));
            }
        }
    }
}
