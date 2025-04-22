public class MergeSort {
    public static void mergeSort(int[] v) {
        if (v.length > 1) {
            int meio = v.length / 2;

            int[] esquerda = new int[meio];
            int[] direita = new int[v.length - meio];

            System.arraycopy(v, 0, esquerda, 0, meio);
            System.arraycopy(v, meio, direita, 0, v.length - meio);

            mergeSort(esquerda);
            mergeSort(direita);
            intercalar(v, esquerda, direita);
        }
    }

    private static void intercalar(int[] v, int[] esquerda, int[] direita) {
        int i = 0, j = 0, k = 0;
        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                v[k++] = esquerda[i++];
            } else {
                v[k++] = direita[j++];
            }
        }
        while (i < esquerda.length) {
            v[k++] = esquerda[i++];
        }
        while (j < direita.length) {
            v[k++] = direita[j++];
        }
    }
}