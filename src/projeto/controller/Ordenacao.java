package projeto.controller;

import java.util.List;

public class Ordenacao {

    // Classe responsável por armazenar a quantidade de comparações e trocas
    // realizadas por um algoritmo de ordenação

    public static class Complexidade {
        private int comparacoes;
        private int trocas;

        public Complexidade(int comparacoes, int trocas) {
            this.comparacoes = comparacoes;
            this.trocas = trocas;
        }

        public int getComparacoes() {
            return comparacoes;
        }

        public int getTrocas() {
            return trocas;
        }
    }

    // Ordena a lista utilizando o algoritmo Bubble Sort
    public static Complexidade bolha(List<Integer> lista) {
        boolean houveTroca;
        int tmp;
        int qtdComparacoes = 0, qtdTrocas = 0;

        // Continua executando enquanto houve elementos trocados
        do {
            houveTroca = false;

            // Percorre a lista comparando elementos vizinhos
            for (int i = 0; i < lista.size()-1; i++){
                qtdComparacoes++;

                // Trocas os elementos caso estejam na ordem errada
                if (lista.get(i) > lista.get(i+1)) {
                    qtdTrocas++;
                    houveTroca = true;

                    tmp = lista.get(i);
                    lista.set(i, lista.get(i+1));
                    lista.set(i+1, tmp);
                }
            }
        } while (houveTroca);

        // Retorna a qtde de comparações e trocas realizadas
        return new Complexidade(qtdComparacoes, qtdTrocas);
    }

    // Ordena a lista utilizando o algoritmo Selection Sort
    public static Complexidade selecao(List<Integer> lista) {
        int posMenor, tmp;
        int qtdComparacoes = 0, qtdTrocas = 0;

        // Percorre a lista procurando o menor elemento
        for (int i = 0; i < lista.size()-1; i++) {
            posMenor = i;

            // Procura o menor elemento na parte não ordenada da lista
            for (int j = i+1; j < lista.size(); j++) {
                qtdComparacoes++;

                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }

            // Colocar o menor elemento na posição correta
            if (i != posMenor) {
                qtdTrocas++;

                tmp = lista.get(i);
                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, tmp);
            }
        }
        return new Complexidade(qtdComparacoes, qtdTrocas);
    }

    // Ordena a lista utilizando o algoritmo Insertion Sort
    public static Complexidade insercao(List<Integer> lista) {
        int i, j;
        int tmp;
        int qtdComparacoes = 0, qtdTrocas = 0;

        // Percorre a lista a partir do segundo elemento
        for (i = 1; i < lista.size(); i++) {
            tmp = lista.get(i);

            // Compara o elemento atual com os elementos anteriores
            for (j = i - 1; j >= 0; j--) {
                qtdComparacoes++;

                // Move o elemento para a direita caso seja maior
                if (tmp < lista.get(j)) {
                    lista.set(j + 1, lista.get(j));
                    qtdTrocas++;
                } else break;
            }

            // Insere na posição certa
            lista.set(j + 1, tmp);
            qtdTrocas++;
        }
        return new Complexidade(qtdComparacoes, qtdTrocas);
    }

    // Ordena a lista utilizand o algoritmo Shake Sort
    public static Complexidade agitacao(List<Integer> lista) {
        boolean houveTroca;
        int tmp;
        int ini = 0;
        int fim = lista.size();
        int qtdComparacoes = 0, qtdTrocas = 0;

        // Continua enquanto houver trocas durante os percursos
        do {
            houveTroca = false;

            // Percorre a lista da esquerda para a direita
            for (int i = ini; i < fim-1; i++){
                qtdComparacoes++;

                // Troca elementos q estão fora da ordem
                if (lista.get(i) > lista.get(i+1)) {
                    qtdTrocas++;
                    houveTroca = true;

                    tmp = lista.get(i);
                    lista.set(i, lista.get(i+1));
                    lista.set(i+1, tmp);
                }
            }

            // Se não tiver troca, a lista ja está ordenada
            if (!houveTroca) {
                break;
            }

            // Diminui o limite final após o maior elemento chegar no final
            fim--;

            houveTroca = false;

            // Percorre a lista da direita para a esquerda
            for (int i = fim; i > ini+1; i--){
                qtdComparacoes++;

                if (lista.get(i) < lista.get(i-1)) {
                    qtdTrocas++;
                    houveTroca = true;

                    tmp = lista.get(i);
                    lista.set(i, lista.get(i-1));
                    lista.set(i-1, tmp);
                }
            }

            // Aumenta o limite inicial após o menor elemento chegar no início
            ini++;

        } while (houveTroca);
        return new Complexidade(qtdComparacoes, qtdTrocas);
    }

    // Ordena a lista utilizando o algoritmo Comb Sort 
    public static Complexidade pente(List<Integer> lista) {
        boolean houveTroca;
        int tmp;
        int distancia = lista.size();
        int qtdComparacoes = 0, qtdTrocas = 0;

        // Continua enquanto houver trocas ou a distância for maior que 1
        do {
            // Diminui a distância entre os elementos que serão comparados
            distancia = (int)(distancia / 1.3);

            // Garante que a distância mínima seja 1
            if (distancia < 1) {
                distancia = 1;
            }

            houveTroca = false;

            // Compara elementos separados pela distância calculada
            for (int i = 0; i+distancia < lista.size(); i++) {
                qtdComparacoes++;

                // Troca os elementos caso estejam na ordem incorreta 
                if (lista.get(i) > lista.get(i+distancia)) {
                    qtdTrocas++;
                    houveTroca = true;
                    
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i+distancia));
                    lista.set(i+distancia, tmp);
                }
            }
        } while (houveTroca || distancia > 1); 
        return new Complexidade(qtdComparacoes, qtdTrocas);
    }
}