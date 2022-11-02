
public class heapSort {

    public static void main(String[] args) {
        int[] arr = { 55, 10, 33, 22, 62, 30, 14, 80, 77, 35 };

        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] vetor) {

        // Cria o heap maximo a partir do vetor desordenado (heapify)
        for (int i = vetor.length / 2 - 1; i >= 0; i--) {
            heapify(vetor, vetor.length, i);
        }

        // Ordena o vetor (heap sort)
        for (int i = vetor.length - 1; i >= 0; i--) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            heapify(vetor, i, 0);
        }
    }

    public static void heapify(int[] vetor, int tamanhoVetor, int i) {
        int raiz = i;
        int filho1 = 2 * i + 1;
        int filho2 = 2 * i + 2;

        // Se o filho da esquerda for maior que a raiz
        if (filho1 < tamanhoVetor && vetor[filho1] > vetor[raiz]) {
            raiz = filho1;
        }

        // Se o filho da direita for maior que a raiz
        if (filho2 < tamanhoVetor && vetor[filho2] > vetor[raiz]) {
            raiz = filho2;
        }

        // Se a raiz não for a maior então troca com o maior filho e chama a função
        // novamente para o filho que foi trocado
        if (raiz != i) {
            int temp = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz] = temp;
            heapify(vetor, tamanhoVetor, raiz);
        }
    }
}