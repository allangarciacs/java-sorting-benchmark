package projeto.view;

import java.util.List;

public class Exibicao {

    public static void pedirTamanhoLista() {
        System.out.println("===================================");
        System.out.print("Digite o tamanho da lista: ");
    }

    public static void pedirValorMinLista() {
        System.out.println("===================================");
        System.out.print("Digite o valor mínimo da lista: ");
    }

    public static void pedirValorMaxLista() {
        System.out.println("===================================");
        System.out.print("Digite o valor máximo da lista: ");
    }

    public static void pedirPreOrdenacao() {
        System.out.println("===================================");
        System.out.print("Ordem aleatória? (true / false): ");
    }

    public static void exibirComplexidade(String algoritmo, int comparacoes, int trocas) {
        System.out.println("===================================");
        System.out.println("Complexidade " + algoritmo);
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas     : " + trocas);
    }

    public static void exibirTempoExecucao(long tempoMs) {
        System.out.println("Tempo (ms) : " + tempoMs);
    }

    public static void exibirAlgoritmo(String algoritmo) {
        System.out.println("===================================");
        System.out.println("Algortimo  : " + algoritmo);
    }

    public static void menuExibirLista() {
        System.out.println("===================================");
        System.out.println("  1  | Ver lista original");
        System.out.println("  2  | Ver lista ordenada");
        System.out.println("  0  | Sair ");
        System.out.println("===================================");
        System.out.print("OPCAO: ");
    }

    public static void exibirLista(List<Integer> lista, String frase) {
        System.out.println(frase);
        for (Object item : lista) {
            System.out.println(item);
        }
        System.out.println("===================================");
        System.out.println("Total de registros: " + lista.size());
    }
}
