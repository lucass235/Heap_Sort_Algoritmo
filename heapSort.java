
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
                                                            //Repetição     
        int n = vetor.length;                                 // 1
        for (int i = n / 2 - 1;                               // 1
        i >= 0;                                               // n + 1
        i--) {                                                // n
            heap(vetor, n, i);                                // T(n - 1)
        }                               
        int temp;                                             // 1
        for (int i = n - 1;                                   // 1
        i >= 0;                                               // n + 1
        i--) {                                                // n
            temp = vetor[0];                                  // n 
            vetor[0] = vetor[i];                              // n
            vetor[i] = temp;                                  // n
            heap(vetor, i, 0);                             // T(n - 1)
        }

        
    }

    private static void heap(int vetor[], int n, int i) {
                                                                     //Repetição
        int largest = i;                                             // 1                                  
        int esquerda = 2 * i + 1;                                    // 1
        int direita = 2 * i + 2;                                     // 1
        if (esquerda < n && vetor[esquerda] > vetor[largest])        // 1
            largest = esquerda;                                      // 1
        if (direita < n && vetor[direita] > vetor[largest])          // 1
            largest = direita;                                       // 1
        if (largest != i) {                                          // 1
            int swap = vetor[i];                                     // 1
            vetor[i] = vetor[largest];                               // 1
            vetor[largest] = swap;                                   // 1
            heap(vetor, n, largest);                                 // T(n - 1)
        }
    }
    // função de recorrência 
    // T(n) = T(n-1) + 11

    public static void heapSortAlgorithmInterative(int vetor[], int n) { 
                                                                                         //Custo | Repetição
        int i = n / 2;                                                                    // 2T  | 1                                   
        int pai, filho, t;                                                                // 3T  | 1
        while (true) {                                                                    // 1T  | n + 1
            if (i > 0) {                                                                  // 1T  | n + 1
                i--;                                                                      // 2T  | n
                t = vetor[i];                                                             // 2T  | n
            } else {
                n--;                                                                      // 2T  | n + 1
                if (n == 0)                                                               // 1T  | n + 1
                    return;        
                t = vetor[n];                                                             // 2T
                vetor[n] = vetor[0];                                                      // 3T
            }
            pai = i;                                                                      // 1T
            filho = i * 2 + 1;                                                            // 3T
            while (filho < n) {                                                           // 1T
                if ((filho + 1 < n) && (vetor[filho + 1] > vetor[filho]))                 // 5T
                    filho++;                                                              // 2T
                if (vetor[filho] > t) {                                                   // 2T
                    vetor[pai] = vetor[filho];                                            // 3T
                    pai = filho;                                                          // 1T
                    filho = pai * 2 + 1;                                                  // 3T
                } else {
                    break;
                }
            }
            vetor[pai] = t;                                                               // 2T
        }
    }
}