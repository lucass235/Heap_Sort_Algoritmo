
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
        int n = vetor.length;                                 // 1
        for (int i = n / 2 - 1; i >= 0; i--) {               // n
            heap(vetor, n, i);                              //T(n) -1
        }                               
        int temp;                                         // 1
        for (int i = n - 1; i >= 0; i--) {               // n
            temp = vetor[0];                            // n -1
            vetor[0] = vetor[i];                       // (3n) -1
            vetor[i] = temp;                          // (2n) -1
            heap(vetor, i, 0);                    // T(n) -1
        }
    }

    private static void heap(int vetor[], int n, int i) {
        int largest = i;                                             // 1                                  
        int esquerda = 2 * i + 1;                                   // 1
        int direita = 2 * i + 2;                                   // 1
        if (esquerda < n && vetor[esquerda] > vetor[largest])     // 1
            largest = esquerda;                                  // 1
        if (direita < n && vetor[direita] > vetor[largest])     // 1
            largest = direita;                                 // 1
        if (largest != i) {                                   // 1
            int swap = vetor[i];                             // 1
            vetor[i] = vetor[largest];                      // 1
            vetor[largest] = swap;                         // 1
            heap(vetor, n, largest);                      // T(n)
        }
    }
    // função de recorrência 
    // T(n) = 13 + 2n + (n - 1) + (3n - 1) + (2n - 1) + (n - 1) + 2(T(n) - 1) + T(n)
    // T(n) = 13 + 2n + (4n - 2) + (3n - 2) + 3T(n) - 2
    // T(n) = 11 + 9n + 3T(n) - 6
    // T(n) = 3T(n) + 9n + 5

    public static void heapSortAlgorithmInterative(int vetor[], int n) {
        int i = n / 2;
        int pai, filho, t;
        for ( i = n /2; i > 0; i--) {
            pai = i;
            filho = 2 * i;
            t = vetor[pai];
            while (filho <= n) {
                if (filho < n && vetor[filho] < vetor[filho + 1]) {
                    filho++;
                }
                if (t > vetor[filho]) {
                    break;
                } else {
                    vetor[pai] = vetor[filho];
                    pai = filho;
                    filho = 2 * pai;
                }
            }
            vetor[pai] = t;
        }
    }
}