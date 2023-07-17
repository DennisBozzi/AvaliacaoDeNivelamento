import java.util.Arrays;

public class OrdenarVetorEImprimirPrimos {

    public static void main(String[] args) {

        int[] vetor = {1, 3, 2, 8, 29, 30, 7, 83, 63, 77, 67, 37, 41, 90, 97, 4, 23};

        Arrays.sort(vetor); //Organizando o vetor

        System.out.println("\nVetor organizado: " + Arrays.toString(vetor) + "\n");

        printaNumeroPrimo(vetor);

    }

    static void printaNumeroPrimo(int[] vetor) { //Função que printa os números primos e suas índices.

        for (int i = 0; i < vetor.length; i++) { //For que percorre o vetor.

            if (isPrimo(vetor[i])) {
                System.out.println("O número: " + vetor[i] + " é primo - Ele está no ídice: " + i);
            }
        }
    }

    static boolean isPrimo(int numero) { //Função que retorna um booleano com o número que está sendo conferido

        boolean isPrimo; //Booleano que é retornado

        if (numero == 1 || numero == 0) { //O número 0 e 1 não são considerados primos
            return false;
        }

        //Como todos o números são divisíveis por 1, começamos com o índice em 2. Conferímos se até o número, existe algum número que ele é divisível.
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return isPrimo = false; //Caso seja divisível retorna false;
            }
        }

        return isPrimo = true; //Caso não seja divisível retorna true;

    }

}
