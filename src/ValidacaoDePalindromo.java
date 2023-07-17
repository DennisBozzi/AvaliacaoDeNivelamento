public class ValidacaoDePalindromo {
    public static void main(String[] args) {

        // Palindromo passado como argumento
        String palindromo = "45554";

        if (isPalindromo(palindromo)) {
            System.out.println("Verdadeiro");
        } else {
            System.out.println("Falso");
        }
    }

    static boolean isPalindromo(String palindromo) { // Função isPalindromo, requer uma string como parâmetro

        boolean validacao;

        String[] vetorPalindromo = palindromo.split("");

        int tamanhoPalindromo = vetorPalindromo.length - 1; //Vetores começam com a posição em 0, ou seja, a última posição será o tamanho do vetor - 1.

        // Nosso loop percorre metade do vetor, comparando a útlima posição com a primeira e assim por diante.
        for (int i = 0; i < tamanhoPalindromo / 2; i++) {

            if (!vetorPalindromo[i].equals(vetorPalindromo[tamanhoPalindromo - i])) { // Caso os campos não coincidam, retorna falso
                return validacao = false;
            }

        }

        return validacao = true; //Caso os campos coincidam, retorna true
    }

}
