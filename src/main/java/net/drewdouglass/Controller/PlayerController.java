package net.drewdouglass.Controller;

import javax.persistence.EntityManager;
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


import net.drewdouglass.Dao.OffenseRepo;
import net.drewdouglass.Dao.PlayerRepository;
import net.drewdouglass.Entity.Player;
import net.drewdouglass.Entity.OffensiveStats;



@Controller
@RequestMapping
@SessionAttributes({"player"})
public class PlayerController {
	
	  @ModelAttribute("player")
	   public Player setUpPlayerForm() {
	      return new Player();
	   }
	
	@Autowired
	PlayerRepository playerRepo;
	
	@Autowired
	OffenseRepo oRepo;
	
	@GetMapping("/viewAll")
	public String viewAllPlayers(Model model) {
		model.addAttribute("player", playerRepo.findAll());
		return "viewAllPlayers";
	}
	
	
	@GetMapping("/addPlayer")
	public String addNewPlayer(Model model) {
		Player p = new Player();
		model.addAttribute("newPlayer", p);
		return "addPlayer";
	}
	
	@PostMapping("/addPlayer")
	public String addNewPlayer(@ModelAttribute Player p, Model model) {
		System.out.println("saving new player");
		System.out.println(p.toString());
		
		OffensiveStats o = new OffensiveStats();

		p.setOffensiveStats(o);
		
		o.setPlayer(p);
		playerRepo.save(p);		
		
		model.addAttribute("player", playerRepo.findAll());
		return "viewAllPlayers";
	}
	
	
	
	/* ***************************** Offensive stat controls  *************************************** */
	
	@RequestMapping("/offenseStats/{id}")
	public String showOffensiveStatsByPlayer(@PathVariable("id") long id, Model model) {
		Player player = playerRepo.findByPlayerid(id);
		
		System.out.println(player.toString());
		
		OffensiveStats stats = oRepo.findById(id);
	
		double fgpct = 0.0;
		double ftpct = 0.0;
		double tppct = 0.0;
		
		fgpct = (double) stats.getFieldgoalsmade() / stats.getFieldgoalstaken() * 100;
		ftpct = (double) stats.getFreethrowsmade() / stats.getFreethrowstaken() * 100;
		tppct = (double) stats.getThreepointersmade() / stats.getThreepointerstaken() * 100;
		
		model.addAttribute("player", player);		
		model.addAttribute("stats", stats);
		model.addAttribute("fgpct", fgpct);
		model.addAttribute("ftpct", ftpct);
		model.addAttribute("tppct", tppct);
		return "showOffensiveStats";		
	}
	
	@GetMapping("/editOffensiveStats/{id}")
	public String showOffenseUpdateForm(@PathVariable("id") long id, Model model) {

		OffensiveStats stats = oRepo.findById(id);
		
		model.addAttribute(stats);
		
		return "updateOffensiveStats"; 
		
	}
	
	@PostMapping("/updateOffensiveStats/{id}")
	public String updateOffensiveStats(@PathVariable("id") long id, @Valid OffensiveStats offensiveStats, BindingResult result, Model model) {
		
		oRepo.save(offensiveStats);
		model.addAttribute("player", playerRepo.findAll());
		return "viewAllPlayers";
	}
	
	/*@GetMapping("/viewOrderDetails/{id}")
	public String viewOrderDetails(@PathVariable("id") long id, User user, Model model) {
		OrderItems oi = oiRepo.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("orderitems", oi);
		return "viewOrderDetails";
	}*/
	
}
