
public class heapSort {

    public static void main(String[] args) {
        int[] arr = { 55, 10, 33, 22, 11, 25 };

        heapSortAlgorithm(arr);

        // heapSortAlgorithmInterative(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSortAlgorithm(int vetor[]) {
        int n = vetor.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(vetor, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            heap(vetor, i, 0);
        }
    }

    private static void heap(int vetor[], int n, int i) {
        int largest = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        if (esquerda < n && vetor[esquerda] > vetor[largest])
            largest = esquerda;
        if (direita < n && vetor[direita] > vetor[largest])
            largest = direita;
        if (largest != i) {
            int swap = vetor[i];
            vetor[i] = vetor[largest];
            vetor[largest] = swap;
            heap(vetor, n, largest);
        }
    }

    public static void heapSortAlgorithmInterative(int vetor[], int n) {
        int i = n / 2;
        int pai, filho, t;
        while (true) {
            if (i > 0) {
                i--;
                t = vetor[i];
            } else {
                n--;
                if (n == 0)
                    return;
                t = vetor[n];
                vetor[n] = vetor[0];
            }
            pai = i;
            filho = i * 2 + 1;
            while (filho < n) {
                if ((filho + 1 < n) && (vetor[filho + 1] > vetor[filho]))
                    filho++;
                if (vetor[filho] > t) {
                    vetor[pai] = vetor[filho];
                    pai = filho;
                    filho = pai * 2 + 1;
                } else {
                    break;
                }
            }
            vetor[pai] = t;
        }

    }
}