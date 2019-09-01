package net.drewdouglass.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="player")
@DynamicUpdate
public class Player {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playerid;		
	@Column(name="JERSEYNUM")
	private long jerseynum;	
	@Column(name="FIRSTNAME")
	private String firstname;
	@Column(name="LASTNAME")
	private String lastname;
	@Column(name="AGE")
	private long age;
	@Column(name="PLAYERPOS")
	private String playerpos;
	@Column(name="HEIGHT")
	private String height;
	@Column(name="WEIGHT")
	private String weight;
	
	
	//public byte[] playerpic;
	
	public Player() {
		
	}

	public Player(long jerseynum, String firstname, String lastname, long age, String playerpos,
			String height, String weight) {
		super();
		this.jerseynum = jerseynum;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.playerpos = playerpos;
		this.height = height;
		this.weight = weight;
	
	}

	public long getPlayerid() {
		return playerid;
	}


	public long getJerseynum() {
		return jerseynum;
	}

	public void setJerseynum(int jerseynum) {
		this.jerseynum = jerseynum;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	/*public ShootingStats getShootingStats(){
		return stats;
	}
	
	public void setShootingStats(ShootingStats stats) {
		this.stats = stats;
	}*/

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getPlayerpos() {
		return playerpos;
	}

	public void setPlayerpos(String playerpos) {
		this.playerpos = playerpos;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Player [playerid=" + playerid + ", jerseynum=" + jerseynum + ", firstname=" + firstname + ", lastname="
				+ lastname + ", age=" + age + ", playerpos=" + playerpos + ", height=" + height + ", weight=" + weight
				+ "]";
	}


	
	
}
