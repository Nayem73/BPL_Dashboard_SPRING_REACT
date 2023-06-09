import { React, useEffect, useState } from 'react';
import { useParams, Link } from 'react-router-dom';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { MatchSmallCard } from '../components/MatchSmallCard';

import './MatchPage.scss';
import { YearSelector } from '../components/YearSelector';

export const MatchPage = () => {
  
  const [matches, setMatches] = useState([]);
  const { teamName, year } = useParams();

  useEffect(
    () => {
        const fetchMatches = async() => {
            const response = await fetch(`http://localhost:8080/team/${teamName}/matches?year=${year}`);
            const data = await response.json();
            setMatches(data);
        };
        fetchMatches();


    }, [teamName, year]
  );

  // if (!matches.year) {
  //   return <h1>Team not found</h1>
  // }

  return (
    <div className="MatchPage">
        <div className="year-selector">
          <h3>Select Year</h3>
          <YearSelector teamName={teamName} />
          <div className="back-to-home"> <Link to={`/`}>Back to Teams</Link> </div>
        </div>
        
        <div>
          <h1 className="page-heading">{teamName} matches in {year}</h1>
           
          {
            matches.length ?
            matches.map(match => <MatchDetailCard teamName={teamName} match={match}/>) : 
            <h1 className="not-played">{teamName} did not play in {year}</h1>
          }

        </div>
    </div>
  );
}
