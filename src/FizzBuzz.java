public class FizzBuzz {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) { // For que vai de 1 a 100

            if (i % 3 == 0 && i % 5 == 0) { // Caso seja divisível por 3 e 5 e não sobre resto = "FizzBuzz"
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) { // Caso seja divisível por 3 e não sobre resto = "Fizz"
                System.out.print("Fizz ");
            } else if (i % 5 == 0) { // Caso seja divisível por 5 e não sobre resto = "Buzz"
                System.out.print("Buzz ");
            } else { // Se não se encaixar em nenhuma das conferências = Printa o número
                System.out.print(i + " ");
            }
        }
    }
}
