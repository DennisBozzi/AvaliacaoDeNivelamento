import java.util.Scanner;

public class Fatorial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int fatorial;
        int produto = 1;

        System.out.print("Digite um número: ");

        fatorial = sc.nextInt(); // Atribuindo a escolha do usuário a variável

        for(int i = fatorial; i >= 1; i--){
            System.out.print(i); // Printa o número que está multiplicando

            if (i != 1){ // Quando estiver multiplicando o número 1, não mostra o X
                System.out.print(" x ");
            }

            produto = produto * i; // Fazendo a multiplicação do fatorial
        }

        System.out.print(" = " + produto); // Printa o resultado do fatorial
    }

}
