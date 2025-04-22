import java.util.Random;

public class Vetor {

    public static int[] gerarAleatorio(int tamanho) {
        Random rand = new Random();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rand.nextInt(1_000_000);
        }
        return vetor;
    }

    public static int[] gerarInverso(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i;
        }
        return vetor;
    }

    public static int[] copiar(int[] original) {
        return java.util.Arrays.copyOf(original, original.length);
    }
}
