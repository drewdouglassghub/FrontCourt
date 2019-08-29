package net.drewdouglass.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.drewdouglass.Dao.PlayerRepository;
import net.drewdouglass.Dao.StatRepository;
import net.drewdouglass.Entity.Player;



@Controller
public class PlayerController {

	
	@Autowired
	PlayerRepository playerRepo;
	
	@Autowired
	StatRepository statRepo;
	
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
		playerRepo.save(p);
		model.addAttribute("player", playerRepo.findAll());
		return "viewAllPlayers";
	}
	
	
	
	/* ***************************** Offensive stat controls  *************************************** */
	
	@GetMapping("/offenseStats/{id}")
	public String showOffensiveStatsByPlayer(@PathVariable("id") int id, Model model) {
		Player p = playerRepo.findById((long) id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id: "+ id));
		model.addAttribute("player", p);
		return "showOffenseStats";		
	}
	
	
	
}
