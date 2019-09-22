package net.drewdouglass.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;



@Entity
@Table(name="coach")
@DynamicUpdate
public class Coach {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long coachid;
	@Column(name = "COACHFIRSTNAME")
	private String coachfirstname;
	@Column(name = "COACHLASTNAME")
	private String coachlastname;
	@Column(name = "COACHEMAIL")
	private String coachemail;
	@Column(name = "COACHPHONE")
	private String coachphone;
	@Column(name = "COACHUSERNAME")
	private String coachusername;
	@Column(name = "COACHPASSWORD")
	private String coachpassword;
	@Column(name = "AUTHORIZATION")
	private String authorization;
	
	@Column(name="coachid",nullable = true)
	@OneToMany(cascade=CascadeType.ALL)
	private List<Team> teams;
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "coachid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team team;*/
	
	public Coach() {
	
	}
	
	public Coach(long coachid, String coachfirstname, String coachlastname, String coachemail, String coachphone,
			String coachusername, String coachpassword, String authorization) {
	
		this.coachid = coachid;
		this.coachfirstname = coachfirstname;
		this.coachlastname = coachlastname;
		this.coachemail = coachemail;
		this.coachphone = coachphone;
		this.coachusername = coachusername;
		this.coachpassword = coachpassword;
		this.authorization = authorization;
	}

	public long getCoachid() {
		return coachid;
	}

	public void setCoachid(long coachid) {
		this.coachid = coachid;
	}

	public String getCoachfirstname() {
		return coachfirstname;
	}

	public void setCoachfirstname(String coachfirstname) {
		this.coachfirstname = coachfirstname;
	}

	public String getCoachlastname() {
		return coachlastname;
	}

	public void setCoachlastname(String coachlastname) {
		this.coachlastname = coachlastname;
	}

	public String getCoachemail() {
		return coachemail;
	}

	public void setCoachemail(String coachemail) {
		this.coachemail = coachemail;
	}

	public String getCoachphone() {
		return coachphone;
	}

	public void setCoachphone(String coachphone) {
		this.coachphone = coachphone;
	}

	public String getCoachusername() {
		return coachusername;
	}

	public void setCoachusername(String coachusername) {
		this.coachusername = coachusername;
	}

	public String getCoachpassword() {
		return coachpassword;
	}

	public void setCoachpassword(String coachpassword) {
		this.coachpassword = coachpassword;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	
	
	

}
