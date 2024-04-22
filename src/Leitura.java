import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do filme: ");
        String filme = input.nextLine();

        System.out.println("Digite o ano de lançamento: ");
        int anoDeLancamento = input.nextInt();

        System.out.println("Digite a nota do filme: ");
        double avaliacao = input.nextDouble();

        System.out.println(filme);
        System.out.println(anoDeLancamento);
        System.out.println(avaliacao);

    }
}
