package net.drewdouglass.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="SHOOTING_STATS")
public class ShootingStats {

	@Id
	@Column(name="ID")
	private int id;
	@Column(name="fieldgoalsmade")
	private int fieldgoalsmade;
	@Column(name="fieldgoalstaken")
	private int fieldgoalstaken;
	@Column(name="freethrowsmade")
	private int freethrowsmade;
	@Column(name="freethrowstaken")
	private int freethrowstaken;
	@Column(name="threepointersmade")
	private int threepointersmade;
	@Column(name="threepointerstaken")
	private int threepointerstaken;
	@Column(name="fgpct")
	private double fgpct;
	@Column(name="ftpct")
	private double ftpct;
	@Column(name="tppct")
	private double tppct;
	
	public ShootingStats() {
		super();
	};
	
	public ShootingStats(int fieldgoalsmade, int fieldgoalstaken, int freethrowsmade, int freethrowstaken,
			int threepointersmade, int threepointerstaken, double fgpct, double ftpct, double tppct) {
		super();
		this.fieldgoalsmade = fieldgoalsmade;
		this.fieldgoalstaken = fieldgoalstaken;
		this.freethrowsmade = freethrowsmade;
		this.freethrowstaken = freethrowstaken;
		this.threepointersmade = threepointersmade;
		this.threepointerstaken = threepointerstaken;
		this.fgpct = fgpct;
		this.ftpct = ftpct;
		this.tppct = tppct;
	}

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

	public double getFgpct() {
		return fgpct;
	}

	public void setFgpct(double fgpct) {
		this.fgpct = fgpct;
	}

	public double getFtpct() {
		return ftpct;
	}

	public void setFtpct(double ftpct) {
		this.ftpct = ftpct;
	}

	public double getTppct() {
		return tppct;
	}

	public void setTppct(double tppct) {
		this.tppct = tppct;
	}

	
	
	
}
