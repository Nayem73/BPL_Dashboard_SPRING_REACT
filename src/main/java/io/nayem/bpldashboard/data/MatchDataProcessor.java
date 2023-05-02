package io.nayem.bpldashboard.data;

import java.time.LocalDateTime;

import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import ch.qos.logback.classic.Logger;
import io.nayem.bpldashboard.data.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {
    private static final Logger log = LoggerFactory.getLogger(PersonItem);

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        Match match = new Match();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setSeason(matchInput.getSeason());

        match.setMatchNo(Long.parseLong(matchInput.getMatch_no()));
        match.setDate(LocalDateTime.parse(matchInput.getDate()));

        //set Team1 and Team2 depending on innings order
        String firstInningsTeam, secondInningsTeam;
        Long firstInningsTeamScore, secondInningsTeamScore;
        if ("bat first".equals(matchInput.getToss_decision())) {
            firstInningsTeam = matchInput.getToss_winner();
            firstInningsTeamScore = firstInningsTeam.equals(matchInput.getTeam_1()) ? Long.parseLong(matchInput.getTeam_1_score()) : Long.parseLong(matchInput.getTeam_2_score());
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam_1()) ? matchInput.getTeam_2() : matchInput.getTeam_1();
            secondInningsTeamScore = secondInningsTeam.equals(matchInput.getTeam_2()) ? Long.parseLong(matchInput.getTeam_2_score()) : Long.parseLong(matchInput.getTeam_1_score());
        } else {
            secondInningsTeam = matchInput.getToss_winner();
            secondInningsTeamScore = secondInningsTeam.equals(matchInput.getTeam_1()) ? Long.parseLong(matchInput.getTeam_1_score()) : Long.parseLong(matchInput.getTeam_2_score());
            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam_1()) ? matchInput.getTeam_2() : matchInput.getTeam_1();
            firstInningsTeamScore = firstInningsTeam.equals(matchInput.getTeam_2()) ? Long.parseLong(matchInput.getTeam_2_score()) : Long.parseLong(matchInput.getTeam_1_score());
        }

        match.setTeam1(firstInningsTeam);
        match.setTeam1Score(firstInningsTeamScore);

        match.setTeam2(secondInningsTeam);
        match.setTeam2Score(secondInningsTeamScore);

        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setMatchWinner(matchInput.getWinner());
        match.setVenue(matchInput.getVenue());
        match.setCity(matchInput.getCity());
        
        match.setWinByWickets(Long.parseLong(matchInput.getWin_by_wickets()));
        match.setWinByRuns(Long.parseLong(matchInput.getWin_by_runs()));

        match.setResult(matchInput.getResult());
        match.setUmpire1(matchInput.getUmpire_1());
        match.setUmpire2(matchInput.getUmpire_2());

        

        return match;
    }
}
