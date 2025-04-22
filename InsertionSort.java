public class InsertionSort {

    public static void insertionSort(int[] v) {
        int n = v.length;
        for (int i = 1; i < n; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
    }
}
