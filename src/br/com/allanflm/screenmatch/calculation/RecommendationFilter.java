package br.com.allanflm.screenmatch.calculation;

public class RecommendationFilter {
    public void filter(Sortable sortable){
        if (sortable.getClassification() >= 4) {
            System.out.println("It's one of my favorites at the moment");
        }else if(sortable.getClassification() >= 2){
            System.out.println("Very well rated at the moment");
        }else{
            System.out.println("Put it on your list to watch later");
        }
    }
}
