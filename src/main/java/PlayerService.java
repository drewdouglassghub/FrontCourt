import org.springframework.stereotype.Service;

import net.drewdouglass.Entity.Player;

@Service
public interface PlayerService {

	public abstract void addPlayer(Player player);
	public abstract void editPlayer(Long id, Player player);
	public abstract void deletePlayer(Long id, Player player);
	public abstract void viewAllPlayers(Player player);
	
}
