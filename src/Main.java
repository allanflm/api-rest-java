public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie();
        myMovie.name = "Blade runner 2049";
        myMovie.releaseYear = 2017;

        myMovie.filmTechnicalSheet();
        myMovie.filmReview(10);
        myMovie.filmReview(8);
        myMovie.filmReview(7);
        System.out.println("return the evaluation: " + myMovie.returnTheEvaluation());

    }
}
