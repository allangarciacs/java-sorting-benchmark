package projeto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import projeto.controller.Ordenacao.Complexidade;
import projeto.model.Utilidades;
import projeto.view.Exibicao;

public class Controller {
    
    public void executarProcessamento() {

        Scanner teclado = new Scanner(System.in); 

        // Variáveis para armazenar o tempo de execução de cada algoritmo de ordenação
        long tempoInicioBolha, tempoFimBolha;
        long tempoInicioInsert, tempoFimInsert;
        long tempoInicioSelect, tempoFimSelect;
        long tempoIncioAgitacao, tempoFimAgitacao;
        long tempoInicioJava, tempoFimJava;
        long tempoInicioPente, tempoFimPente;

        // Pede o tamanho, intervalo da lista e pre-ordenacao
        Exibicao.pedirTamanhoLista();
        int tamanhoLista = teclado.nextInt();

        Exibicao.pedirValorMinLista();
        int valorMin = teclado.nextInt();

        Exibicao.pedirValorMaxLista();
        int valorMax = teclado.nextInt();

        Exibicao.pedirPreOrdenacao();
        boolean preOrdenacao = teclado.nextBoolean();

        // Cria e preenche a lista original com valores aleatórios
        List<Integer> listaOriginal = new ArrayList<>();
        Utilidades.popularLista(listaOriginal, tamanhoLista, valorMin, valorMax, preOrdenacao);

        // Cria uma cópia da lista original para cada algoritmo de ordenação
        // Assim, cada algoritmo recebe exatamente a mesma lista
        List<Integer> listaBolha = new ArrayList<>(listaOriginal);
        List<Integer> listaInsercao = new ArrayList<>(listaOriginal);
        List<Integer> listaSelecao = new ArrayList<>(listaOriginal);
        List<Integer> listaAgitacao = new ArrayList<>(listaOriginal);
        List<Integer> listaJava = new ArrayList<>(listaOriginal);
        List<Integer> listaPente = new ArrayList<>(listaOriginal);

        // BOLHA
        // Inicia a contagem do tempo de execução
        tempoInicioBolha = System.nanoTime(); 

        // Executa o Bubble Sort e armazena sua complexidade
        Complexidade complexidadeBolha = Ordenacao.bolha(listaBolha);

        // Finaliza a contagem do tempo de execução
        tempoFimBolha = System.nanoTime();   

        // Exibe a complexidade (qtde de trocas e comparações)
        Exibicao.exibirComplexidade(
            "BUBBLE SORT", 
            complexidadeBolha.getComparacoes(), 
            complexidadeBolha.getTrocas()
        );

        // Exibe o tempo de execução
        Exibicao.exibirTempoExecucao((tempoFimBolha - tempoInicioBolha) / 1000000);

        // INSERT
        tempoInicioInsert = System.nanoTime();
        Complexidade complexidadeInsert = Ordenacao.insercao(listaInsercao);
        tempoFimInsert = System.nanoTime();

        Exibicao.exibirComplexidade(
            "INSERTION SORT", 
            complexidadeInsert.getComparacoes(), 
            complexidadeInsert.getTrocas()
        );         

        Exibicao.exibirTempoExecucao((tempoFimInsert - tempoInicioInsert) / 1000000);

        // SELECT
        tempoInicioSelect = System.nanoTime();
        Complexidade complexidadeSelect = Ordenacao.selecao(listaSelecao);
        tempoFimSelect = System.nanoTime();

        Exibicao.exibirComplexidade(
            "SELECTION SORT", 
            complexidadeSelect.getComparacoes(), 
            complexidadeSelect.getTrocas()
        );      

        Exibicao.exibirTempoExecucao((tempoFimSelect - tempoInicioSelect) / 1000000);

        // SHAKE
        tempoIncioAgitacao = System.nanoTime();
        Complexidade complexidadeShake = Ordenacao.agitacao(listaAgitacao);
        tempoFimAgitacao = System.nanoTime();

        Exibicao.exibirComplexidade(
            "SHAKE SORT", 
            complexidadeShake.getComparacoes(), 
            complexidadeShake.getTrocas()
        );

        Exibicao.exibirTempoExecucao((tempoFimAgitacao - tempoIncioAgitacao) / 1000000);

        // PENTE
        tempoInicioPente = System.nanoTime();
        Complexidade complexidadePente = Ordenacao.pente(listaPente);
        tempoFimPente = System.nanoTime();

        Exibicao.exibirComplexidade(
            "COMB SORT", 
            complexidadePente.getComparacoes(), 
            complexidadePente.getTrocas()
        );

        Exibicao.exibirTempoExecucao((tempoFimPente - tempoInicioPente) / 1000000);

        // PADRÃO DO JAVA (TIM SORT)
        tempoInicioJava = System.nanoTime();
        Collections.sort(listaJava);
        tempoFimJava = System.nanoTime();

        Exibicao.exibirAlgoritmo("TIM SORT");
        Exibicao.exibirTempoExecucao((tempoFimJava - tempoInicioJava) / 1000000); 

        // Armazena a opção do user 
        int opcao;

        do {
            Exibicao.menuExibirLista();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    Exibicao.exibirLista(listaOriginal, null);
                    break;

                case 2:
                    Exibicao.exibirLista(listaBolha, null);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;
            
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        } while (opcao != 0);

        teclado.close();
    }
}