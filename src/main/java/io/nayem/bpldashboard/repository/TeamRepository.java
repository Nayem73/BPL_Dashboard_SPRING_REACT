package io.nayem.bpldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.nayem.bpldashboard.data.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
    
    Team findByTeamName(String teamName);
    
}
