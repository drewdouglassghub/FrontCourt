package net.drewdouglass.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="teams")
@DynamicUpdate
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teamid;
	@Column(name = "TEAMNAME")
	private String teamname;
	@Column(name = "COACH")
	private String coach;
	@Column(name = "TEAMCAPTAIN")
	private String teamcaptain;
	@Column(name = "WINS")
	private int wins;
	@Column(name = "LOSES")
	private int losses;
	@Column(name = "TIES")
	private int ties;
	
	public Team() {
		
	}

	public Team(long teamid, String teamname, String coach, String teamcaptain, int wins, int losses, int ties) {
		super();
		this.teamid = teamid;
		this.teamname = teamname;
		this.coach = coach;
		this.teamcaptain = teamcaptain;
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
	}

	public long getTeamid() {
		return teamid;
	}

	public void setTeamid(long teamid) {
		this.teamid = teamid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getTeamcaptain() {
		return teamcaptain;
	}

	public void setTeamcaptain(String teamcaptain) {
		this.teamcaptain = teamcaptain;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}

	@Override
	public String toString() {
		return "Team [teamid=" + teamid + ", teamname=" + teamname + ", coach=" + coach + ", teamcaptain=" + teamcaptain
				+ ", wins=" + wins + ", losses=" + losses + ", ties=" + ties + "]";
	}
	
	
	
}
