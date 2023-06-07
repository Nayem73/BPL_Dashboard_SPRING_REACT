package io.nayem.bpldashboard.data.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Match {
    @Id
    private long id;
    private String season;
    private String matchNo;
    private LocalDate date;
    private String team1;
    private String team1Score;
    private String team2;
    private String team2Score;
    private String playerOfMatch;
    private String tossWinner;
    private String tossDecision;
    private String matchWinner;
    private String venue;
    private String city;
    private String winByWickets;
    private String winByRuns;
    private String result;
    private String umpire1;
    private String umpire2;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    public String getMatchNo() {
        return matchNo;
    }
    public void setMatchNo(String matchNo) {
        this.matchNo = matchNo;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getTeam1() {
        return team1;
    }
    public void setTeam1(String team1) {
        this.team1 = team1;
    }
    public String getTeam1Score() {
        return team1Score;
    }
    public void setTeam1Score(String team1Score) {
        this.team1Score = team1Score;
    }
    public String getTeam2() {
        return team2;
    }
    public void setTeam2(String team2) {
        this.team2 = team2;
    }
    public String getTeam2Score() {
        return team2Score;
    }
    public void setTeam2Score(String team2Score) {
        this.team2Score = team2Score;
    }
    public String getPlayerOfMatch() {
        return playerOfMatch;
    }
    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }
    public String getTossWinner() {
        return tossWinner;
    }
    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }
    public String getTossDecision() {
        return tossDecision;
    }
    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }
    public String getMatchWinner() {
        return matchWinner;
    }
    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }
    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getWinByWickets() {
        return winByWickets;
    }
    public void setWinByWickets(String winByWickets) {
        this.winByWickets = winByWickets;
    }
    public String getWinByRuns() {
        return winByRuns;
    }
    public void setWinByRuns(String winByRuns) {
        this.winByRuns = winByRuns;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getUmpire1() {
        return umpire1;
    }
    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }
    public String getUmpire2() {
        return umpire2;
    }
    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }
    

    
   
    
}
