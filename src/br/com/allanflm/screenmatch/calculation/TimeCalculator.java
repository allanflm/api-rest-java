package br.com.allanflm.screenmatch.calculation;

import br.com.allanflm.screenmatch.model.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void includes(Title title) {
        System.out.println("Adding duration in minutes " + title);
        this.totalTime = title.getDurationInMinutes();
    }

}
