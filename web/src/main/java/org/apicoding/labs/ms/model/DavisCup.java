package org.apicoding.labs.ms.model;

/**
 * Created by Nous on 19/10/2016.
 */
public class DavisCup {
    private Integer year;
    private String winner;
    private String runnerUp;
    private String score;

    public DavisCup(Integer year, String winner, String runnerUp, String score) {
        this.year = year;
        this.winner = winner;
        this.runnerUp = runnerUp;
        this.score = score;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getRunnerUp() {
        return runnerUp;
    }

    public void setRunnerUp(String runnerUp) {
        this.runnerUp = runnerUp;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
