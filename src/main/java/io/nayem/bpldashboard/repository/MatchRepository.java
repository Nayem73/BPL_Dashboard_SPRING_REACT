package io.nayem.bpldashboard.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.nayem.bpldashboard.data.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2);
    
}
