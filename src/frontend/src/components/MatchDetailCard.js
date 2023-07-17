import { React } from 'react';
import { Link } from 'react-router-dom';

import "./MatchDetailCard.scss";

export const MatchDetailCard = ({teamName, match}) => {
  if (!match) return null;
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoute = `/teams/${otherTeam}`;
    const isMatchWon = teamName == match.matchWinner;
    const isLive = match.playerOfMatch;
    const isTeam2Score = match.team2Score;

    return (
        <div className={isMatchWon ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card'}>
        <div>
          <span className="vs">vs</span>
          <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>

          <h2 className="match-date">{match.date}</h2>
          {isLive == 'live' ? (
            <h3 className="match-venue">LIVE from {match.venue}</h3>
          ) : (
            <h3 className="match-venue">at {match.venue}</h3>
          )}
          
          
          {isLive == 'live' ? (
            isTeam2Score != '0/0' ? (
              <div>
                <h3 className="match-result">Target: {match.team1Score}</h3>
                <h3 className="match-result">{match.team2} score: {match.team2Score}</h3>
                <h3 className="match-result">Overs: {match.winByWickets}</h3>
              </div>
              ) : (
                
                <div>
                  <h3 className="match-result">{match.team1} score: {match.team1Score}</h3>
                  <h3 className="match-result">Overs: {match.winByWickets}</h3>
                </div>
            )

          ): (
            <h3 className="match-result">{match.matchWinner} won by {match.result}</h3>                 
          )
          }
        </div>

        <div className="additional-details">
          <h3>Match No</h3>
          <p>{match.matchNo} Match of BPL Season {match.season}</p>
          <h3>City</h3>
          <p>In {match.city} City</p>
          <h3>Toss</h3>
          <p>{match.tossWinner} won the toss and chose to {match.tossDecision}</p>

          <h3>First Innings</h3>
          <p>{match.team1} scores {match.team1Score}</p>
          <h3>Second Innings</h3>
          <p>{match.team2} scores {match.team2Score}</p>

          {isLive=='live' ? (
            null
          ):
          (
            <div>
              <h3>Player of the Match</h3>
              <p>{match.playerOfMatch}</p>
            </div>
          )}

          <h3>Umpires</h3>
          <p>{match.umpire1}, {match.umpire2}</p>
          
        </div>

        </div>
  );
}
