public class SelectionSort {
    public static void selectionSort(int[] v) {
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j] < v[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = v[i];
            v[i] = v[minIndex];
            v[minIndex] = temp;
        }
    }
}