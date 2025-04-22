public class Main {

    static final int TAMANHO =50000; // você pode ajustar esse valor
    static final int REPETICOES = 10;

    public static void main(String[] args) {
        testarTodos("BubbleSort", BubbleSort::bubbleSort);
        testarTodos("InsertionSort", InsertionSort::insertionSort);
        testarTodos("SelectionSort", SelectionSort::selectionSort);
        testarTodos("QuickSort", QuickSort::quickSort);
        testarTodos("MergeSort", MergeSort::mergeSort);
        testarTodos("HeapSort", HeapSort::heapSort);
    }

    public static void testarTodos(String nome, java.util.function.Consumer<int[]> algoritmo) {
        System.out.println("\n" + nome);

        // Teste com vetor aleatório
        System.out.println("\nTeste com vetor ALEATÓRIO:");
        executarTeste(algoritmo, () -> Vetor.gerarAleatorio(TAMANHO));

        // Teste com vetor em ordem inversa
        System.out.println("\nTeste com vetor em ORDEM INVERSA:");
        executarTeste(algoritmo, () -> Vetor.gerarInverso(TAMANHO));
    }

    public static void executarTeste(java.util.function.Consumer<int[]> algoritmo, java.util.function.Supplier<int[]> gerador) {
        long[] tempos = new long[REPETICOES];

        for (int i = 0; i < REPETICOES; i++) {
            int[] vetor = gerador.get();
            int[] copia = Vetor.copiar(vetor);
            long tempo = SortTimer.medirTempo(() -> algoritmo.accept(copia));
            tempos[i] = tempo;
            System.out.printf("Execução %d: %.2f ms\n", i + 1, tempo / 1_000_000.0);
        }

        double media = SortTimer.calcularMedia(tempos) / 1_000_000.0;
        double desvio = SortTimer.calcularDesvioPadrao(tempos, media * 1_000_000) / 1_000_000.0;

        System.out.printf("Tempo médio: %.4f ms\n", media);
        System.out.printf("Desvio padrão: %.4f ms\n", desvio);
    }}
