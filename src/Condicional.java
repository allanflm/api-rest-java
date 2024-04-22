public class Condicional {
    public static void main(String[] args) {
        int anoDeLancamento = 2017;
        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.0;
        String tipoPlano = "normal";

        if (anoDeLancamento <= 2024) {
            System.out.println("Filme retrô que vale a pena assistir!");
        } else {
            System.out.println("Lançamento que os clientes estão curtindo!");
        }

        if (incluidoNoPlano == true || tipoPlano.equals("plus")) {
            System.out.println("Filme liberado");
        } else {
            System.out.println("Deve pagar a locação");
        }
    }
}
