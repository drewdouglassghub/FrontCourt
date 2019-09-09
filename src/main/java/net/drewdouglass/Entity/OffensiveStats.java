package net.drewdouglass.Entity;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="OFFENSIVE_STATS")
public class OffensiveStats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	@Column(name="fieldgoalsmade", columnDefinition="int default '0'")
	private int fieldgoalsmade;
	@Column(name="fieldgoalstaken", columnDefinition="int default '0'")
	private int fieldgoalstaken;
	@Column(name="freethrowsmade", columnDefinition="int default '0'")
	private int freethrowsmade;
	@Column(name="freethrowstaken", columnDefinition="int default '0'")
	private int freethrowstaken;
	@Column(name="threepointersmade", columnDefinition="int default '0'")
	private int threepointersmade;
	@Column(name="threepointerstaken", columnDefinition="int default '0'")
	private int threepointerstaken;
	
	
	@Formula("fieldgoalsmade/fieldgoalstaken*100")
	private double fgpct;
	
	@Formula("freethrowsmade/freethrowstaken*100")
	private double ftpct;
	
	@Formula("threepointersmade/threepointerstaken*100")
	private double tppct;
	
	@OneToOne(fetch=FetchType.LAZY, optional = false)
	@JoinColumn(name="PLAYERID", nullable=false)
	private Player playerid;
	
	public OffensiveStats() {
		super();
	};
	
	public OffensiveStats(int fieldgoalsmade, int fieldgoalstaken, int freethrowsmade, int freethrowstaken,
			int threepointersmade, int threepointerstaken) {
		super();
		this.fieldgoalsmade = fieldgoalsmade;
		this.fieldgoalstaken = fieldgoalstaken;
		this.freethrowsmade = freethrowsmade;
		this.freethrowstaken = freethrowstaken;
		this.threepointersmade = threepointersmade;
		this.threepointerstaken = threepointerstaken;
	}
	
	public Player getPlayer() {
		return playerid;
	}

	public void setPlayer(Player player) {
		this.playerid = player;
	}

	public long getOid() {
		return oid;
	}

	/*public void setPlayerid(long id) {
		this.playerid = id;
	}*/

	public int getFieldgoalsmade() {
		return fieldgoalsmade;
	}

	public void setFieldgoalsmade(int fieldgoalsmade) {
		this.fieldgoalsmade = fieldgoalsmade;
	}

	public int getFieldgoalstaken() {
		return fieldgoalstaken;
	}

	public void setFieldgoalstaken(int fieldgoalstaken) {
		this.fieldgoalstaken = fieldgoalstaken;
	}

	public int getFreethrowsmade() {
		return freethrowsmade;
	}

	public void setFreethrowsmade(int freethrowsmade) {
		this.freethrowsmade = freethrowsmade;
	}

	public int getFreethrowstaken() {
		return freethrowstaken;
	}

	public void setFreethrowstaken(int freethrowstaken) {
		this.freethrowstaken = freethrowstaken;
	}

	public int getThreepointersmade() {
		return threepointersmade;
	}

	public void setThreepointersmade(int threepointersmade) {
		this.threepointersmade = threepointersmade;
	}

	public int getThreepointerstaken() {
		return threepointerstaken;
	}

	public void setThreepointerstaken(int threepointerstaken) {
		this.threepointerstaken = threepointerstaken;
	}

	@Transient
	public double getFgpct() {		
		return fgpct;
	}
	@Transient
	public void setFgpct(double fgpct) {
		this.fgpct = fgpct;
	}

	@Transient
	public double getFtpct() {
		return ftpct;
	}

	@Transient
	public void setFtpct(double ftpct) {
		this.ftpct = ftpct;
	}

	@Transient
	public double getTppct() {
		return tppct;
	}

	@Transient
	public void setTppct(double tppct) {
		this.tppct = tppct;
	}

	@Override
	public String toString() {
		return "ShootingStats [id=" + oid + ", fieldgoalsmade=" + fieldgoalsmade + ", fieldgoalstaken=" + fieldgoalstaken
				+ ", freethrowsmade=" + freethrowsmade + ", freethrowstaken=" + freethrowstaken + ", threepointersmade="
				+ threepointersmade + ", threepointerstaken=" + threepointerstaken + ", fgpct=" + fgpct + ", ftpct="
				+ ftpct + ", tppct=" + tppct + "]";
	}

	
	
	
}