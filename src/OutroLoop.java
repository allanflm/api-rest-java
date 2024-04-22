import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double avaliacao = 0;
        double nota = 0;
        int totalNotas = 0;

        while (nota != -1){
            System.out.println("Digite a nota ou -1 para sair: ");
            nota = input.nextDouble();
            if(nota != -1){
                avaliacao += nota;
                totalNotas++;
            }
        }
        double media = avaliacao / totalNotas;
        System.out.printf("Nota final: %.2f", media);


        input.close();
    }
}
