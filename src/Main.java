public class Main {
    public static void main(String[] args) {
        System.out.println("Esse é o Screen Match!");
        System.out.println("Filme: Blade Runner 2049");

        int anoDeLancamento = 2017;
        System.out.println("Ano de lançamento: " + anoDeLancamento);

        boolean incluidoNoPlano = true;
        System.out.println("Esse filme esta incluido no plano: " + incluidoNoPlano);

        double notaDoFilme = 8.0;
        System.out.println("Nota do filme: " + notaDoFilme);

        // Calculando a media do filme:
        double media = (9.4 + 8.0 + 6.4) / 3;
        System.out.println("Média do filme: " + media);

        String sinopse;
        sinopse = """
                Filme: Blade Runner 2049
                Sinopse: é um filme de ficção cientifica.
                Ano de lançamento:
                """ + anoDeLancamento;
        System.out.println(sinopse);

        int classificacao = (int) (media /  2);
        String classificacaoString = String.format("Esse filme tem %d estrelas", classificacao);
        System.out.println(classificacaoString);
    }
}