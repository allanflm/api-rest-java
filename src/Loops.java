import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double avaliacao = 0;
        double nota = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite uma nota para o filme: ");
            nota = input.nextInt();
            avaliacao += nota;
        }

        double media = avaliacao / 3;
        System.out.printf("Nota final: %.2f", media);


        input.close();
    }
}
