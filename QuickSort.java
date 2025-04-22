public class QuickSort {

    public static void quickSort(int[] vetor) {
        quickSortRecursivo(vetor, 0, vetor.length - 1);
    }

    private static void quickSortRecursivo(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(vetor, inicio, fim);
            quickSortRecursivo(vetor, inicio, pivo - 1);
            quickSortRecursivo(vetor, pivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int indicePivo = inicio + (int)(Math.random() * (fim - inicio + 1));
        trocar(vetor, indicePivo, fim); // coloca o pivô no final
        int pivo = vetor[fim];

        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i + 1, fim);
        return i + 1;
    }

    private static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
