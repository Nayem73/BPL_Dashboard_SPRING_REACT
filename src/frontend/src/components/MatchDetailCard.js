import { React } from 'react';
import { Link } from 'react-router-dom';

import "./MatchDetailCard.scss";

export const MatchDetailCard = ({teamName, match}) => {
    if (!match) return null;
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoute = `/teams/${otherTeam}`;
    return (
        <div className="MatchDetailCard">
        <div>
          <span className="vs">vs</span>
          <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>

          <h2 className="match-date">{match.date}</h2>
          <h3 className="match-venue">at {match.venue}</h3>
          <h3 className="match-result">{match.matchWinner} won by {match.result}</h3>
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
          <h3>Player of the Match</h3>
          <p>{match.playerOfMatch}</p>
          <h3>Umpires</h3>
          <p>{match.umpire1}, {match.umpire2}</p>
          
        </div>

        </div>
  );
}
