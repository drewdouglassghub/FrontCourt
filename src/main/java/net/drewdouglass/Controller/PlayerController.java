package net.drewdouglass.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.drewdouglass.Dao.CoachRepository;
import net.drewdouglass.Dao.OffenseRepo;
import net.drewdouglass.Dao.PlayerRepository;
import net.drewdouglass.Dao.TeamRepository;

import net.drewdouglass.Entity.Player;
import net.drewdouglass.Entity.Team;
import net.drewdouglass.Entity.Coach;
import net.drewdouglass.Entity.OffensiveStats;

@Controller
@RequestMapping
@SessionAttributes({"coach", "player", "team" })
public class PlayerController {

	@ModelAttribute("player")
	public Player setUpPlayerForm() {
		return new Player();
	}
	
	@ModelAttribute("coach")
		public Coach setUpCoachForm() {
		return new Coach();
	}
	
	@ModelAttribute("team")
		public Team setUpTeamForm() {
		return new Team();
	}
	
	@Autowired
	TeamRepository teamRepo;

	@Autowired
	CoachRepository coachRepo;
	
	@Autowired
	PlayerRepository playerRepo;

	@Autowired
	OffenseRepo offenseRepo;
	
	/* ********************************Coach Controller************************** */
	
	@GetMapping("/addCoach")
	public String createCoach(Model model) {
		Coach coach = new Coach();
		model.addAttribute("coach", coach);
		return "/addCoach";
	}
	
	@PostMapping("/addCoach")
	public String createCoach(Coach coach, Model model) {
		coachRepo.save(coach);
		model.addAttribute("coach", coach);
		return "/coachProfile";
	}
	
	
	
/* *****************************Team Controller ********************************** */

	@GetMapping("/createTeam")
	public String createTeam(Model model) {
		Team t = new Team();
		model.addAttribute("team", t);
		return "/createTeam";
	}
	
	
	
	
	
	
	
/* ***********************************Player Controller *************************** */
	@GetMapping("/viewAllPlayers")
	public String viewAllPlayers(Coach coach, Player player, Model model) {
		model.addAttribute("coach", coach);
		model.addAttribute("players", playerRepo.findAll());
		
		return "viewAllPlayers";
	}

	@GetMapping("/viewPlayer/{id}")
	public String viewPlayer(@PathVariable ("id") long id, Model model) {
		
		Player player = playerRepo.findByPlayerid((long) id);
		
		model.addAttribute("player", player);
		return "/viewPlayer";
	}
		
	@GetMapping("/addPlayer")
	public String addNewPlayer(Model model) {
		Player player = new Player();
		model.addAttribute("player", player);
		return "/addPlayer";
	}

	@PostMapping("/addPlayer")				//place has generated id by post -- get it and use it to display player
	public String addNewPlayer(@ModelAttribute Player player, Model model) {
		System.out.println("setting up new player");
		OffensiveStats o = new OffensiveStats();
		o.setPlayer(player);
		player.setOffensiveStats(o);
		System.out.println(player.toString());
		
		playerRepo.save(player);

		model.addAttribute("player", playerRepo.findAll());
		return "/viewAllPlayers";
	}

	@GetMapping("/editPlayerInfo/{id}")
	public String editPlayerInfo(@PathVariable("id") long id, @Valid Player player, BindingResult result, Model model) {

		player = playerRepo.findByPlayerid(id);
		System.out.println(player.toString());
		
		model.addAttribute("player", player);
		return "updatePlayerInfo";
	}
	
	@PostMapping("/updatePlayerInfo/{id}")
	public String updatePlayerInfo(@PathVariable("id") long id, @Valid Player player, BindingResult result, Model model) {
		
		Player p = player;
		playerRepo.save(p);

		model.addAttribute("player", p);
		return "viewPlayer";	
	}
	
	@GetMapping("/deletePlayer/{playerid}")
	public String deletePlayer(@PathVariable("playerid") long playerid, Model model) {
		Player p = playerRepo.findByPlayerid((long) playerid);
		playerRepo.deleteById(p.getPlayerid());
		model.addAttribute("player", playerRepo.findAll());
		return "viewAllPlayers";
	}
	
	/*
	 * ***************************** Offensive stat controls *************************************
	 * ***************************************
	 */

	@GetMapping("/offenseStats/{id}")
	public String showOffensiveStatsByPlayer(@PathVariable("id") long id, Model model) {

		Player player = playerRepo.findByPlayerid(id);
		OffensiveStats stats = offenseRepo.findById(id);

		System.out.println(player.toString());
		System.out.println(stats.toString());

		model.addAttribute("player", player);
		model.addAttribute("stats", stats);
		model.addAttribute("fgpct", findFgPct(stats.getFieldgoalsmade(), stats.getFieldgoalstaken()));
		model.addAttribute("ftpct", findFtPct(stats.getFreethrowsmade(), stats.getFreethrowstaken()));
		model.addAttribute("tppct", findTpPct(stats.getThreepointersmade(), stats.getThreepointerstaken()));
		return "showOffensiveStats";
	}

	@GetMapping("/editOffensiveStats/{id}")
	public String showOffenseUpdateForm(@PathVariable("id") long id, Model model) {

		OffensiveStats stats = offenseRepo.findById(id);

		model.addAttribute(stats);

		return "updateOffensiveStats";

	}

	@PostMapping("/updateOffensiveStats/{id}")
	public String updateOffensiveStats(@PathVariable("id") long id, @Valid OffensiveStats offensiveStats,
			BindingResult result, Model model) {

		OffensiveStats stats = offensiveStats;
		System.out.println(stats.toString());
		offenseRepo.save(stats);

		double fgpct = findFgPct(stats.getFieldgoalsmade(), stats.getFieldgoalstaken());
		double ftpct = findFtPct(stats.getFreethrowsmade(), stats.getFreethrowstaken());
		double tppct = findTpPct(stats.getThreepointersmade(), stats.getThreepointerstaken());

		model.addAttribute("player", playerRepo.findByPlayerid(id));
		model.addAttribute("stats", stats);
		model.addAttribute("fgpct", fgpct);
		model.addAttribute("ftpct", ftpct);
		model.addAttribute("tppct", tppct);
		return "showOffensiveStats";
	}

	

//********* Controller Methods *************

	public double findFgPct(double double1, double double2) {

		double fgpct = 0;
		fgpct = double1 / double2 * 100;
		return fgpct;
	}

	public double findFtPct(double double1, double double2) {

		double ftpct = 0;
		ftpct = double1 / double2 * 100;
		return ftpct;
	}

	public double findTpPct(double double1, double double2) {

		double tppct = 0;
		tppct = double1 / double2 * 100;
		return tppct;
	}
}
