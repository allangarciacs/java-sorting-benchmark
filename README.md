# Benchmark de Algoritmos de Ordenação em Java

Projeto desenvolvido na disciplina de Pesquisa e Ordenação.

O objetivo é implementar e comparar diferentes algoritmos de ordenação
utilizando Java.

## Algoritmos

- Bubble Sort
- Insertion Sort
- Selection Sort
- Shake Sort
- Comb Sort
- Collections.sort()

## Métricas analisadas

- Tempo de execução
- Número de comparações
- Número de trocas

## Estrutura do projeto

O projeto utiliza uma organização baseada no padrão MVC:

- `controller` - controle do fluxo do programa e algoritmos de ordenação
- `model` - funções auxiliares para geração das listas
- `view` - exibição das informações no terminal

## Parâmetros de entrada

O usuário pode definir:

- Tamanho da lista
- Valor mínimo
- Valor máximo
- Se a lista será previamente ordenada

## Resultados

Os testes realizados demonstraram que o desempenho dos algoritmos de ordenação varia significativamente de acordo com o tamanho e a condição inicial da lista. Foram utilizados conjuntos de **5.000 e 50.000 elementos**, com valores entre **1 e 5.000** ou **1 e 50.000**, considerando listas **aleatórias** e **já ordenadas**.

Nas listas aleatórias, foi possível observar um aumento considerável no tempo de execução conforme o tamanho da entrada aumentou. Com **50.000 elementos**, os algoritmos Bubble Sort e Shake Sort apresentaram tempos superiores a 9 segundos, enquanto o Insertion Sort ultrapassou 4 segundos e o Selection Sort apresentou aproximadamente 1,8 segundo. O Comb Sort e o Tim Sort apresentaram tempos significativamente menores, com aproximadamente **30 ms e 16 ms**, respectivamente.

Nas listas previamente ordenadas, os resultados foram diferentes. Bubble Sort, Insertion Sort e Shake Sort apresentaram tempos muito menores, devido à menor quantidade de operações necessárias nessa condição. O Selection Sort, por outro lado, continuou realizando uma grande quantidade de comparações, mesmo com a lista já ordenada, demonstrando que sua execução é menos influenciada pela condição inicial dos dados.

De forma geral, os testes mostram que **o desempenho de um algoritmo não depende apenas do tamanho da lista, mas também da organização dos dados de entrada**. Algoritmos como Bubble Sort, Insertion Sort e Shake Sort podem apresentar um comportamento muito diferente quando recebem uma lista já ordenada, enquanto Comb Sort e o método de ordenação utilizado pelo Java apresentaram tempos menores nos testes realizados, principalmente com listas aleatórias e maiores.

## Melhorias futuras

Como possíveis melhorias para o projeto, pretende-se adicionar novos cenários de teste e funcionalidades, como:

* Geração de listas inversamente ordenadas
* Geração de listas parcialmente ordenadas
* Testes com diferentes quantidades de elementos repetidos
* Execução automática de múltiplos testes para obter médias dos resultados
* Geração de gráficos para facilitar a comparação entre os algoritmos
