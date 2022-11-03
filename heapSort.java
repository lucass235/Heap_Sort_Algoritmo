
public class heapSort {

    public static void main(String[] args) {
        int[] arr = { 55, 10, 33, 22, 11, 25 };

        // heapSortAlgorithm(arr);

        heapSortAlgorithmIterative(arr, arr.length);

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
        int raiz = i;                                             // 1                                  
        int esquerda = 2 * i + 1;                                 // 1
        int direita = 2 * i + 2;                                  // 1
        if (esquerda < n && vetor[esquerda] > vetor[raiz])        // 1
            raiz = esquerda;                                      // 1
        if (direita < n && vetor[direita] > vetor[raiz])          // 1
            raiz = direita;                                       // 1
        if (raiz != i) {                                          // 1
            int aux = vetor[i];                                   // 1
            vetor[i] = vetor[raiz];                               // 1
            vetor[raiz] = aux;                                    // 1
            heap(vetor, n, raiz);                                 // T(n - 1)
        }
    }
    // função de recorrência 
    // T(n) = T(n-1) + 11

     
    // T(1) = 1 -> caso base            

    // Cn >= T(n)
    // C >= T(1)
    // C >= 1

    // Kn <= T(n)
    // K <= T(1)
    // K <= 1

    // caso intermediário
    // Cn >= T(n)
    // C(n-1) >= T(n-1)

    // Kn <= T(n)
    // K(n-1) <= T(n-1)

    // caso original
    // Cn >= T(n)
    // Cn >= T(n-1) + 11
    // C >= T(1-1) + 11
    // C >= 11
    // C = 11

    // Kn <= T(n)
    // Kn <= T(n-1) + 11
    // K <= T(1-1) + 11
    // K <= 11
    // K = 11


    public static void heapSortAlgorithmIterative(int vetor[], int n) { 
                                                                                         //Custo | Repetição  | custo total
        int i = n / 2;                                                                    // 2T  | 1          | 2T                              
        int pai, filho, t;                                                                // 3T  | 1          | 3T
        while (true) {                                                                    // 1T  | n + 1      | T(n + 1)
            if (i > 0) {                                                                  // 1T  | n + 1      | T(n + 1)
                i--;                                                                      // 2T  | n          | 2T(n)
                t = vetor[i];                                                             // 2T  | n          | 2T(n)
            } else {
                n--;                                                                      // 2T  | n + 1      | 2T(n + 1)
                if (n == 0)                                                               // 1T  | n + 1      | T(n + 1)
                    return;        
                t = vetor[n];                                                             // 2T  | n          | 2T(n)
                vetor[n] = vetor[0];                                                      // 3T  | n          | 3T(n)
            }
            pai = i;                                                                      // 1T  | n          | T(n)
            filho = i * 2 + 1;                                                            // 3T  | n          | 3T(n)
            while (filho < n) {                                                           // 1T  | n * (n +1) | T(n^2 + n)
                if ((filho + 1 < n) && (vetor[filho + 1] > vetor[filho]))                 // 6T  | n * n      | 6T(n^2)
                    filho++;                                                              // 2T  | n * n      | 2T(n^2)
                if (vetor[filho] > t) {                                                   // 2T  | n * n      | 2T(n^2)
                    vetor[pai] = vetor[filho];                                            // 3T  | n * n      | 3T(n^2)
                    pai = filho;                                                          // 1T  | n * n      | T(n^2)
                    filho = pai * 2 + 1;                                                  // 3T  | n * n      | 3T(n^2)
                } else {
                    break;
                }
            }
            vetor[pai] = t;                                                               // 2T  | n          | 2T(n)
        } 
    }

    // tempo de execução do algoritmo de ordenação heapSort interativo
    // T(n) = 2T + 3T + T(n + 1) + T(n + 1) + 2T(n) + 2T(n) + 2T(n + 1) + T(n + 1) + 
    // 2T(n) + 3T(n) + T(n) + 3T(n) + T(n^2 + n) + 6T(n^2) + 2T(n^2) + 2T(n^2) + 3T(n^2) + T(n^2) + 3T(n^2) + 2T(n)
    // T(n) = 10T + 22T(n) + 19T(n^2) 

    // notação assintótica O(n^2)
    // Cn^2 >= 10T + 22T(n) + 19T(n^2)
    // C >= 10T/n^2 + 22T(n)/n^2 + 19T(n^2)/n^2
    // C >= 10T/n^2 + 22T/n + 19T
    // Limite de (10T/n^2) e (22T/n) é 0
    // C >= 0 + 0 + 19T
    // C = 19T com n = 1

    // notação assintótica Ώ(n)
    // C <= 10T/n^2 + 22T/n + 19T
    // C <= 10T/1 + 22T/1 + 19T -> n = 1
    // C <= 10T + 22T + 19T
    // C <= 51T
    // C = 51T com n = 1



}


// Tempo do interativo

// T(n) = 10T + 22T(n) + 19T(n^2)

// tempo do recursivo

// T(n) = T(n - 1) + 11