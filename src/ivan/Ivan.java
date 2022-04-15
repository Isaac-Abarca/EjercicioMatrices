
package ivan;

import java.util.Arrays;

/**
 *
 * @author abarc
 */
public class Ivan {
    
    static int[] mayores = new int[4];

    public static void main(String[] args) {
        int[][] matriz = new int[8][8];
        llenarMatriz(matriz);
        averiguarMayores(matriz);
        cambiarPociones(matriz);
    }

    private static void averiguarMayores(int[][] matriz) {
        int cont = 0;
        int aux = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                aux = matriz[i][j];
                if (cont <= 3) {
                    mayores[cont] = aux;
                    cont++;
                    ordenar();
                } else {
                    numerosMayores(aux, mayores);
                }
            }
        }
        imprimirArray();
    }

    private static void numerosMayores(int aux, int[] mayores) {
        int cont = 0;
        for (int i = 0; i < mayores.length; i++) {
            if (mayores[i] == aux) {
                cont++;
                break;
            }
        }
        int mayor0 = mayores[0] ,mayor1=mayores[1], 
                mayor2=mayores[2], mayor3=mayores[3];
        if (cont == 0) {
            if (aux > mayores[0]) {
                mayores[3] = mayores[2];
                mayores[2] = mayores[1];
                mayores[1] = mayores[0];
                mayores[0] = aux;
            } else if (aux > mayores[1]) {
                mayores[3] = mayores[2];
                mayores[2] = mayores[1];
                mayores[1] = aux;
            } else if (aux > mayores[2]) {
                mayores[3] = mayores[2];
                mayores[2] = aux;
            } else if (aux > mayores[3]) {
                mayores[3] = aux;
            }
            
        }
    }

    private static void imprimirArray() {
        for (int i = 0; i < mayores.length; i++) {
            System.out.println(mayores[i]);
        }
        System.out.println("");
    }

    private static void ordenar() {
        for (int x = 0; x < mayores.length; x++) {
            for (int i = 0; i < mayores.length - x - 1; i++) {
                if (mayores[i] < mayores[i + 1]) {
                    int tmp = mayores[i + 1];
                    mayores[i + 1] = mayores[i];
                    mayores[i] = tmp;
                }
            }
        }
    }
    
    private static void llenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 9 + 1);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
   
    private static void cambiarPociones(int[][] matriz) {
        matriz[0][0] = mayores[0];
        matriz[0][7] = mayores[1];
        matriz[7][0] = mayores[2];
        matriz[7][7] = mayores[3];
        imprimirMatriz(matriz);
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }

}
